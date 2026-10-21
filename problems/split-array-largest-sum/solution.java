class Solution {
    public int splitArray(int[] nums, int k) {
        int left = nums[0];
        int right = 0;

        for (int x : nums) {
            left = Math.max(left, x);
            right += x;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 1;
            int sum = 0;
            for (int x : nums) {
                sum += x;
                if (sum > mid) {
                    sum = x;
                    count++;
                }
            }

            if (count > k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}