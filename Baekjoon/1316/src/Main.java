import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        int result = T;

        while (T-- > 0) {
            char[] input = bufferedReader.readLine().toCharArray();
            boolean[] isGroup = new boolean[26];
            isGroup[input[0]-'a'] = true;
            for (int i = 1; i < input.length; i++){
                if (input[i-1] == input[i])
                    continue;
                if (isGroup[input[i] - 'a']) {
                    result--;
                    break;
                }
                isGroup[input[i]-'a'] = true;
            }
        }

        System.out.println(result);
    }
}
