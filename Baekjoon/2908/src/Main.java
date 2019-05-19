import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        bufferedReader.close();
        char[] t1 = input[0].toCharArray(), t2 = input[1].toCharArray();
        boolean big2 = false;
        for (int i = 2; i >= 0; i--) {
            if (t1[i] < t2[i]){
                big2 = true;
                break;
            } else if (t1[i] > t2[i])
                break;
        }

        if (big2){
            for (int i = 2; i >= 0; i--) {
                System.out.print(t2[i]);
            }
        } else {
            for (int i = 2; i >= 0; i--) {
                System.out.print(t1[i]);
            }
        }
    }
}
