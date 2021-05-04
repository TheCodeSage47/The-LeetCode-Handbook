
/*
In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).

 

Constraints:

    1 <= words.length <= 100
    1 <= words[i].length <= 20
    order.length == 26
    All characters in words[i] and order are English lowercase letters.


*/
import java.util.HashMap;

class Solution {
	HashMap<Character, Integer> hm=new HashMap<Character, Integer>();
    public boolean isAlienSorted(String[] words, String order) {
    	
    	for(int i=0;i<order.length();i++) {
    		hm.put(order.charAt(i), i);
    	}
    	//System.out.println(hm);
    	for(int i=0;i<words.length-1;i++) {
    			if(!isSorted(words[i], words[i+1])) {
    				return false;
    			}
    	}
		return true;
        
    }
    
    public boolean isSorted(String w1,String w2) {
    	for(int i=0;i<w1.length() && i<w2.length();i++) {
			/*
			 * System.out.println("w1= "+hm.get(w1.charAt(i)));
			 * System.out.println("w2= "+hm.get(w2.charAt(i)));
			 */
    		if(hm.get(w1.charAt(i))<hm.get(w2.charAt(i))) {
    			return true;
    		}else if(hm.get(w1.charAt(i))>hm.get(w2.charAt(i))) {
    			return false;
    		}
    	}
    	if(w1.length()>w2.length()) {
    		return false;
    	}
		return true;
    	
    }
}