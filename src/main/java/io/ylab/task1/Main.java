package io.ylab.task1;

public class Main {

    private static final int MAX_BORDER = 1000;

    private static final int ROW_NUMBERS = 5;

    private static final int COLUMN_NUMBERS = 5;

    private static final int CONST_RANDOM1 = 21;

    private static final int CONST_RANDOM2 = 35;

    private static final int CONST_RANDOM3 = 4;


    public static void main(String[] args) {
        int [] [] randomArray = getRandomArray();
        System.out.println("Дан двухмерный массив рандомных чисел: ");
        showArray(randomArray);
        System.out.printf("Максимальное значение данного массива = %d\n", maxValueInArray(randomArray));
        System.out.printf("Мнимальное значение данного массива = %d\n", minValueInArray(randomArray));
        System.out.printf("Среднее значение данного массива = %d\n", averageInArray(randomArray));

    }

    /**
     * Выписывает двухмерный массив в виде матрицы
     * */
    public static void showArray(int [][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     *  Высчитывает максимальное значение в двухмерном массиве
     * */
    public static int maxValueInArray(int [][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }


    /**
     *  Высчитывает минимальное значение в двухмерном массиве
     * */
    public static int minValueInArray(int [][] arr) {
        int min = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (min > arr[i][j]) {
                    min = arr[i][j];
                }
            }
        }
        return min;
    }


    /**
     *  Высчитывает среднее значение в двухмерном массиве
     * */
    public static long averageInArray(int [][] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sum+=arr[i][j];
            }
        }
        int n = arr.length * arr[0].length;

        return sum / n;
    }


    /**
     * Выдает рандомный двухмерный массив размеров ROW_NUMBERS * COLUMN_NUMBERS
     * */
    public static int[][] getRandomArray() {
        int [] [] arr = new int[ROW_NUMBERS][COLUMN_NUMBERS];

        for (int i = 0; i < ROW_NUMBERS; i++) {
            for (int j = 0; j < COLUMN_NUMBERS; j++) {
                arr[i][j] = xorShiftRandomNumber();
            }
        }

        return arr;
    }


    /**
     * Выдает рандомное число на основании nanoTime и xor операции с константами
     * */
    public static int xorShiftRandomNumber() {
       long seed = System.nanoTime();
        seed ^= (seed << CONST_RANDOM1);
        seed ^= (seed >>> CONST_RANDOM2);
        seed ^= (seed << CONST_RANDOM3);
        return (int) (seed % MAX_BORDER);
    }





}
