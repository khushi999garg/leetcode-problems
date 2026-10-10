class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findBounds(nums, target, true);
        int right = findBounds(nums, target, false);

        return new int[] {left, right};
    }

    private int findBounds (int[] nums, int target, boolean findFirst){
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(nums[mid] > target){
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                ans = mid;
                if (findFirst){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return ans;
    } 
}