package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//LC :: 44
public class DP_34_WildCard_Matching {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_34_WildCard_Matching.class);

	public static void main(String[] args) {
		String input = "acdcb";
		String pattern = "a*c?b";
		boolean isMatching = isMatch(input, input.length() - 1, pattern, pattern.length() - 1);
		LOGGER.info("Is Matching {}", isMatching);
	}

	private static boolean isMatch(String s, int sIdx, String p, int pIdx) {
		if(sIdx < 0 && pIdx < 0) return true;
		if(sIdx >= 0 && pIdx < 0) return false;
		if(pIdx >= 0 && sIdx < 0) {
			for(int i = 0; i <= pIdx; i++) {
				if(p.charAt(i) != '*') return false;
			}
			return true;
		}
		char pchar = p.charAt(pIdx);
		char schar = s.charAt(sIdx);
		if (schar == pchar || pchar == '?') {
			return isMatch(s, sIdx - 1, p, pIdx - 1);
		} else if (pchar == '*') {
			return isMatch(s, sIdx - 1, p, pIdx) || isMatch(s, sIdx, p, pIdx - 1);
		}
		return false;
	}

}
