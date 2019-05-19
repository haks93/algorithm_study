import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        bufferedReader.close();
        int left = 0, right = 0;
        int leftCnt = 0, rightCnt = 0;
        for (int i = 0; i < n; i++) {
            if (left < arr[i]) {
                left = arr[i];
                leftCnt++;
            }
            if (right < arr[n-1-i]) {
                right = arr[n-1-i];
                rightCnt++;
            }
        }

        System.out.println(leftCnt + "\n" + rightCnt);
    }
}
