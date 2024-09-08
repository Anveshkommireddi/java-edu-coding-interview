package com.edu.rest.api.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import com.edu.rest.api.test.bean.Competition;
import com.edu.rest.api.test.bean.LeaugeMatchInfo;
import com.edu.rest.api.test.bean.TeamLeaugeInfo;
import com.google.gson.Gson;

public class GetWinnerTotalGoalsTest {

	public static int getWinnerTotalGoals(String competition, int year) {
		try {
			String winnerBaseUrl = "https://jsonmock.hackerrank.com/api/football_competitions";
			String winnerQueryUrl = String.format("year=%s&name=%s",
					URLEncoder.encode(String.valueOf(year), StandardCharsets.UTF_8.toString()),
					URLEncoder.encode(competition, StandardCharsets.UTF_8.toString()));
			String winnerUrl = winnerBaseUrl + "?" + winnerQueryUrl;
			String winner = getWinner(winnerUrl);
			if (null != winner) {
				String matchBaseUrl = "https://jsonmock.hackerrank.com/api/football_matches";

				String team1QueryUrl = String.format("year=%s&competition=%s&team1=%s",
						URLEncoder.encode(String.valueOf(year), StandardCharsets.UTF_8.toString()),
						URLEncoder.encode(competition, StandardCharsets.UTF_8.toString()),
						URLEncoder.encode(winner, StandardCharsets.UTF_8.toString()));
				String team1Url = matchBaseUrl + "?" + team1QueryUrl;
				int team1Goals = invokeApi(team1Url, "team1");
				System.out.println("Team1 Goals is " + team1Goals);
				String team2QueryUrl = String.format("year=%s&competition=%s&team2=%s",
						URLEncoder.encode(String.valueOf(year), StandardCharsets.UTF_8.toString()),
						URLEncoder.encode(competition, StandardCharsets.UTF_8.toString()),
						URLEncoder.encode(winner, StandardCharsets.UTF_8.toString()));
				String team2Url = matchBaseUrl + "?" + team2QueryUrl;
				int team2Goals = invokeApi(team2Url, "team2");
				System.out.println("Team2 Goals is " + team2Goals);
				return team1Goals + team2Goals;
			}
		} catch (Exception exp) {

		}
		return -1;
	}

	public static String getWinner(String apiUrl) {
		Gson gson = new Gson();
		String response = triggerRestCall(apiUrl);
		Competition result = gson.fromJson(response, Competition.class);
		if (null != result && result.getData().size() > 0) {
			return result.getData().get(0).getWinner();
		}
		return null;
	}

	public static int invokeApi(String apiUrl, String team) {
		int currPage = 1;
		int totalPages = 1;
		int teamGoals = 0;
		Gson gson = new Gson();
		while (currPage <= totalPages) {
			String pageUrl = apiUrl + "&page=" + currPage;
			// System.out.println("Page Url is " + pageUrl);
			String response = triggerRestCall(pageUrl);
			if (null != response && response.length() > 0) {
				TeamLeaugeInfo result = gson.fromJson(response, TeamLeaugeInfo.class);
				// System.out.println(result);
				if (null != result.getData() && result.getData().size() > 0) {
					List<LeaugeMatchInfo> matchInfoList = result.getData();
					for (LeaugeMatchInfo matchInfo : matchInfoList) {
						if (team.equalsIgnoreCase("team1")) {
							teamGoals += Integer.parseInt(matchInfo.getTeam1goals());
						} else if (team.equalsIgnoreCase("team2")) {
							teamGoals += Integer.parseInt(matchInfo.getTeam2goals());
						}
					}
				}
				currPage = result.getPage() + 1;
				totalPages = result.getTotal_pages();
			}
		}
		return teamGoals;
	}

	public static String triggerRestCall(String apiUrl) {
		try {
			URI uri = new URI(apiUrl);
			URL url = uri.toURL();
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			int responseCode = connection.getResponseCode();
			// System.out.println("Response Code: " + responseCode);

			String response;
			if (connection.getErrorStream() != null) {
				response = readStream(connection.getErrorStream());
			} else {
				response = readStream(connection.getInputStream());
			}
			// System.out.println(response);
			return response;
		} catch (Exception exp) {
			System.out.println(exp);
		}
		return apiUrl;
	}

	private static String readStream(InputStream stream) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
		return reader.lines().collect(Collectors.joining("\n"));
	}
}
