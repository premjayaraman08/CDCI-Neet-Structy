package OneStringsArray;

//Rotate matrix 90 degrees
public class SevenRotateSquareMatrix {
    public static void main(String[] args){
        char[][] matrix = {
                {'a','b', 'c','d'},
                {'e','f', 'g','h'},
                {'i','j', 'k','l'},
                {'m','n', 'o','p'},
            };

        rotateMatrix(matrix);
        display(matrix);
    }

    public static void rotateMatrix(char[][] matrix){
        //transpose and reverse rows
        //transpose is rows becomes columns, columns becomes rows
        for(int i=0; i <matrix.length; i++){
            for(int j=i ; i<matrix[0].length; i++){
                char temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //revere rows
        for(int i=0; i< matrix.length; i++) {
            //2 pointer moving towards each other
            int leftIndex = 0;
            int rightIndex = matrix.length - 1;
            while (leftIndex < rightIndex) {
                char temp = matrix[i][leftIndex];
                matrix[i][leftIndex] = matrix[i][rightIndex];
                matrix[i][rightIndex] = temp;

                leftIndex++;
                rightIndex--;
            }
        }
    }

    private static void display(char[][] matrix) {
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                System.out.print(matrix[i][j] + " \t" );
            }
            System.out.println();
        }
    }
}
