import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for(int i = 0; i < n; i++){
            String[] tmp = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);

            System.out.println(mcn(a, b));
        }
    }

    public static int gcd(int a, int b){
        int mod = a % b;

        while(mod > 0){
            a = b;
            b = mod;
            mod = a % b;
        }

        return b;
    }

    public static int mcn(int a, int b){
        return a * b / gcd(a, b);
    }
}
