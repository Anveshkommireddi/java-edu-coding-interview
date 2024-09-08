package com.edu.rest.api.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.edu.rest.api.test.bean.MatchInfo;
import com.edu.rest.api.test.bean.MatchResults;
import com.google.gson.Gson;

public class PaginationRestTest {

	public List<MatchInfo> invokeApi(String apiUrl) {
		int currPage = 1;
		int totalPages = 1;
		List<MatchInfo> matchesList = new ArrayList<>();
		Gson gson = new Gson();
		while (currPage <= totalPages) {
			String pageUrl = apiUrl + "&page=" + currPage;
			String response = triggerRestCall(pageUrl);
			if (null != response) {
				MatchResults result = gson.fromJson(response, MatchResults.class);
				
				if (result.getData().size() > 0) {
					matchesList.addAll(result.getData());
				}
				currPage = result.getPage() + 1;
				totalPages = result.getTotal_pages();
			}
		}
		return matchesList;
	}

	private String triggerRestCall(String apiUrl) {
		System.out.println("API URl is :: " + apiUrl);
		try {
			URI uri = new URI(apiUrl);
			URL url = uri.toURL();
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			int responseCode = connection.getResponseCode();
			System.out.println("Response Code: " + responseCode);

			String response;
			if (connection.getErrorStream() != null) {
				response = readStream(connection.getErrorStream());
			} else {
				response = readStream(connection.getInputStream());
			}
			//System.out.println(response);
			return response;
		} catch (Exception exp) {
			System.out.println(exp);
		}
		return "";
	}

	private static String readStream(InputStream stream) throws IOException {
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
			bufferedReader = new BufferedReader(inputStreamReader);
			return bufferedReader.lines().collect(Collectors.joining("\n"));
		} finally {
			if (null != bufferedReader) {
				bufferedReader.close();
			}
			if (null != inputStreamReader) {
				inputStreamReader.close();
			}
		}
	}

}
