import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            int t = Integer.parseInt(scanner.nextLine());
            int start = 1;
            int sum = 0;
            int answer = 1;
            while (start < t) {
                sum = start;
                for (int i = start + 1; sum + i <= t; i++) {
                    sum += i;
                }

                if (sum == t)
                    answer++;
                start++;
            }

            int index = 1;
            System.out.println("#" + index++ + " " + answer);
        }
    }
}
