class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();
        int ans = 0;
        int left = 0;

        for (int i = 0; i < n; i++) {
            int a = nums[i];
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > a)
                minDeque.removeLast();
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < a)
                maxDeque.removeLast();

            minDeque.addLast(i);
            maxDeque.addLast(i);

            int diff = nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()];

            while (!minDeque.isEmpty() && !maxDeque.isEmpty() && diff > limit) {
                left++;
                while (!minDeque.isEmpty() && minDeque.peekFirst() < left) {
                    minDeque.removeFirst();
                }
                while (!maxDeque.isEmpty() && maxDeque.peekFirst() < left) {
                    maxDeque.removeFirst();
                }

                diff = nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()];

            }

            ans = Math.max(ans, i - left + 1);
        }

        return ans;
    }
}