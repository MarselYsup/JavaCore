package io.ylab.task5;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
        System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
        System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
        System.out.println(fuzzySearch("lw", "cartwheel")); // false
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the substring: ");
        String subSeq = sc.next();
        System.out.print("Input the original line: ");
        String originalLine = sc.next();
        System.out.printf("%s is fuzzy matching on %s - %b", subSeq, originalLine, fuzzySearch(subSeq, originalLine));
    }
    /**
     * Функция нечеткого поиска
     *
     * @param subSequence - подстрока
     * @param originalLine - исходная строка для поиска
     * @return если подстрока имеет нечеткое соответсвие с исходной строкой возвращаеться  - true,
     * в противном случае - false
     *
     * */
    public static boolean fuzzySearch(String subSequence, String originalLine) {

        if(Objects.isNull(subSequence) || Objects.isNull(originalLine)) return false;

        int n = subSequence.length();
        int m = originalLine.length();

        int index = 0;

        for (int i = 0; i < m && index < n; i++) {
            if(subSequence.charAt(index) == originalLine.charAt(i)) {
                index++;
            }
        }

        return index==n;
    }
}
