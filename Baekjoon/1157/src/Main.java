import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] input = bufferedReader.readLine().toCharArray();
        bufferedReader.close();
        int[] count = new int[91];

        for (char c :
                input) {
            if (c > 90)
                c -= 32;
            count[c]++;
        }

        int ans = -1;
        int index = 0;
        boolean isSame = false;
        for (int i = 0; i < count.length; i++) {
            if (ans == count[i])
                isSame = true;
            else if (ans < count[i]){
                isSame = false;
                index = i;
                ans = count[i];
            }
        }

        if (isSame)
            System.out.println("?");
        else
            System.out.printf("%c\n", index);
    }
}
