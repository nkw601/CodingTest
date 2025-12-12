import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int hei = 10;
        for(int i = 1; i < s.length(); i++){
            char cur = s.charAt(i);

            if(cur == s.charAt(i -1)) hei+= 5;
            else hei += 10;
        }
        System.out.println(hei);
    }
}