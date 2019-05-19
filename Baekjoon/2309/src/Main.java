import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception{
        new Main().go();
    }

    public void go() throws Exception{

        int[] dwarfs = new int[9];

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(bufferedReader.readLine());
            sum += dwarfs[i];
        }
        Arrays.sort(dwarfs);

        boolean result = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(i == j)
                    continue;
                if(sum - dwarfs[i] - dwarfs[j] == 100){
                    result = true;
                    for (int k = 0; k < 9; k++) {
                        if(k == i || k == j)
                            continue;
                        System.out.println(dwarfs[k]);
                    }
                    break;
                }

                if (result)
                    break;
            }
        }
    }
}
