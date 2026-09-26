class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int ans = 0;

        map.put(0, -1);

        for(int i = 0; i < n; i++){
            preSum += nums[i] == 1 ? 1 : -1;

            if(map.containsKey(preSum)){
                ans = Math.max(ans, i - map.get(preSum));
            } else {
                map.put(preSum, i);
            }
        }

        return ans;
    }
}