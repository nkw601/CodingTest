import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        for(int i = 0; i < 26; i++){
            sb.append(s.indexOf('a' + i)).append(" ");
        }
        System.out.println(sb);
    }
}