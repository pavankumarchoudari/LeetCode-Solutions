 class Solution {
    public static boolean searchMatrix(int[][] mat, int x) {

    int n = mat.length;       // number of rows
    int m = mat[0].length;    // number of columns

    int i = 0;
    int j = m - 1;

    while (i < n && j >= 0) {

        if (mat[i][j] == x) {
            System.out.println("Found at " + i + ", " + j);
            return true;
        }

        if (mat[i][j] > x) {
            j--;       // move left
        } else {
            i++;       // move down
        }
    }

    return false;
}
 }