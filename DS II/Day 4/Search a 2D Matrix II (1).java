public class Solution { //brute force O(mn)
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        for(int m = 0; m< matrix.length; m++){
            for(int n= 0; n< matrix[0].length; n++){
                if(matrix[m][n] == target){
                    return true;
                }
            }
        }
        return false;
    }
}