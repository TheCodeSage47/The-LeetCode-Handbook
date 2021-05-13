/*
You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.

Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.

Return true if a and b are alike. Otherwise, return false.

 

Example 1:

Input: s = "book"
Output: true
Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.

Example 2:

Input: s = "textbook"
Output: false
Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
Notice that the vowel o is counted twice.

Example 3:

Input: s = "MerryChristmas"
Output: false

Example 4:

Input: s = "AbCdEfGh"
Output: true


*/
class Solution {
    public boolean halvesAreAlike(String s) {
    	int v1=0;
    	int v2=0;
    	int n=s.length();
        s=s.toLowerCase();
    	String vowels="aeiou";
    	for(int i=0;i<n/2;i++) {
    		if(vowels.contains(Character.toString(s.charAt(i)))) {
    			v1++;
    		}
    	}
    	for(int i=n/2;i<n;i++) {
    		if(vowels.contains(Character.toString(s.charAt(i)))) {
    			v2++;
    		}
    	}
    	if(v1==v2) {
    		return true;
    	}
		return false;
        
    }
}