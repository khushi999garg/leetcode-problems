class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = nums[0];

        for(int x: nums){
            right = Math.max(right, x);
        }

        while(left < right){
            int mid = (left + right) / 2;
            long sum = 0;

            for(int x: nums){
                sum += (x + mid - 1) / mid;
            }

            if (sum > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}