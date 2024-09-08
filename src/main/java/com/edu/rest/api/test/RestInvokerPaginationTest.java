package com.edu.rest.api.test;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.edu.rest.api.test.bean.MatchInfo;

public class RestInvokerPaginationTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		PaginationRestTest rest = new PaginationRestTest();
		String baseUrlOld = "https://jsonmock.hackerrank.com/api/football_matches";
		String queryOld = String.format("year=%s", "2011");
		String urlStringOld = baseUrlOld + "?" + queryOld;
		System.out.println(urlStringOld);
		List<MatchInfo> matchesList = rest.invokeApi(urlStringOld);
		System.out.println(matchesList);
	}

}
