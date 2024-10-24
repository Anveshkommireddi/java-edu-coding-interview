package com.edu.java.trie;

public class TrieTest {

	public static void main(String[] args) {
		WordDictionary trie = new WordDictionary();
		trie.addWord("bat");
		trie.addWord("ban");
		trie.addWord("bun");
		trie.addWord("ball");
		trie.addWord("boomer");
		trie.addWord("anvesh");
		trie.addWord("ram");

		boolean isPresent = trie.search("bun");
		System.out.println("Is BUN Present " + isPresent);

		isPresent = trie.search("balls");
		System.out.println("Is Ball Present " + isPresent);

		isPresent = trie.search("boomer");
		System.out.println("Is boomer Present " + isPresent);

		isPresent = trie.search("anvesh");
		System.out.println("Is anvesh Present " + isPresent);

		isPresent = trie.search("balk");
		System.out.println("Is Ball Present " + isPresent);
	}

}
