class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        int left = 1;
        int right = 10000000;

        if (n > Math.ceil(hour)) {
            return -1;
        }

        while (left < right) {
            int mid = (right + left) / 2;
            double time = 0;

            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    time += (double) dist[i] / mid;
                } else
                    time += (dist[i] + mid - 1) / mid;
            }

            if (time > hour) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}