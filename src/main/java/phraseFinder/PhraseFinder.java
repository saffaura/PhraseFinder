package main.java.phraseFinder;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.java.trie.Trie;
import main.java.trie.TrieNode;

public class PhraseFinder {

	private String[] stream = null;
	private String[] phrases = null;
	
	/**
	 * Initializes the phrase finder. 
	 * Note that the input will be split to simulate a stream
	 * 
	 * @param input - the text to search
	 * @param phrases - the phrases to search for
	 */
	public PhraseFinder(String input, String[] phrases) {
		
		if (input == null || input.isEmpty() || phrases == null || phrases.length == 0) {
			throw new InputMismatchException("Input strings cannot be null or empty");
		}
		
		// initialize the input stream
		stream = input.split(" ");
		this.phrases = phrases;
	}
		
	/**
	 * Searches for phrases in the input text
	 * 
	 * @return a list of the phrases in the order they were found
	 */
	public List<String> findPhrases() {
		
		Trie root = new Trie();
		List<String> result = new ArrayList<>();
		Queue<TrieNode> queue = new LinkedList<>();

		for (String phrase : phrases) {
			// build the trie
			
			root.insert(phrase);
		}
		
		// initialize the queue
		queue.offer(root.getRootNode());
				
		for (String word : stream) {
			
			// Search one word at a time and store TrieNodes that match this word.
			// If the current word extends a previous TrieNode, it may be a matching phrase
			
			// buffer to store current matches
			Queue<TrieNode> buffer = new LinkedList<>();
			
			while(!queue.isEmpty()) {
				// iterate through previous matches
				
				TrieNode next = queue.poll().find(word);
				
				if (next != null) {
					
					// if this word extends the previous word, add it to the buffer
					// in case the next word can also extend it
					
					buffer.offer(next);
					
					if (next.isPhrase()) {
						// if we found a valid phrase node, add it to the result	
						
						result.add(next.getPhrase());
					}
				}
				
			}
			
			queue = buffer;
			queue.offer(root.getRootNode());
		}
		
		return result;
	}
}
