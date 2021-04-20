
/*
You are given an integer array nums of length n which represents a permutation of all the integers in the range [0, n - 1].

The number of global inversions is the number of the different pairs (i, j) where:

    0 <= i < j < n
    nums[i] > nums[j]

The number of local inversions is the number of indices i where:

    0 <= i < n - 1
    nums[i] > nums[i + 1]

Return true if the number of global inversions is equal to the number of local inversions.

 

Example 1:

Input: nums = [1,0,2]
Output: true
Explanation: There is 1 global inversion and 1 local inversion.

Example 2:

Input: nums = [1,2,0]
Output: false
Explanation: There are 2 global inversions and 1 local inversion.

 

Constraints:

    n == nums.length
    1 <= n <= 5000
    0 <= nums[i] < n
    All the integers of nums are unique.
    nums is a permutation of all the numbers in the range [0, n - 1].


*/
import java.util.Arrays;

class Solution {
	public boolean isIdealPermutation(int[] A) {
		int n=A.length;
		int local=0;
		int global=0;
		for(int i=0;i<n-1;i++) {
			if(A[i]>A[i+1]) {
				local++;
			}
		}
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(A[i]>A[j]) {
					global++;
				}
				if(global>local) {
					return false;
				}
			}
		}
		
		if(global==local) {
			return true;
		}
		
		return false;
        
    }
}