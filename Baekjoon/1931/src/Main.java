import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            int s = Integer.parseInt(tmp[0]), f = Integer.parseInt(tmp[1]);
            if(!map.containsKey(f)){
                ArrayList<Integer> set = new ArrayList<>();
                set.add(s);
                map.put(f, set);
            } else {
                map.get(f).add(s);
            }
        }
        br.close();

        for (int i :
                map.keySet()) {
            Collections.sort(map.get(i));
        }
        int ans = 0;
        int prev = 0;

        for (int i :
                map.keySet()) {
            for (int j :
                    map.get(i)) {

                if(prev <= j){
                    ans++;
                    prev = i;
                }
            }
        }

        System.out.println(ans);
    }
}