package com.home;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareMatrixSorterTest {

    @Test(expected = Exception.class)
    public void testMainForForNull() throws Exception {

        int[][] input = null;
        SquareMatrixSorter squareMatrixSorter = new SquareMatrixSorter();
        squareMatrixSorter.setup(input, true);
    }

    @Test(expected = Exception.class)
    public void testMainForForEmpty() throws Exception {

        int[][] input = new int[0][0];
        SquareMatrixSorter squareMatrixSorter = new SquareMatrixSorter();
        squareMatrixSorter.setup(input, true);
    }

    @Test(expected = Exception.class)
    public void testMainForForNotSquare() throws Exception {

        int[][] input = new int[3][2];
        SquareMatrixSorter squareMatrixSorter = new SquareMatrixSorter();
        squareMatrixSorter.setup(input, true);
    }

    @Test(expected = Exception.class)
    public void testMainWhenMatrixHasNonEqualRows() throws Exception {

        int[][] input = {
                {1, 2, 3},
                {9, 7},
                {7}
        };

        SquareMatrixSorter squareMatrixSorter = new SquareMatrixSorter();
        squareMatrixSorter.setup(input, true);
    }

    @Test(expected = Exception.class)
    public void testMainWhenMatrixDimensionLessFive() throws Exception {

        int[][] input = new int[4][4];
        SquareMatrixSorter squareMatrixSorter = new SquareMatrixSorter();
        squareMatrixSorter.setup(input, true);
    }

    @Test(expected = Exception.class)
    public void testMainWhenMatrixDimensionOdd() throws Exception {

        int[][] input = new int[4][4];
        SquareMatrixSorter squareMatrixSorter = new SquareMatrixSorter();
        squareMatrixSorter.setup(input, true);
    }

    @Test(expected = Exception.class)
    public void testMainWhenMatrixElementsNotPositiveAndNegative() throws Exception {

        int[][] input = {
                {5, 1, 2, 3, 4},
                {2, 3, 4, 5, 6},
                {3, 4, 5, 6, 7},
                {8, 9, 10, 11, 12},
                {9, 10, 11, 12, 13}
        };
        SquareMatrixSorter squareMatrixSorter = new SquareMatrixSorter();
        squareMatrixSorter.setup(input, true);
    }



    @Test
    public void TestSortAscending() throws Exception {
        int[][] input = {
                {3, 2, 5, 1, 4},
                {5, 3, 1, 4, 2},
                {4, 2, 1, 5, 3},
                {1, 5, 3, 4, 2},
                {2, 4, -1, 3, 5}
        };

        int[][] expected = {
                {-1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5}
        };

        SquareMatrixSorter sms = new SquareMatrixSorter();
        int[][] result= sms.sortMatrix(input, true);
        assertArrayEquals("Ошибка! Матрицы не совпали",
                expected, result);
    }

    @Test
    public void TestSortDescending() throws Exception {
        int[][] input = {
                {3, 2, 5, 1, 4},
                {5, 3, 1, 4, 2},
                {4, 2, 10, 5, 3},
                {1, 5, 3, 4, 2},
                {2, 4, -1, 3, 5}
        };

        int[][] expected = {
                {10, 5, 5, 5, 5},
                {5, 4, 4, 4, 4},
                {4, 3, 3, 3, 3},
                {3, 2, 2, 2, 2},
                {2, 1, 1, 1, -1}
        };

        SquareMatrixSorter sms = new SquareMatrixSorter();
        int[][] result = sms.sortMatrix(input, false);
        assertArrayEquals("Ошибка! Матрицы не совпали",
                expected, result);
    }

    @Test
    public void TestCentralElement() throws Exception {
        int[][] input = {
                {3, 2, 5, -1, 4},
                {5, 3, 1, 4, 2},
                {4, 2, 8, 5, 3},
                {1, 5, 3, 4, 2},
                {2, 4, 1, 3, 5}
        };

        int expected = 8;

        SquareMatrixSorter sms = new SquareMatrixSorter();
        int result = sms.centralElement(input);
        assertEquals("Ошибка! Неверный центральный элемент",
                expected, result);
    }

    @Test
    public void TestCountAverage() throws Exception {
        int[][] input = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, -1}
        };

        float expected = 0.92f;

        SquareMatrixSorter sms = new SquareMatrixSorter();
        float result = sms.countAverage(input);
        assertEquals("Ошибка! Неверное среднее значение",
                expected, result, 0.001f);
    }

}
