package com.edu.java.trie;

public class WordDictionary {

	private TrieNode root;

	public WordDictionary() {
		this.root = new TrieNode();
	}

	public void addWord(String word) {
		char[] chars = word.toCharArray();
		TrieNode curr = root;
		for (char letter : chars) {
			int letterIdx = letter - 'a';
			if (null == curr.children[letterIdx]) {
				TrieNode child = new TrieNode(letter);
				curr.children[letterIdx] = child;
			}
			curr = curr.children[letterIdx];
		}
		curr.word = true;
	}

	public boolean search(String word) {
		return dfs(root, word, 0);
	}

	private boolean dfs(TrieNode curr, String word, int idx) {
		if (idx == word.length() && curr.word == true)
			return true;
		if (idx >= word.length() || curr.children[word.charAt(idx) - 'a'] == null)
			return false;
		boolean tempRes = dfs(curr.children[word.charAt(idx) - 'a'], word, idx + 1);
		if (tempRes == false)
			return false;
		return true;
	}

}
