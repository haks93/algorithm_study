import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
       new Main().go();
    }

    public void go(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try{
            String[] input = bufferedReader.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            int[][] loc = new int[r+w+1][r+w+1];

            int result = 0;

            for (int i = 1; i < r+w+1; i++) {
                for (int j = 1; j <= i ; j++) {
                    if(i==j || j == 1){
                        loc[i][j] = 1;
                    }else{
                        loc[i][j] = loc[i-1][j-1] + loc[i-1][j];
                    }
                }
            }

            for (int i = 0; i < w; i++) {
                for (int j = 0; j <= i; j++) {
                    result += loc[r+i][c+j];
                }
            }
            System.out.println(result);
        } catch (IOException e){
            e.getStackTrace();
        }
    }
}