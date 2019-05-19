import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] complex = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 1; j <= n; j++) {
                complex[i][j] = Integer.parseInt(tmp[j - 1]);
            }
        }
        br.close();

        boolean[][] traveled = new boolean[n + 2][n + 2];
        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        int[] mx = {0,0,-1,1};
        int[] my = {-1, 1, 0,0};

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (complex[i][j] == 1 && !traveled[i][j]){
                    traveled[i][j] = true;
                    xq.offer(j);
                    yq.offer(i);
                    int cnt = 1;
                    while (!xq.isEmpty()){
                        int cx = xq.poll();
                        int cy = yq.poll();
                        for (int k = 0; k < 4; k++) {
                            int tx = cx+mx[k];
                            int ty = cy+my[k];
                            if (complex[ty][tx] == 1 && !traveled[ty][tx]){
                                traveled[ty][tx] = true;
                                xq.offer(tx);
                                yq.offer(ty);
                                cnt++;
                            }
                        }
                    }

                    answers.add(cnt);
                }
            }
        }

        Collections.sort(answers);
        System.out.println(answers.size());
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(answers.get(i));
        }
    }
}
