import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int rounds = n + 1;
        int min = rounds * 2;
        int max = rounds * 3;

        System.out.println(min + " " + max);
    }
}