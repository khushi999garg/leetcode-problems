class Solution {
    public int countTriplets(int[] arr) {
        Map<Integer, int[]> map = new HashMap<>();
        int preOr = 0;
        int count = 0;
        int n = arr.length;

        map.put(0, new int[] { -1, 1 });

        for (int i = 0; i < n; i++) {
            preOr ^= arr[i];

            if (map.containsKey(preOr)) {
                int[] res = map.get(preOr);
                count += res[1] * (i - 1) - res[0];
                res[0] += i;
                res[1] += 1;
                map.put(preOr, res);
            } else {
                map.put(preOr, new int[] { i, 1 });
            }
        }
        return count;
    }
}