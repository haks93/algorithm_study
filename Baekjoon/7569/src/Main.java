import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int z = Integer.parseInt(tmp[2]), y = Integer.parseInt(tmp[1]), x = Integer.parseInt(tmp[0]);
        int[][][] map = new int[z][y][x];
        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();
        Queue<Integer> zq = new LinkedList<>();

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                tmp = br.readLine().split(" ");
                for (int k = 0; k < x; k++) {
                    map[i][j][k] = Integer.parseInt(tmp[k]);
                    if (map[i][j][k] == 1) {
                        zq.offer(i);
                        yq.offer(j);
                        xq.offer(k);
                    }
                }
            }
        }

        int[] mz = {0, 0, 0, 0, -1, 1};
        int[] my = {0, 0, -1, 1, 0, 0};
        int[] mx = {-1, 1, 0, 0, 0, 0};

        if(xq.isEmpty()) {
            System.out.println(0);
            return;
        }

        while (!xq.isEmpty()){
            int cx = xq.poll(), cy = yq.poll(), cz = zq.poll();
            for (int i = 0; i < 6; i++) {
                int tz = cz+mz[i], ty = cy+my[i], tx = cx+mx[i];
                if(tx<0||tx==x||ty<0||ty==y||tz<0||tz==z)
                    continue;
                if(map[tz][ty][tx] == 0){
                    zq.offer(tz);
                    yq.offer(ty);
                    xq.offer(tx);
                    map[tz][ty][tx] = map[cz][cy][cx] + 1;
                }
            }
        }

        int max = 0;
        int min = 0x7fffffff;
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if(map[i][j][k] == -1)
                        continue;
                    if(map[i][j][k] > max)
                        max = map[i][j][k];
                    if(map[i][j][k] < min)
                        min = map[i][j][k];
                }
            }
        }

        if(min == 0)
            System.out.println(-1);
        else
            System.out.println(max-1);
    }
}
