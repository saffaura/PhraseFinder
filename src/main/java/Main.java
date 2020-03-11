package main.java;

import java.util.List;

import main.java.phraseFinder.PhraseFinder;

/**
 * Implementatin of Amazon on-site bar-raiser question from 
 * https://leetcode.com/discuss/interview-question/533828/Amazon-or-Onsite-or-Print-phrases-in-stream-of-words
 * 
 * @author saffaura
 */
public class Main {

	public static void main(String[] args) {
		
		String[] text = {"i was walking through the park and saw a cat running through"
                       + " the grass then i saw a cat running from the bushes",
                         "i like ice cream a lot but not ice cubes but i like slushies",
                         "how many pokeballs can i buy how many pokemon can i buy how "
                       + "many pokemon can i catch with how many pokeballs i have"};
		
		String[][] phrases = {{"a cat", "through the grass", "i saw a cat running"}, 
							  {"i like", "ice cream", "ice cubes"},
							  {"many pokemon", "how many", "many pokeballs", "i catch"}};
		
		for (int i = 0; i < text.length; i++) {
			
			PhraseFinder finder = new PhraseFinder(text[i], phrases[i]);
			List<String> foundPhrases = finder.findPhrases();
			
			System.out.println("Found the following words:\n");
			
			for (String word : foundPhrases) {
				System.out.println(word);
			}
			
			System.out.println();
		}
	}

}
