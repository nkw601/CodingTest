import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            for(int c = 0; c < N - i; c++){
                System.out.print(" ");
            }
            for(int c = 0; c < 2 * i - 1; c++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = N - 1; i > 0; i--){
            for(int c = 0; c < N - i; c++){
                System.out.print(" ");
            }
            for(int c = 0; c < 2 * i - 1; c++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
