import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map;
    static Queue<Integer> queue;
    static  boolean[] traveled;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        int aIndex = 1;

        while (T-- > 0) {
            int answer = 0;
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

            int n = Integer.parseInt(stringTokenizer.nextToken());
            int r = Integer.parseInt(stringTokenizer.nextToken());

            map = new boolean[n + 1][n + 1];
            traveled = new boolean[n + 1];
            queue = new LinkedList<>();

            for (int i = 0; i < r; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());
                map[a][b] = true;
                map[b][a] = true;
            }

            for (int i = 1; i < traveled.length; i++) {
                if (!traveled[i]) {
                    answer++;
                    queue.offer(i);
                    while (!queue.isEmpty()) {
                        int current = queue.poll();
                        for (int j = 1; j < n + 1; j++) {
                            if (!traveled[j] && map[current][j]) {
                                queue.offer(j);
                                traveled[j] = true;
                            }
                        }
                    }
                }
            }

            System.out.println("#" + aIndex + " " + answer);
            aIndex++;
        }
    }
}
