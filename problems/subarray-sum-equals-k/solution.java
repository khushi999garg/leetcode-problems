class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        map.put(0, 1);

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            int ans = sum[i] - k;

            if (map.containsKey(ans))
                count += map.get(ans);

            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        
        return count;
    }
}