import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception{
        new Main().go();
    }

    public void go() throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }

        int pop;
        for (int i = 0; i < n; i++) {
            pop = queue.peek();
            for (int compare :
                    queue) {
                if(firstDigit(compare) < pop % 10){
                    queue.offer(Integer.parseInt(""+pop+""+compare));
                }
            }
        }
    }

    public int firstDigit(int a){
        int b = a;
        while(b < 10){
            b = a / 10;
        }
        return b;
    }
}