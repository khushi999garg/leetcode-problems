class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        // int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i= 0; i < k; i++){
            sum += nums[i];
        }

        int max = sum;

        for(int i = k; i < n; i++){
            sum += nums[i] - nums[i-k];
            max = Math.max(sum, max);
        }

        return (double)max/k;
    }
}