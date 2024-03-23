package com.edu.java.trie;

import java.util.Optional;

public class Trie {

	TrieNode root;

	Trie() {
		this.root = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode currNode = this.root;
		for (int i = 0; i < word.length(); i++) {
			char currChar = word.charAt(i);
			int currIdx = currChar - 'a';
			TrieNode childNode = Optional.ofNullable(currNode.child.get(currIdx)).orElse(new TrieNode());
			currNode.child.put(currIdx, childNode);
			currNode.count.put(currIdx, currNode.count.getOrDefault(currIdx, 0) + 1);
			currNode = childNode;
			if (i == word.length() - 1) {
				childNode.isEnd = true;
			}
		}
	}

	public boolean search(String word) {
		TrieNode currNode = this.root;
		for (int i = 0; i < word.length(); i++) {
			char currChar = word.charAt(i);
			int currCharIdx = currChar - 'a';
			TrieNode child = currNode.child.get(currCharIdx);
			if (null == child || (word.length() - 1 == i && child.isEnd == false)) return false;
			currNode = child;
		}
		return true;
	}
	
	public void delete(String word) {
		TrieNode currNode = this.root;
		for (int i = 0; i < word.length(); i++) {
			char currChar = word.charAt(i);
			int currCharIdx = currChar - 'a';
			TrieNode child = currNode.child.get(currCharIdx);
			if (null == child || (word.length() - 1 == i && child.isEnd == false)) return;
			currNode = child;
		}
		return;
	}

}
