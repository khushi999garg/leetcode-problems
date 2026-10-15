class Solution {
    public int maximumCandies(int[] nums, long k) {
        int left = 1;
        int right = nums[0];
        long sum = 0;

        for (int x : nums) {
            sum += x;
            right = Math.max(right, x);
        }

        if (sum < k)
            return 0;

        if (sum == k)
            return 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            long count = 0;

            for (int x : nums) {
                count += x / mid;
            }

            if (count >= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}