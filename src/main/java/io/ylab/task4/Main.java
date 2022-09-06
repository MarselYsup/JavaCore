package io.ylab.task4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Your example: ");
        System.out.print("[3, 4, 2, 7], 10 -> ");
        System.out.println(Arrays.toString(findCoupleWithCurrentSum(new int[]{3, 4, 2, 7}, 10)));
        System.out.println("-------------------------------------------------");
        System.out.print("Input the sum of couple element: ");
        int sum = sc.nextInt();
        System.out.print("Input the count of array: ");
        int count = sc.nextInt();
        System.out.println("Input the elements of array: ");
        int [] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Result: ");
        System.out.printf("%s, %d -> %s",
                Arrays.toString(arr), sum, Arrays.toString(findCoupleWithCurrentSum(arr, sum)));

    }

    /**
     * Находит пару из массива, которая образует введеную сумму
     *
     * @return пара чисел, образующие сумму, либо пустой массив,
     * если такой суммы невозможно образовать из пары
     * */
    public static int [] findCoupleWithCurrentSum(int[] array, int sum) {

        if (Objects.isNull(array)) return new int[0];

        Set<Integer> setOfNumbers = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            if(setOfNumbers.contains(sum - array[i])) {
                return new int[]{sum - array[i], array[i]};
            }
            setOfNumbers.add(array[i]);
        }

        return new int[0];
    }
}
