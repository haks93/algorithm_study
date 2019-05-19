import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Boolean> officers = new HashMap();

        try{
            int count = Integer.parseInt(bufferedReader.readLine());
            String input;
            boolean attendance;
            for(int i = 0; i < count; ++i){
                input = bufferedReader.readLine();
                String[] tmp = input.split(" ");
                attendance = tmp[1].equals("enter") ? true : false;
                officers.put(tmp[0], attendance);
            }

            List<String> output = new ArrayList<>();
            for (String oName :
                    officers.keySet()) {
                if(officers.get(oName)) {
                    output.add(oName);
                }
            }
            String[] output2 = output.toArray(new String[output.size()]);
            Arrays.sort(output2);
            for(int i = output2.length - 1; i >= 0; --i){
                bufferedWriter.write(output2[i]);
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e){
            e.getStackTrace();
        }
    }
}
