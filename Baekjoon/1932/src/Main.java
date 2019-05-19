import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] a = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            String[] tmp = bufferedReader.readLine().split(" ");
            for (int j = 1; j <= i; j++){
                a[i][j] = Integer.parseInt(tmp[j-1]);
            }
        }

        int[][] d = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                d[i][j] = max(d[i-1][j-1], d[i-1][j]) + a[i][j];
            }
        }

        int mn = 0;
        for (int i = 1; i <= n; i++) {
            if(mn < d[n][i])
                mn = d[n][i];
        }

        System.out.println(mn);
    }

    static int max(int a, int b){return a > b ? a : b;}
}
