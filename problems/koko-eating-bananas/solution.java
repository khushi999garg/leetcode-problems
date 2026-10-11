class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int left = 1;
        int right = 1;

        for(int x: piles) {
            right = Math.max(right, x);
        }

        while (left < right){
            int mid = (left + right) / 2;
            int sum = 0;

            for(int x: piles){
                sum += (x + mid - 1) / mid;
            }

            if (sum > h){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}