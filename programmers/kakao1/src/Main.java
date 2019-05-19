import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        String[] answer = new Solution().solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                "Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        for (String s :
                answer) {
            System.out.println(s);
        }
    }
}

class Solution {
    public String[] solution(String[] record) {

        String[] answer = {};
        HashMap<String, String> users = new HashMap<>();
        ArrayList<String> log = new ArrayList<>();

        for (String s :
                record) {
            String[] tmp = s.split(" ");
            if (tmp[0].equals("Leave")) {
                log.add(tmp[1] + " " + "나갔습니다.");
            } else {
                users.put(tmp[1], tmp[2]);

                if (tmp[0].equals("Enter")) {
                    log.add(tmp[1] + " " + "들어왔습니다.");
                }
            }
        }

        answer = log.toArray(new String[log.size()]);
        for (int i = 0; i < answer.length; i++) {
            String tmp[] = answer[i].split(" ");
            String name = users.get(tmp[0]);
            answer[i] = name+ "님이" + " " + tmp[1];
        }
        return answer;
    }
}

