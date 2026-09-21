class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> que = new ArrayDeque<>();
        int n = nums.length;
        long[] pref = new long[n + 1];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + nums[i];
        }

        for (int i = 0; i <= n; i++) {
            while (!que.isEmpty() && pref[i] - pref[que.peekFirst()] >= k) {
                ans = Math.min(ans, i - que.peekFirst());
                que.removeFirst();
            }

            while (!que.isEmpty() && pref[que.peekLast()] >= pref[i]) {
                que.removeLast();
            }

            que.addLast(i);
            // System.out.println(ans + " " + que.peekFirst());
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}