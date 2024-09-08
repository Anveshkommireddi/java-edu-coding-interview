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

import com.edu.rest.api.test.bean.MatchInfo;
import com.edu.rest.api.test.bean.MatchResults;
import com.google.gson.Gson;

public class GetTotalGoalstest {

	public static int getTotalGoals(String team, int year) {
		int result = 0;
		try {
			String baseUrl = "https://jsonmock.hackerrank.com/api/football_matches";
			String query1 = String.format("year=%s&team1=%s",
					URLEncoder.encode(String.valueOf(year), StandardCharsets.UTF_8.toString()),
					URLEncoder.encode(team, StandardCharsets.UTF_8.toString()));
			String urlString1 = baseUrl + "?" + query1;
			int team1Goals = invokeApi(urlString1, "team1");

			String query2 = String.format("year=%s&team2=%s",
					URLEncoder.encode(String.valueOf(year), StandardCharsets.UTF_8.toString()),
					URLEncoder.encode(team, StandardCharsets.UTF_8.toString()));
			String urlString2 = baseUrl + "?" + query2;
			int team2Goals = invokeApi(urlString2, "team2");

			return team1Goals + team2Goals;
		} catch (Exception exp) {
			System.err.println(exp);
		}
		return result;
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
				MatchResults result = gson.fromJson(response, MatchResults.class);
				// System.out.println(result);
				if (null != result.getData() && result.getData().size() > 0) {
					List<MatchInfo> matchInfoList = result.getData();
					for (MatchInfo matchInfo : matchInfoList) {
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
