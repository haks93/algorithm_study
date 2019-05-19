import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try{
            int n = Integer.parseInt(bufferedReader.readLine());
            int iter = n/14;
            int loc = n%14;
            String result="";
            switch (loc){
                case 1:
                case 13:
                    result = "baby";
                    break;
                case 2:
                case 0:
                    result = "sukhwan";
                    break;
                case 5:
                    result = "very";
                    break;
                case 6:
                    result = "cute";
                    break;
                case 9:
                    result = "in";
                    break;
                case 10:
                    result = "bed";
                    break;
                case 3:
                case 7:
                case 11:
                    result = "tu"+noRu(iter+2);
                    break;
                case 4:
                case 8:
                case 12:
                    result = "tu"+noRu(iter+1);
                    break;
            }
            System.out.println(result);
            bufferedReader.close();
        }catch (IOException e){
            e.getStackTrace();
        }
    }

    public static String noRu(int iter){
        String result = "";
        if(iter >= 5){
            result = "+ru*"+iter;
        }
        else {
            for (int i = 0; i < iter; i++) {
                result += "ru";
            }
        }
        return  result;
    }
}
