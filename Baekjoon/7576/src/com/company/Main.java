package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Queue<int[]> queue = new LinkedList<>();
    static int[][] map;
    static int[] mx = {0, 0, -1, 1};
    static int[] my = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int x = Integer.parseInt(tmp[0]), y = Integer.parseInt(tmp[1]);
        map = new int[y + 2][x + 2];
        Arrays.fill(map[0], -1);
        Arrays.fill(map[y + 1], -1);
        for (int i = 1; i < y + 1; i++) {
            tmp = br.readLine().split(" ");
            for (int j = 1; j < x + 1; j++) {
                map[i][j] = Integer.parseInt(tmp[j - 1]);
                if (map[i][j] == 1)
                    queue.offer(new int[]{i, j});
            }
        }

        for (int i = 0; i < y + 2; i++) {
            map[i][0] = -1;
            map[i][x + 1] = -1;
        }

        if (queue.isEmpty() || queue.size() == x * y)
            System.out.println(0);
        else {
            while (!queue.isEmpty()) {
                int ny = queue.peek()[0], nx = queue.poll()[1];
                for (int i = 0; i < 4; i++) {
                    int nextTomato = map[ny + my[i]][nx + mx[i]];
                    if (nextTomato == 0) {
                        map[ny + my[i]][nx + mx[i]] = map[ny][nx] + 1;
                        queue.offer(new int[]{ny+my[i], nx+mx[i]});
                    }
                }
            }
        }
        int max = 0;
        int min = 0x7fffffff;
        for (int i = 1; i < y + 1; i++) {
            for (int j = 1; j < x + 1; j++) {
                if (map[i][j] > max) {
                    max = map[i][j];
                }
                if(map[i][j] < min)
                    min = map[i][j];
            }
        }

        if(min == 0)
            System.out.println(-1);
        else
            System.out.println(max-1);
    }
}

