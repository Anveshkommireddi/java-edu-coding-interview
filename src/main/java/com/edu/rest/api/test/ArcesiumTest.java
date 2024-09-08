package com.edu.rest.api.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.edu.rest.api.test.bean.ArcesiumUser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ArcesiumTest {

	public static void main(String[] args) {
		String url = "https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";
		String response = triggerRestCall(url);
		Gson gson = new Gson();
		TypeToken<List<ArcesiumUser>> arcesiumUserListToken = new TypeToken<List<ArcesiumUser>>() {
		};
		Type arcesiumUserType = arcesiumUserListToken.getType();
		System.out.println(arcesiumUserType.getTypeName());
		List<ArcesiumUser> arUsersList = gson.fromJson(response, arcesiumUserType);
		List<Map<String, String>> arusersKeysList = new ArrayList<>();
		for (ArcesiumUser user : arUsersList) {
			if (null != user) {
				Map<String, String> userInfo = new HashMap<>();
				userInfo.put("id", String.valueOf(user.getId()));
				userInfo.put("name", user.getName());
				userInfo.put("username", user.getUsername());
				userInfo.put("email", user.getEmail());
				userInfo.put("website", user.getWebsite());
				if (null != user.getCompany()) {
					userInfo.put("company.name", user.getCompany().getName());
					userInfo.put("company.basename", user.getCompany().getBasename());
				}
				if (null != user.getAddress()) {
					userInfo.put("address.suite", user.getAddress().getSuite());
					userInfo.put("address.street", user.getAddress().getStreet());
					userInfo.put("address.zipcode", user.getAddress().getZipcode());
					userInfo.put("address.city", user.getAddress().getCity());
					if (null != user.getAddress().getGeo()) {
						userInfo.put("address.geo.lat", user.getAddress().getGeo().getLat());
						userInfo.put("address.geo.lng", user.getAddress().getGeo().getLng());
					}
				}
				arusersKeysList.add(userInfo);
			}
		}
		System.out.println(arusersKeysList);
	}

	private static String triggerRestCall(String apiUrl) {
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
			System.out.println(response);
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
