import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sco = 0;
        for(int i = 0; i < 5; i++) {
            int s = Integer.parseInt(br.readLine());
            sco += s > 40 ? s : 40;
        }
        System.out.println(sco / 5);
    }
}