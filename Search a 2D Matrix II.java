public class Solution {
    private int row =0, col = 0;
    public boolean searchMatrix(int[][] matrix, int target) {
        row = matrix.length;
        if(row == 0){
            return false;
        }
        col = matrix[0].length;
        if(col == 0){
            return false;
        }
        return searchMatrixHelper(matrix,0,row-1,target);
    }
    private boolean searchMatrixHelper(int[][] matrix, int top,int down, int target){
        if(top>down){
            return false;
        }
        if(top == down){
            return searchVector(matrix[top],0,col-1,target);
        }
        int mid = (top+down)>>1;
        if(target == matrix[mid][0] || target == matrix[mid][col-1]){
            return true;
        }else if(target<matrix[mid][0]){
            return searchMatrixHelper(matrix,top,mid-1,target);
        }else if(target>matrix[mid][col-1]){
            return searchMatrixHelper(matrix,mid+1,down,target);
        }else if(searchVector(matrix[mid],1,col-2,target)
            || searchMatrixHelper(matrix,top,mid-1,target)
            || searchMatrixHelper(matrix,mid+1,down,target)){
                return true;
        }else{
            return false;
        }
    }
    private boolean searchVector(int[] vector,int left, int right,int target){
        if(left > right){
            return false;
        }
        if(left == right){
            return vector[left] == target;
        }
        int mid = (left+right)>>1;
        if(vector[mid] > target){
            return searchVector(vector,left,mid-1,target);
        }else if(vector[mid] < target){
            return searchVector(vector,mid+1,right,target);
        }else{
            return true;
        }
    }
}
