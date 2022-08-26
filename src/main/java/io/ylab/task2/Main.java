package io.ylab.task2;



public class Main {

    public static void main(String[] args) {
        int [] arr = getArray();
        System.out.println("Массив до сортировки:\n" + getStringArray(arr));
        bubbleSort(arr);
        System.out.println("Массив после сортировки:\n" + getStringArray(arr));
    }


    public static void bubbleSort(int[] arr) {
        if (arr.length == 1 || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j+1] < arr[j]){

                    int swap = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = swap;
                }
            }
        }
    }

    private static String getStringArray(int [] arr) {
        StringBuilder array = new StringBuilder("[ ");
        for (int i = 0; i < arr.length; i++) {
            array.append(arr[i]);
            if(i != arr.length - 1) {
                array.append(", ");
            }
        }
        array.append(" ]");
        return array.toString();
    }

    private static int [] getArray() {
        return new int[]{5, 6, 3, 2, 5, 1, 4, 9};
    }


}
