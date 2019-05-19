import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            String[] tmp = bufferedReader.readLine().split(" ");
            sum = Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[1]) + Integer.parseInt(tmp[2])
                    + Integer.parseInt(tmp[3]);

            switch (sum){
                case 0:
                    System.out.println("D");
                    break;
                case 3:
                    System.out.println("A");
                    break;
                case 2:
                    System.out.println("B");
                    break;
                case 1:
                    System.out.println("C");
                    break;
                case 4:
                    System.out.println("E");
                    break;
            }
        }
    }
}
