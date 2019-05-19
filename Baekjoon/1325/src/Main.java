import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        ArrayList<Integer>[] arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[1]), b = Integer.parseInt(tmp[0]);
            arr[a].add(b);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] memo = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if(memo[i] != 0)
                continue;
            queue.offer(i);
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int j :
                        arr[current]) {
                    if (memo[j] != 0){
                        memo[i] += memo[j];
                        continue;
                    }
                    queue.offer(j);
                    cnt++;
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < memo.length; i++) {
            if(max < memo[i])
                max = memo[i];
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] == max)
                set.add(i);
        }

        for (int i :
                set) {
            System.out.print(i+" ");
        }
    }
}
