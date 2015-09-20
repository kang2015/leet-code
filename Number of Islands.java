public class Solution {
    private int row=0,col=0;
    private boolean dfs(char[][] grid,int i,int j){
        if(i<0 || i>=row || j<0 || j>=col || grid[i][j] == '0'){
            return false;
        }
        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
        return true;
    }
    public int numIslands(char[][] grid) {
        int ans = 0;
        row = grid.length;
        if(row == 0){
            return 0;
        }
        col = grid[0].length;
        if(col == 0){
            return 0;
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1' && dfs(grid,i,j)){
                    ans += 1;
                }
            }
        }
        return ans;
    }
}

//solution 2 "union find"
public class Solution {
    int row =0, col=0;
    int[] pre;
    int getHash(int i, int j){
        return i*col+j;
    }
    
    int find(int pos){
        while(pre[pos] != pos){
            pos = pre[pos];
        }
        return pos;
    }
    
    void merge(int pos1,int pos2){
        while(pre[pos1] != pos1){
            pos1 = pre[pos1];
        }
        while(pre[pos2] != pos2){
            pos2 = pre[pos2];
        }
        if(pos1 != pos2){
            pre[pos1]=pos2;
        }
    }
    
    public int numIslands(char[][] grid) {
        row = grid.length;
        if(row == 0){
            return 0;
        }
        col = grid[0].length;
        if(col == 0){
            return 0;
        }
        pre = new int[row*col];
        for(int i=0;i<row*col;i++){
            pre[i] = i;
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1'){
                    if(i<row-1 && grid[i+1][j] == '1'){
                        merge(getHash(i,j),getHash(i+1,j));
                    }
                    if(j<col-1 && grid[i][j+1] == '1'){
                        merge(getHash(i,j),getHash(i,j+1));
                    }
                }
            }
        }
        boolean[] head = new boolean[row*col];
        for(int i=0;i<row*col;i++)
            head[i] = false;
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1'){
                    head[find(getHash(i,j))]=true;
                }
            }
        int ans=0;
        for(int i=0;i<row*col;i++)
            if(head[i]){
                ans ++;
            }
        return ans;
    }
}
