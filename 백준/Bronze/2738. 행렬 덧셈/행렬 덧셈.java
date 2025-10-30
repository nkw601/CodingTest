import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                arr[i][j] += Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
