import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        int index = 1;
        while (T-- > 0) {
            int n = scanner.nextInt(), m = scanner.nextInt();
            scanner.nextLine();

            char[][] lotteryNumber = new char[n][8];
            int[] lotteryPrice = new int[n];

            for (int i = 0; i < n; i++) {
                String[] tmp = scanner.nextLine().split(" ");
                lotteryNumber[i] = tmp[0].toCharArray();
                lotteryPrice[i] = Integer.parseInt(tmp[1]);
            }

            char[][] sangwon = new char[m][8];
            for (int i = 0; i < m; i++) {
                sangwon[i] = scanner.nextLine().toCharArray();
            }

            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < 8; k++) {
                        if (lotteryNumber[i][k] == '*')
                            continue;
                        if (lotteryNumber[i][k] != sangwon[j][k]) {
                            break;
                        }
                        if (k == 7 && lotteryNumber[i][k] == sangwon[j][k])
                            sum += lotteryPrice[i];
                    }
                }
            }
            System.out.println("#" + index + " " + sum);
        }
    }
}

