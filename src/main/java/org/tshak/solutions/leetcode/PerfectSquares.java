package org.tshak.solutions.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares {
    public static void main(String[] args) {
        PerfectSquares p = new PerfectSquares();
        p.numSquares(12);
        int[] data;
    }
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        if (n <= 0)
            return 0;
        queue.offer(n);
        int level = 0;
        while (!queue.isEmpty()) {
            ++level;
            int size = queue.size();
            for (int i =0; i < size; i++) {
                int val = queue.poll();
                if (!visited.add(val))
                    continue;
                for (int j = 1; j <= Math.sqrt(val); j++) {
                    if (val - j * j == 0)
                        return level;
                    queue.add(val - j * j);
                }
            }
        }
        return level;
    }
}
