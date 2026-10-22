class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] pivot = new int[] {0, n-1};

        while (pivot[0] <= m-1 && pivot[1] >= 0){
            int value = matrix[pivot[0]][pivot[1]];

            if (value < target){
                pivot[0] += 1;
            } else if (value > target){
                pivot[1] -= 1;
            } else return true;
        }

        return false;
    }
}