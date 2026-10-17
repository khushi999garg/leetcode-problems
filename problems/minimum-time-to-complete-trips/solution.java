class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        long right = Long.MAX_VALUE;

        for(long x: time){
            right = Math.min(right, x * totalTrips);
        }

        while(left < right){
            long mid = (left + right) / 2;
            long trips = 0;

            for(int x: time){
                trips += mid / x;
            }

            if (trips < totalTrips){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}