import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuffer sb1 =  new StringBuffer(st.nextToken());
        StringBuffer sb2 =  new StringBuffer(st.nextToken());

        int n1 = Integer.parseInt(sb1.reverse().toString());
        int n2 = Integer.parseInt(sb2.reverse().toString());

        System.out.println(Math.max(n1, n2));

    }
}
