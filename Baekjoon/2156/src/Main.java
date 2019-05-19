import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[n + 3];
        int[] dp = new int[n + 3];
        for (int i = 3; i < n + 3; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 3; i < n+3; i++) {
            dp[i] = max(max(dp[i-3] + arr[i-1] + arr[i], arr[i-1] + arr[i]), dp[i-1]);
        }

        System.out.println(dp[n+2]);
    }
    static int max(int a, int b) {
        return a > b ? a : b;
    }
}
