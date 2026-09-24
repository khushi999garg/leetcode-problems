class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int prefix = 0;
        int count = 0;

        map.put(0, 1);

        for (int x: nums) {
            prefix += x;
            int ans = prefix - k;

            count += map.getOrDefault(ans, 0);
            
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }
}