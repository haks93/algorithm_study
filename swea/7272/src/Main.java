import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        int index = 1;
        while (T-- > 0){
            String[] input = scanner.nextLine().split(" ");
            char[] first = input[0].toCharArray();
            char[] second = input[1].toCharArray();

            if (first.length != second.length){
                System.out.println("#" + index + " " + "DIFF");
                index++;
                continue;
            }
            boolean result = true;
            for (int i = 0; i < first.length; i++) {
                if (solve(first[i]) != solve(second[i])){
                    result = false;
                    break;
                }
            }

            if (result)
                System.out.println("#" + index + " SAME");
            else
                System.out.println("#"+index+" DIFF");
            index++;
        }
    }

    public static int solve(char a){
        switch (a){
            case 'A':
            case 'D':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
                return 1;
            case 'B':
                return 2;
                default:
                    return 3;
        }
    }
}
