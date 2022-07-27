// Array + DP solution: store the prefix sum in array and scan from left
// Time: O(n), 1ms
// Space: O(n), 42.4mb
class Solution {
    public int pivotIndex(int[] nums) {
        // Count the prefix sum of nums: prefix[i] = nums[0] + nums[1] + .. + nums[i - 1]
        int len = nums.length, sum = 0;
        int[] prefix = new int[len];
        for(int i = 0; i < len; i++) {
            prefix[i] = sum;
            sum += nums[i];
        }
        
        // Find the pivot using the sum
        for(int i = 0; i < len; i++) {
            // !!: Take care the pivot element and the last one
            if(prefix[i] == prefix[len - 1] - prefix[i] - nums[i] + nums[len - 1]) return i;
        }
        
        return -1;
    }
}
