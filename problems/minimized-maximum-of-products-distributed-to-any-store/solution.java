class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        int left = 1;
        int right = 1;

        for (int x : quantities) {
            right = Math.max(right, x);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;

            for (int x : quantities) {
                count += (x + mid - 1) / mid;
                if (count > n)
                    break;
            }

            if (count > n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}