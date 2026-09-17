class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.removeLast();

            if (!queue.isEmpty() && queue.peekFirst() <= i - k)
                queue.removeFirst();
            queue.addLast(i);

            if (i + 1 >= k) {
                ans[idx] = nums[queue.peekFirst()];
                idx++;
            }
        }

        return ans;
    }
}