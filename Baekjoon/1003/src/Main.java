import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] memo = new int[41];
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        memo[0] = 1;
        memo[1] = 1;
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0){
            int t = Integer.parseInt(bufferedReader.readLine());
            if(t == 0)
                System.out.println("1 0");
            else if (t == 1)
                System.out.println("0 1");
            else {
                pibo(t);
                System.out.printf("%d %d\n", memo[t-2], memo[t-1]);
            }
        }
    }

    static int pibo(int n){
        if (n <= 1)
            return memo[n];
        if (memo[n] > 0)
            return memo[n];

        return memo[n] = pibo(n-1) + pibo(n-2);
    }
}
