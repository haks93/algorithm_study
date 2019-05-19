import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (hashMap.containsKey(clothes[i][1]))
                hashMap.put(clothes[i][1], hashMap.get(clothes[i][1]) + 1);
            else
                hashMap.put(clothes[i][1], 1);
        }

        int sum = 1;

        for (int i :
                hashMap.values()) {
            sum = sum * (i + 1);
        }

        answer = sum - 1;

        return answer;
    }
}
