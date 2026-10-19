class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        int left = 1;
        int right = 1;

        Arrays.sort(position);

        right = position[n - 1] - position[0];

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            int count = 1;
            long last = position[0];

            for (int i = 1; i < n; i++) {
                if (position[i] - last >= mid) {
                    count++;
                    last = position[i];
                }

                if (count >= m) {
                    break;
                }
            }

            if (count >= m) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}