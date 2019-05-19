import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        new Main().go();
    }

    public void go() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(gcd(n, i) == 1)
                cnt++;
        }

        System.out.println(cnt);
    }

    public int gcd(int a, int b){
        int mod = a % b;
        while(mod > 0){
            a = b;
            b = mod;
            mod = a % b;
        }

        return b;
    }
}
