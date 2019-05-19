import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] a = new int[n+1];
        int[] d = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(bufferedReader.readLine());
            if(i < 3)
                d[i] = a[i-1]+a[i];
        }


        for (int i = 3; i <= n; i++) {
            d[i] = max(d[i-3] + a[i-1] + a[i], d[i-2] + a[i]);
        }

        System.out.println(d[n]);
    }

    static int max(int a, int b){return a > b ? a : b;}
}
