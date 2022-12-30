class Solution {

    public int numIslands(char[][] grid) {

   int totalIslands=0;
       for(int i=0;i < grid.length;i++){
           for(int j=0;j < grid[i].length;j++){
             
             if(grid[i][j]=='1'){
             findIslands(grid,i,j);
             totalIslands+=1;
             }

           }
       }
       return totalIslands;
       }
       

        
    

     public void findIslands(char[][] grid,int i, int j){
         
         if( i<0 || j<0 || i == grid.length || j == grid[i].length || grid[i][j]=='0' || grid[i][j]=='2'){
             return;
         }

          
              grid[i][j]='2';
          

          findIslands(grid,i,j+1);
          findIslands(grid,i+1,j);
          findIslands(grid,i-1,j);
          findIslands(grid,i,j-1);
         
             
         


    }
}