class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int startrow=0;
        int endrow= matrix.length-1;
        int startcol=0;
        int endcol= matrix[0].length-1;

        //for empty matrix
        if(matrix.length == 0 || matrix[0].length == 0) 
            return result;
        
        while(startrow<=endrow && startcol<=endcol){
            //adding top border elements
            for(int j=startcol; j<=endcol; j++){
                result.add(matrix[startrow][j]);
            }
            //adding right border elements
            for(int i=startrow+1; i<=endrow; i++){
                result.add(matrix[i][endcol]);
            }
            //adding bottom border elements
            for(int j=endcol-1; j>=startcol; j--){
                //to avoid printing same number twice
                if(startrow==endrow){
                    break;
                }
                result.add(matrix[endrow][j]);
            }
            //adding left border elements
            for(int i=endrow-1; i>=startrow+1; i--){
                //to avoid printing same number twice
                if(startcol==endcol){
                    break;
                }
                result.add(matrix[i][startcol]);
            }

            startcol++;
            startrow++;
            endcol--;
            endrow--;

        }
        return result;
        
    }
}
