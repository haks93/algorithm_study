import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, Integer> indexMap = new HashMap<>();
        int[] arr2 = new int[100];
        Map[] arr = new Map[100];
        int index = 0;
        for (int i = 0; i < genres.length; i++) {
            if(!indexMap.containsKey(genres[i])) {
                indexMap.put(genres[i], index++);
            }
            int t = indexMap.get(genres[i]);
            arr2[t] += plays[i];
            if(arr[t].size() == 0){
                TreeMap<Integer, Integer> tmp = new TreeMap<>();
                tmp.put(plays[i], i);
                arr[t] = tmp;
            } else {
                arr[t].put(plays[i], i);
            }
        }

        Arrays.sort(arr2);
        arr[0].
        return answer;
    }
}

//class Song implements Comparable<Song>{
//    int plays;
//    int id;
//    public Song(int plays, int id){
//        this.plays = plays;
//        this.id = id;
//    }
//
//    @Override
//    public int compareTo(Song o) {
//        if (o.plays > this.plays)
//            return 1;
//        else
//            return -1;
//    }
//}