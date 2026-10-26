class Solution {
    int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};

     public long dfs(int i,int j,int[][] grid,int m,int n){
        long sum=grid[i][j];
        grid[i][j]=0;

        for(int[] dir : directions){
            int row=i+dir[0];
            int column=j+dir[1];
            if(row>=0 && row<m && column>=0 && column<n && grid[row][column]>0){
                sum+=dfs(row,column,grid,m,n);
            }
        }
        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;

        for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
            if(grid[i][j]>0){
                long sum=dfs(i,j,grid,m,n);
                if(sum%k==0) count++;
            }
           }
        }
        return count;
    }
}