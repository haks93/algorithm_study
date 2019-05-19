import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] map = new int[n+1];
            String[] tmp = br.readLine().split(" ");
            for (int i = 0; i < tmp.length; i++) {
                map[i+1] = Integer.parseInt(tmp[i]);
            }

            Queue<Integer> queue = new LinkedList<>();
            boolean[] traveled = new boolean[n+1];
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if(traveled[i])
                    continue;
                traveled[i] = true;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int next = map[queue.poll()];
                    if(!traveled[next]){
                        traveled[next] = true;
                        queue.offer(next);
                    }
                }
                cnt++;
            }

            System.out.println(cnt);
        }
    }
}
