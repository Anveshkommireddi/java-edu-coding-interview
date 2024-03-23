package com.edu.java.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	Map<Integer, TrieNode> child = new HashMap<>();
	
	Map<Integer, Integer> count = new HashMap<>();

	boolean isEnd;

	@Override
	public String toString() {
		return "TrieNode [child=" + child + ", count=" + count + ", isEnd=" + isEnd + "]";
	}
}
