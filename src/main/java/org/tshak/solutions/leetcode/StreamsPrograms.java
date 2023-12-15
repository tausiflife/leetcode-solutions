package org.tshak.solutions.leetcode;

import java.util.Arrays;

public class StreamsPrograms {
    public static void main(String[] args) {
        int[] arr= new int[]{1, 4, 3, 6, 2, 9, 7, 8};
        long product = Arrays.stream(arr).parallel().sorted().reduce(0, (a,b) -> a+b);
        System.out.println(product);
    }

}
