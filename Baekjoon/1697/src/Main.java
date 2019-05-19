import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int subin = scanner.nextInt();
        int brother = scanner.nextInt();
        if (subin == brother){
            System.out.println(0);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(subin);
        int[] mv = {-1, 1, 0};
        int cnt = 0;
        boolean[] traveled = new boolean[100001];
        traveled[subin] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int j = 0; j < 3; j++) {
                    int next = current + mv[j];
                    if (j == 2)
                        next = current * 2;

                    if (next == brother){
                        System.out.println(cnt + 1);
                        return;
                    }

                    if (next >= 0 && next <= 100000 && !traveled[next]){
                        traveled[next] = true;
                        queue.offer(next);
                    }
                }
            }
            cnt++;
        }
    }
}
