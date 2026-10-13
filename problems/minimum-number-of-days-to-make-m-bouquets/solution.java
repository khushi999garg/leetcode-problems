class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int left = bloomDay[0];
        int right = bloomDay[0];

        if ((long)m * k > n){
            return -1;
        }

        for (int x : bloomDay) {
            left = Math.min(left, x);
            right = Math.max(right, x);
        }

        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            int bouquet = 0;

            for(int x: bloomDay){
                if (x <= mid) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == k){
                    bouquet++;
                    count = 0;
                }
            }

            if (bouquet >= m){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}