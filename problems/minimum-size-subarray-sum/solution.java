class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        for(int right = 0; right < n; right++){
            int a = nums[right];

            sum += a;

            while(sum >= target){
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return ans != Integer.MAX_VALUE ? ans : 0;
    }
}