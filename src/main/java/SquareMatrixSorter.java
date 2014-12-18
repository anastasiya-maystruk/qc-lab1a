import java.util.*;

public class SquareMatrixSorter {

    void validateMatrix(int[][] matrix) throws Exception {

        if (matrix == null) {
            throw new Exception("Матрицы не существует");
        }

        if (matrix.length == 0) {
            throw new Exception("Матрица пуста");
        }

        if (matrix.length != matrix[0].length) {
            throw new Exception("Матрица не квадратная");
        }

        int expectedSize = matrix.length;
        for (int[] row : matrix) {
            if (row.length != expectedSize) {
                throw new Exception("Строки матрицы не равны");
            }
        }

        if (matrix.length < 5){
            throw new Exception("Размерность матрицы меньше 5");
        }

        if (matrix.length % 2 == 0){
            throw new Exception("Размерность матрицы четная");
        }

        boolean posElem = false;
        boolean negElem = false;
        for (int[] array: matrix){
            for (int element: array){
                if (element >= 0){
                    posElem = true;
                }
                else{
                    negElem = true;
                }

            }
        }
        if (!posElem || !negElem) {
            throw new Exception("В матрице только положительные или отридцательные элементы");
        }
    }
    float countAverage(int[][] matrix) throws Exception {

        validateMatrix(matrix);
        float sum = 0;

        for (int[] array : matrix) {
            for (int element : array) {
                sum += element;
            }
        }

        return sum / (matrix.length * matrix.length);
    }


    int centralElement(int[][] matrix) throws Exception{

        validateMatrix(matrix);
        return matrix[matrix.length / 2][matrix.length / 2];
    }


    int[][] sortMatrix(int[][] matrix, boolean ascending) throws Exception{

        validateMatrix(matrix);
        Integer[] temp = new Integer[matrix.length * matrix.length];
        int k = 0;

        for (int[] array : matrix) {
            for (int element : array) {
                temp[k] = element;
                k++;
            }
        }

        if (ascending) {
            Arrays.sort(temp);
        }
        else {
            Arrays.sort(temp, Collections.reverseOrder());
        }

        k = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = temp[k];
                k++;
            }
        }

        return matrix;
    }

    public void main(int[][] matrix, boolean ascending) throws Exception {

        validateMatrix(matrix);
        countAverage(matrix);
        centralElement(matrix);
        sortMatrix(matrix,ascending);

    }

}
