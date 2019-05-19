import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            for (int j = 0; j <= i; j++) {
//                sum += arr[j];
//            }
//            ans+=sum;
//        }
        for (int i = 0; i < n; i++) {
            int p = n - i;
            ans += arr[i]*p;
        }
        System.out.println(ans);
    }
}
