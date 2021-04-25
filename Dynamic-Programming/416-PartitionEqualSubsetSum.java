/*
Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

 

Constraints:

    1 <= nums.length <= 200
    1 <= nums[i] <= 100


*/
class Solution {
    public boolean canPartition(int[] nums) {
        // return find(nums, 0,0,0);
        
        return find(nums);
    }
    
    //basically this problem is similar to 0-1 knapsack, you decides at each step whether to put the 
    //current item in set 1 or 2, you need to calculate for set 1, set2 will be total - set1
    //it means capacity is just half of total, if you reach there that means there is a way to partition in 
    //equal set
    public boolean find(int[] nums) {
        int n = nums.length;
        int sum = 0;
        
        for (int i : nums) {
            sum += i;
        }
        
        //odd sum, can't partition into 2 equal sets
        if (sum%2 == 1) return false;
        
        sum /= 2;
        boolean[][] dp = new boolean[n+1][sum+1];
        
        for (int i = 0;i<=n;i++) {
            dp[i][0] = true;
        }
        
        for (int i = 1;i<=n;i++) {
            for (int j = 1;j<=sum;j++) {
                dp[i][j] = dp[i-1][j] || ((j-nums[i-1]) >= 0 ? dp[i-1][j-nums[i-1]] : false);
            }
        }
        
        return dp[n][sum];
    }
    
	
	//space optimized
	  public boolean find1(int[] nums) {
        int n = nums.length;
        int sum = 0;
        
        for (int i : nums) {
            sum += i;
        }
        
        //odd sum, can't partition into 2 equal sets
        if (sum%2 == 1) return false;
        
        sum /= 2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        
         for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }
        
        return dp[sum];
    }
    
    
    
    //tle just recursion
    public boolean find(int[] nums, int i, int x, int y) {
        if (i == nums.length) {
            return x == y;
        }
        
        return find(nums, i+1, x+nums[i], y) || find(nums, i+1, x, y+ nums[i]);
    }
        
}