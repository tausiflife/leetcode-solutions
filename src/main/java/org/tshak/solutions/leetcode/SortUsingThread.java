package org.tshak.solutions.leetcode;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortUsingThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var rand = new Random(10);
        List<Integer> list = Stream.generate(()-> rand.nextInt(10)).limit(10).collect(Collectors.toList());
        CompletableFuture<List<Integer>> sort1 = CompletableFuture.supplyAsync(()-> {
            var list1 = list.subList(0,5);
            Collections.sort(list1);
            try {
                System.out.println("In sort 1");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return list1;
        });

        CompletableFuture<List<Integer>> sort2 = CompletableFuture.supplyAsync(()-> {
            var list1 = list.subList(5,10);
            Collections.sort(list1);
            try {
                System.out.println("In sort 2");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return list1;
        });
        /*long start = System.nanoTime();
        System.out.println("Getting result.");
        System.out.println(sort1.get());
        System.out.println(sort2.get());
        System.out.println("Time : " + (System.nanoTime() - start));*/
    }
}
