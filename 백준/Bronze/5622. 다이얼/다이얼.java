import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int t = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'W') t += 10;
            else if(c >= 'T') t += 9;
            else if(c >= 'P') t += 8;
            else if(c >= 'M') t += 7;
            else if(c >= 'J') t += 6;
            else if(c >= 'G') t += 5;
            else if(c >= 'D') t += 4;
            else if(c >= 'A') t += 3;
            else t += 2;
        }
        System.out.println(t);
    }
}
