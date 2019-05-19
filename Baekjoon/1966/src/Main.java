import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args){
        new Main().go();
    }

    public void go(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n; i++){
                String[] input = bufferedReader.readLine().split(" ");
                int nn = Integer.parseInt(input[0]);
                int who = Integer.parseInt(input[1]);
                int loc = Integer.parseInt(input[1]);
                Queue<Target> queue = new LinkedList<>();
                String[] order = bufferedReader.readLine().split(" ");

                for (int j = 0; j < nn; j++) {
                    boolean b = false;
                    if(j == who)
                        b = true;
                    queue.add(new Target(Integer.parseInt(order[j]), b));
                }
                int cnt = 0;
                while (true){
                    Target first = queue.poll();
                    boolean biggest = true;
                    for (Target t:
                         queue) {
                        if(first.v < t.v){
                            queue.add(first);
                            biggest = false;
                            break;
                        }
                    }

                    if (biggest){
                        cnt++;
                        if (first.isTarget){
                            System.out.println(cnt);
                            break;
                        }
                    }
                }
            }
        }catch (IOException e){
            e.getStackTrace();
        }
    }
}

class Target{
    int v;
    boolean isTarget;

    public Target(int v, boolean t){
        this.v = v;
        this.isTarget = t;
    }
}