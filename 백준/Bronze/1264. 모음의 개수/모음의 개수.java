import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String sent = br.readLine();

            if(sent.equals("#")) break;
            int vowelCnt = 0;

            for(char c : sent.toLowerCase().toCharArray()){
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowelCnt++;
            }

            sb.append(vowelCnt).append('\n');
        }

        System.out.println(sb);

    }
}