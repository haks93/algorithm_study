import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        new Solution().solution(new String[]{""});
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<Character, HashMap> hashMap = new HashMap<>();
        ArrayList<HashMap> list = new ArrayList<>();

        for (int i = 0; i < phone_book.length; i++) {

            char[] arr = phone_book[i].toCharArray();

            for (int j = 0; j < arr.length; j++) {
                HashMap<Character, HashMap> tmp = new HashMap<>();
                list.add(tmp);
                hashMap.put(arr[j], tmp);
            }
        }

        return answer;
    }
}

class Test {
    private int test;
    public Test(int test) {
        this.test = test;
    }
}q