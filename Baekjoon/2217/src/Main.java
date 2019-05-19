import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int tmp = arr[i] * (n-i);
            if(ans < tmp)
                ans = tmp;
        }

        System.out.println(ans);
    }
}
