import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[][] networks = new boolean[T + 1][T + 1];
        boolean[] traveled = new boolean[T + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            int com1 = Integer.parseInt(tmp[0]);
            int com2 = Integer.parseInt(tmp[1]);
            networks[com1][com2] = true;
            networks[com2][com1] = true;
        }

        queue.offer(1);
        traveled[1] = true;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int next = queue.poll();
            for (int i = 1; i <= T; i++) {
                if (networks[next][i] == true && !traveled[i]) {
                    queue.offer(i);
                    traveled[i] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
