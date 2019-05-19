import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int y = Integer.parseInt(tmp[0]), x = Integer.parseInt(tmp[1]);
        int[][] map = new int[y + 2][x + 2];
        for (int i = 1; i < y + 1; i++) {
            tmp = br.readLine().split("");
            for (int j = 1; j < x + 1; j++) {
                map[i][j] = Integer.parseInt(tmp[j - 1]);
            }
        }

        int[][] recordMap = new int[y+2][x+2];
        boolean[][] bitMap = new boolean[y+2][x+2];

        recordMap[1][1] = 1;
        bitMap[1][1] = true;
        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();

        xq.offer(1);
        yq.offer(1);

        int[] mx = {0,0,-1,1};
        int[] my = {-1,1,0,0};

        while (!xq.isEmpty()) {
            int cx = xq.poll();
            int cy = yq.poll();

            if (cx == x && cy == y)
                break;

            for (int i = 0; i < 4; i++) {
                int dx = cx + mx[i];
                int dy = cy + my[i];

                if(map[dy][dx] == 0 || bitMap[dy][dx])
                    continue;

                if(recordMap[dy][dx] > map[cy][cx] + 1 || recordMap[dy][dx] == 0){
                    xq.offer(dx);
                    yq.offer(dy);
                    recordMap[dy][dx] = recordMap[cy][cx] + 1;
                    bitMap[dy][dx] = true;
                }
            }
        }

        System.out.println(recordMap[y][x]);
    }
}
