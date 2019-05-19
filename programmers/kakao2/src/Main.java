public class Main {

    public static void main(String[] args) {

        int[] arr = new Solution().solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        for (int i :
                arr) {
            System.out.println(i);
        }
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        int[] fail = new int[N+2];
        int[] clear = new int[N+2];

        for (int i = 0; i < stages.length; i++) {
            ++fail[stages[i]];
            for (int j = 1; j <= stages[i]; j++) {
                ++clear[j];
            }
        }

        float[] failRate = new float[N+1];

        for (int i = 1; i < failRate.length; i++) {
            if(clear[i] == 0)
                failRate[i] = 0;
            else
                failRate[i] = (float) fail[i] / clear[i];
        }
        answer = new int[N];

        for (int i = 1; i < failRate.length; i++) {
            int tmp = -1;
            float tmp1 = - 1;
            for (int j = 1; j < failRate.length; j++) {
                if(tmp1 < failRate[j]) {
                    tmp1 = failRate[j];
                    tmp = j;
                }
            }
            answer[i - 1] = tmp;
            failRate[tmp] = -1;
        }

        return answer;
    }
}