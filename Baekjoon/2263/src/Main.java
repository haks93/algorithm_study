import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private int preIndex = 0;
    private int[] position, postorder, inorder;

    public static void main(String[] args) throws Exception{
        new Main().go();
    }

    public void go() throws Exception{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        String[] tmp1 = bufferedReader.readLine().split(" ");
        String[] tmp2 = bufferedReader.readLine().split(" ");

        inorder = new int[n];
        postorder = new int[n];
        position = new int[n + 1];

        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(tmp1[i]);
            postorder[i] = Integer.parseInt(tmp2[i]);
        }

        for (int i = 0; i < n; i++) {
            position[inorder[i]] = i;
        }

        solve(0, n-1, 0, n-1);
    }

    public void solve(int inStart, int inLast, int postStart, int postLast){
        if(inStart > inLast || postStart > postLast)
            return;
        int root = postorder[postLast];
        System.out.print(root + " ");
        int p = position[root];
        int left = p - inStart;
        solve(inStart, p - 1, postStart, postStart + left - 1);
        solve(p + 1, inLast, postStart + left, postLast - 1);
    }
}
