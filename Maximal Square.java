public class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if(row ==0){
            return 0;
        }
        int col = matrix[0].length;
        if(col == 0){
            return 0;
        }
        int ret = 0;
        int[][] dp = new int[row][col];
        for(int i=0;i<col;i++){
            dp[0][i] = matrix[0][i] - '0';
            ret = Math.max(ret,dp[0][i]);
        }
        for(int i=0;i<row;i++){
            dp[i][0] = matrix[i][0] - '0';
            ret = Math.max(ret,dp[i][0]);
        }
        for(int i=1;i<row;i++)
            for(int j=1;j<col;j++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                    ret = Math.max(ret,dp[i][j]);
                }
            }
        return ret*ret;
    }
}
