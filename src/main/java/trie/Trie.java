package main.java.trie;

import java.util.InputMismatchException;

/**
 * This class represents a Trie data structure with 
 * support for insert & find operations
 * 
 * @author saffaura
 */
public class Trie {

	private TrieNode root = null;
	
	/**
	 * Constructs an empty Trie
	 */
	public Trie() {
		root = new TrieNode();
	}
	
	/**
	 * @return the root of this Trie
	 */
	public TrieNode getRootNode() {
		return root;
	}
	
	/**
	 * Inserts a word or phrase into the Trie
	 * 
	 * @param phrase - the word or phrase to insert
	 */
	public void insert(String phrase) {
		
		if (phrase == null || phrase.isEmpty()) {
			throw new InputMismatchException("null or empty elements cannot be inserted into Trie");
		}
		
		TrieNode temp = root;
		char[] word = phrase.toCharArray();
		
		for (char c : word) {
			
			if (c == ' ' || c == '-') {
				// skip spaces & hyphens
				continue;
			}
			
			temp = temp.add(c);
		}
	
		temp.setPhrase(phrase);
	}
	
	/**
	 * Finds the last TrieNode in the Trie for the given phrase
	 * 
	 * @param phrase - the word or phrase to find
	 * @return the TrieNode associated with the last character in the word. 
	 * 		   Null if not found.
	 */
	public TrieNode getPhraseNode(String phrase) {
		return root.find(phrase);
	}
}
