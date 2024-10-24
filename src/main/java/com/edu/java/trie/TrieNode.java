package com.edu.java.trie;

public class TrieNode {
	
	char curr;

	TrieNode[] children;

	boolean word;

	public TrieNode() {
		this.curr = '-';
		this.children = new TrieNode[26];
		this.word = false;
	}
	
	public TrieNode(char curr) {
		this.curr = curr;
		this.children = new TrieNode[26];
		this.word = false;
	}
}
