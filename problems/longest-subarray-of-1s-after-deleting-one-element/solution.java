class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int count = 0;
        int ans = Integer.MIN_VALUE;

        for(int right = 0; right < n; right++){
            int a = nums[right];

            if(a == 0) count++;

            while(count > 1){
                if(nums[left] == 0) count--;
                left++;
            }

            ans = Math.max(ans, right-left);
        }

        return ans;
    }
}