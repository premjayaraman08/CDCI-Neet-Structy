package OneStringsArray;

//give m X n matrix, if cell has 0 mark corresponding rows and columns to be o
// {
//  1 1 2 4      1, 0, 2, 0,      1  0 2 0     0 0 0 0
//  2 0 3 0      0, 0  3  0      0  0 0 0     0 0 0 0
//  1 0 3 9   -> 0, 0  3  9   -> 0  0 0 0  -> 0 0 0 0
//  1 6 8 9      1, 6  8  9      1  0 8 9     0 0 8 9
//}
public class EightMatrixZeros {
    public static void main(String[] args){
        int[][] matrix= {
                {1,1,2,4},
                {2,0,3,0},
                {1,0,3,9},
                {1,6,8,9}
        };

        matrixZeros(matrix);

        display(matrix);
    }

    public static void matrixZeros(int[][] matrix){
        boolean firstRow = false, firstCol = false;
        //Setting markers with 1st rows, 1st col. Noting flags on row 0 column 0
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                //check cell for zero
                if(matrix[i][j] == 0){
                    //note markers

                    //mark corresponding row to be 0
                    matrix[i][0] = 0;
                    //mark corresponding col to be 0
                    matrix[0][j] = 0;

                    //if 1st row mark zero
                    if( i == 0 ) firstRow = true;
                    if( j == 0 ) firstCol = true;
                }
            }
        }

        System.out.println("firstRow:"+ firstRow+", firstCol" + firstCol);

        //Use above details to replace inner matrix
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++) {
                // if cell travesing has any row or col 0 then mark cel 0 
                if(matrix[i][0] ==0 || matrix[0][j] ==0 ){
                    matrix[i][j] = 0;
                }
            }
        }
        //Handle 1st row and column
        if(firstRow){
            //make all columns o
            for(int j=0;j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
        //Handle 1st olumn
        if(firstCol){
            //make all rows o
            for(int i=0;i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }

    }

    public static void display(int[][] matrix){
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j< matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

    }

}
