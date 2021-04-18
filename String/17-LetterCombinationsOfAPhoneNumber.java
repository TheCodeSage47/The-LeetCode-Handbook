/*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:

Input: digits = ""
Output: []

Example 3:

Input: digits = "2"
Output: ["a","b","c"]

 

Constraints:

    0 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9'].

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
    	List<String> l=new LinkedList<String>();
    	int nSize=digits.length()*3;
        if(digits.length()==0) {
    		return l;
    	}
    	ArrayList<String> n=new ArrayList<String>(nSize);
    	for(int i=0;i<digits.length();i++) {
    		if(Character.toString(digits.charAt(i)).equals("2")) {
    			n.add("abc");
    		}else if(Character.toString(digits.charAt(i)).equals("3")) {
    			n.add("def");
    		}else if(Character.toString(digits.charAt(i)).equals("4")) {
    			n.add("ghi");
    		}else if(Character.toString(digits.charAt(i)).equals("5")) {
    			n.add("jkl");
    		}else if(Character.toString(digits.charAt(i)).equals("6")) {
    			n.add("mno");
    		}else if(Character.toString(digits.charAt(i)).equals("7")) {
    			n.add("pqrs");
    		}else if(Character.toString(digits.charAt(i)).equals("8")) {
    			n.add("tuv");
    		}else if(Character.toString(digits.charAt(i)).equals("9")) {
    			n.add("wxyz");
    		}
    	}

    	ArrayList<String> mello=new ArrayList<String>();
    	if(n.size()==1) {
    		for(int i=0;i<n.get(0).length();i++) {
    			l.add(Character.toString(n.get(0).charAt(i)));
    		}
    		return l;
    	}
    	for(int i=0;i<n.get(0).length();i++) {
			l.add(Character.toString(n.get(0).charAt(i)));
		}
    	for(int i=0;i<n.size()-1;i++) {
    		l=multiply(l, n.get(i+1));
    
    	}
		return l;
    }
    
    private List<String> multiply(List<String> l,String s){
    	List<String> n=new ArrayList<String>();
    	for(int i=0;i<l.size();i++) {
    		for(int j=0;j<s.length();j++) {
    			n.add(l.get(i)+Character.toString(s.charAt(j)));
    		}
    	}
		return n;
    }
}