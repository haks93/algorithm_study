import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int[] d = new int[n+1];
        d[1] = 0;
        if(n > 1)
            d[2] = 1;
        if(n > 2)
            d[3] = 1;

        for (int i = 4; i <= n; i++) {
            if(i % 2 == 0 && i % 3 != 0)
                d[i] = min(d[i-1]+1, d[i/2]+1);
            else if(i % 2 != 0 && i % 3 == 0)
                d[i] = min(d[i-1]+1, d[i/3]+1);
            else if(i % 2 == 0 && i % 3 == 0)
                d[i] = min(min(d[i-1]+1, d[i/2]+1), d[i/3]+1);
            else
                d[i] = d[i-1]+1;
        }

        System.out.println(d[n]);
    }

    static int min(int a, int b){return a<b?a:b;}
}
