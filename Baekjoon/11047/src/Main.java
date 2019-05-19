import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int price = Integer.parseInt(tmp[1]);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int ans = 0;
        int sum = 0;
        Arrays.sort(arr);

        while (price - sum > 0){
            int mod = price;
            mod -= sum;
            int max = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] > mod)
                    break;
                max = arr[i];
            }

            sum += max;
            ans++;
        }
        System.out.println(ans);
    }
}
