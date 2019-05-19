import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            int fast = 0, slow = 0;
            String[] tmp = br.readLine().split(" ");
            int l = Integer.parseInt(tmp[0]), n = Integer.parseInt(tmp[1]);
            int[] loc = new int[n];
            for (int i = 0; i < n; i++) {
                loc[i] = Integer.parseInt(br.readLine());
            }

            int half = l/2;
            int far = 0x7fffffff;
            int index = 0;
            int index1 = 0;
            int close = 0;

            for (int i = 0; i < n; i++) {
                if(far > abs(half, loc[i])){
                    far = abs(half, loc[i]);
                    index = i;
                }
                if(close < abs(half, loc[i])){
                    close = abs(half, loc[i]);
                    index1 = i;
                }
            }

            if(loc[index]-0 > l - loc[index]){
                fast = l - loc[index];
            } else {
                fast = loc[index] - 0;
            }
            if(loc[index1] - 0 < l - loc[index1])
                slow = l-loc[index1];
            else
                slow = loc[index1]-0;
            System.out.printf("%d %d\n", fast, slow);
        }

    }

    static int abs(int a, int b){return a-b<0 ? b-a : a-b;}
}
