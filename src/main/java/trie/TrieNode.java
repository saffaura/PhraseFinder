package main.java.trie;

import java.util.InputMismatchException;

/**
 * Basic class representation of a node in a Trie data structure
 * 
 * @author saffaura
 */
public class TrieNode {

	private TrieNode[] children = null;
	private boolean isPhrase = false;
	private String phrase = null; 
	
	/**
	 * Initializes basic trie node with support for characters a-z
	 */
	public TrieNode() {		
		children = new TrieNode[26];
		isPhrase = false;
	}
	
	/**
	 * Adds the given character to this node's children array
	 * if it does not already exist
	 * 
	 * @param c - the character to add
	 * @return the newly inserted TrieNode
	 */
	public TrieNode add(char c) {	
		if (!Character.isLetter(c)) {
			throw new InputMismatchException("TrieNode supports letters only");
		}
		
		int index = Character.toLowerCase(c) - 'a';
		if (children[index] == null) {
			children[index] = new TrieNode();
		}
		
		return children[index];
	}
	
	/**
	 * Finds a phrase in the Trie and returns the last associated TrieNode
	 * 
	 * @param phrase - the phrase to find
	 * @return the TrieNode at the end of the phrase or null if not found.
	 */
	public TrieNode find(String phrase) {	
		if (phrase == null || phrase.isEmpty()) {
			throw new InputMismatchException("Cannot find null or empty string");
		}
		
		char[] word = phrase.toCharArray();
		TrieNode temp = this;
		
		for (char c : word) {
			
			if (c == ' ' || c == '-') {
				continue;
			}
			
			int index = Character.toLowerCase(c) - 'a';
			temp = temp.children[index];
			
			if (temp == null) {
				break;
			}
			
		}
		
		return temp;
	}
	
	/**
	 * Sets the word or phrase at this TrieNode
	 * 
	 * @param phrase - the word or phrase to set
	 */
	public void setPhrase(String phrase) {
		this.phrase = phrase;
		isPhrase = true;
	}
	
	/**
	 * @return the word or phrase at the current TrieNode
	 */
	public String getPhrase() {
		return phrase;
	}
	
	/**
	 * @return true if this TrieNode represents a phrase, false if otherwise.
	 */
	public boolean isPhrase() {
		return isPhrase;
	}
	
}
