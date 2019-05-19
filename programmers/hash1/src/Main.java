import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]
                {"marina", "josipa", "nikola", "vinko", "fillipa"},
                new String[]{"josipa", "fillipa", "marina", "nikola"}));
    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for (String s :
                completion) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else
                map.put(s, 1);
        }

        for (String s :
                participant) {
            if (map.containsKey(s)){
                map.put(s, map.get(s) - 1);

                if (map.get(s) == 0){
                    map.remove(s);
                }
            } else {
                answer = s;
                break;
            }
        }
        return answer;
    }
}