import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int tc = Integer.parseInt(br.readLine());
            for(int i = 0; i < tc; i++){
                String s = br.readLine();
                sb.append(s.charAt(0)).append(s.charAt(s.length() - 1)).append('\n');
            }
            System.out.println(sb);
        }
}

