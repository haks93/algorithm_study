import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int mod = 1000000000;
        bufferedReader.close();
        int[][] d = new int[n+1][11];
        for (int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            d[i][0] = d[i-1][1]%mod;
            for (int j = 1; j <= 9; j++) {
                    d[i][j] = (d[i-1][j-1]+d[i-1][j+1])%mod;
            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += d[n][i];
        }
        System.out.println(sum%mod);
    }
}
