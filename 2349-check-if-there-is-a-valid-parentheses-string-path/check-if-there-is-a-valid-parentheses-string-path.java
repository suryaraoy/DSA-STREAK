class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Boolean[][][] mem=new Boolean[m][n][m+n];

        if(grid[0][0]==')' || grid[m-1][n-1]=='(') return false;

        return solve(0,0,0,mem,grid);
    }

    public boolean solve(int i,int j,int k,Boolean[][][] mem ,char[][] grid){
          if(i==grid.length || j==grid[0].length) return false;
           
          
          k+=(grid[i][j]=='(')? 1:-1;
          if(k < 0) return false;
         

          if(i==grid.length-1 && j==grid[0].length-1) return k==0;
          if(mem[i][j][k] != null) return mem[i][j][k];

          return mem[i][j][k]=solve(i+1,j,k,mem,grid) | solve(i,j+1,k,mem,grid);
    }
}