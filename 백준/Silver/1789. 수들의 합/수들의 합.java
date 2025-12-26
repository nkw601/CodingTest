import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine().trim());

        long sum = 0;
        long n = 0;

        while (sum + (n + 1) <= S) {
            n++;
            sum += n;
        }

        System.out.println(n);
    }
}