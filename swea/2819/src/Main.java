import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    private static int[] mx = new int[]{0,0,1,-1};
    private static int[] my = new int[]{1,-1,0,0};
    private static int[][] map;
    private static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());


        for(int test_case = 0; test_case < T; test_case++){
            map = new int[4][4];
            set.clear();
            for (int i = 0; i < 4; i++) {
                String[] tmp = bufferedReader.readLine().split(" ");
                for (int j = 0; j < 4; j++) {
                    map[i][j] = Integer.parseInt(tmp[j]);
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    move(i, j, map[i][j], 0);
                }
            }
        System.out.printf("#%d %d\n", test_case+1, set.size());
        }
    }

    public static void move(int x, int y, int val, int cnt){
        if(cnt == 6){
            set.add(val);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int tx = x+mx[i];
            int ty = y+my[i];

            if(tx < 0 || tx >= 4 || ty < 0 || ty >= 4) {
                continue;
            }

            move(tx, ty, val*10 + map[tx][ty], cnt + 1);
        }
    }
}
