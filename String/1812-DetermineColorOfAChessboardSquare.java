/*
You are given coordinates, a string that represents the coordinates of a square of the chessboard. Below is a chessboard for your reference.

Return true if the square is white, and false if the square is black.

The coordinate will always represent a valid chessboard square. The coordinate will always have the letter first, and the number second.

 

Example 1:

Input: coordinates = "a1"
Output: false
Explanation: From the chessboard above, the square with coordinates "a1" is black, so return false.

Example 2:

Input: coordinates = "h3"
Output: true
Explanation: From the chessboard above, the square with coordinates "h3" is white, so return true.

Example 3:

Input: coordinates = "c7"
Output: false

 

Constraints:

    coordinates.length == 2
    'a' <= coordinates[0] <= 'h'
    '1' <= coordinates[1] <= '8'


*/
class Solution {
    public boolean squareIsWhite(String coordinates) {
        int x=1;
		int y=Integer.parseInt(Character.toString(coordinates.charAt(1)));
		String str=Character.toString(coordinates.charAt(0));
		if(str.equalsIgnoreCase("a")) {
			x=1;
		}else if(str.equalsIgnoreCase("b")) {
			x=2;
		}else if(str.equalsIgnoreCase("c")) {
			x=3;
		}else if(str.equalsIgnoreCase("d")) {
			x=4;
		}else if(str.equalsIgnoreCase("e")) {
			x=5;
		}else if(str.equalsIgnoreCase("f")) {
			x=6;
		}else if(str.equalsIgnoreCase("g")) {
			x=7;
		}else if(str.equalsIgnoreCase("h")) {
			x=8;
		}
		int sum=x+y;
		if(sum%2==0) {
			return false;
		}else {
			return true;
		}
    }
}