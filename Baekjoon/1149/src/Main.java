import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] house = new int[N+1][3];

        for (int i = 1; i < house.length; i++) {
            String[] tmp = bufferedReader.readLine().split(" ");
            house[i][0] = Integer.parseInt(tmp[0]);
            house[i][1] = Integer.parseInt(tmp[1]);
            house[i][2] = Integer.parseInt(tmp[2]);
        }

        int[][] d = new int[N+1][3];

        for (int i = 1; i < d.length; i++) {
            d[i][0] = min(d[i-1][1], d[i-1][2]) + house[i][0];
            d[i][1] = min(d[i-1][0], d[i-1][2]) + house[i][1];
            d[i][2] = min(d[i-1][0], d[i-1][1]) + house[i][2];
        }

        System.out.println(min(min(d[N][0], d[N][1]), d[N][2]));
    }

    public static int min(int a, int b){
        return a < b ? a : b;
    }
}
