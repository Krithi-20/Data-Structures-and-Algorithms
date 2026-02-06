class Solution {

    public int maxEle(int [][]mat, int rows, int col) {
        int maxVal = Integer.MIN_VALUE;
        int idx = -1;
        for(int i=0; i<rows; i++) {
            if(mat[i][col] > maxVal) {
                maxVal = mat[i][col];
                idx = i;
            }
        }
        return idx;
    }
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = n-1;

        while(low <= high) {
            int col = low + (high-low)/2;
            int row = maxEle(mat,m,col);
            int left = col-1 >=0 ? mat[row][col-1] : -1;
            int right = col+1 <n ? mat[row][col+1] : -1;

            if(mat[row][col] > left  && mat[row][col] > right) {
                return new int[]{row,col};
            }
            else if (left > mat[row][col]) {
                high = col-1;
            }
            else {
                low = col+1;
            }
        }
        return new int [] {-1,-1};
    }
}