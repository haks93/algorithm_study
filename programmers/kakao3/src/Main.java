public class Main {

    public static void main(String[] args) {

        int i = new Solution().solution(new String[][]{{"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}});
        System.out.println(i);
    }
}

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;

        int n = relation.length, m = relation.length;

        boolean endCon = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    if(j == k)
                        continue;
                    if(relation[i][j] == relation[i][k]){
                        endCon = true;
                        break;
                    }
                }
                if (endCon)
                    break;
            }
            if (!endCon)
                ++answer;
        }
        return answer;
    }
}
