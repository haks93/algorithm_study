import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int t, m, n;
        Scanner scanner = new Scanner(System.in);
        t = Integer.parseInt(scanner.nextLine());

        for (int test_case = 0; test_case < t; test_case++) {
            String[] tmp = scanner.nextLine().split(" ");
            m = Integer.parseInt(tmp[0]);
            n = Integer.parseInt(tmp[1]);

            int[] array = new int[m+n+1];

            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    array[j+k]++;
                }
            }

            ArrayList<Integer> bigs = new ArrayList<>();
            int big = -1;
            for (int j = 0; j < array.length; j++) {
                if(big < array[j]) {
                    big = array[j];
                }
            }

            for (int j = 0; j < array.length; j++) {
                if (big == array[j])
                    bigs.add(j);
            }

            int index = test_case+1;
            System.out.print("#"+index+" ");
            for (int j = 0; j < bigs.size(); j++) {
                System.out.print(bigs.get(j) + " ");
            }
            System.out.println();
        }
    }
}
