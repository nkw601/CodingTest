import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int size = Math.min(N, M) / 2;

        int[][] result = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < R; i++) {
            for(int j = 0; j < size; j++) {
                rotate(arr, result, N, M, j);
            }
            int[][] temp = arr;
            arr = result;
            result = temp;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotate(int[][] arr, int[][] result, int N, int M, int start){
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                result[i][j] = arr[i][j];
//            }
//        }

        int fin = arr[start][start];
        int n = N - start;
        int m = M - start;
        // 왼쪽 세로: 아래로
        for (int i = start; i < n - 1; i++) {
            result[i + 1][start] = arr[i][start];
        }

        // 아래쪽 가로: 오른쪽으로
        for (int j = start; j < m - 1; j++) {
            result[n - 1][j +  1] = arr[n - 1][j];
        }

        // 오른쪽 세로: 위쪽으로
        for (int i = n - 1; i > start; i--) {
            result[i - 1][m - 1] = arr[i][m - 1];
        }

        // 위쪽 가로: 왼쪽으로
        for (int j = m - 1; j > start; j--) {
            result[start][j - 1] = arr[start][j];
        }

        result[start + 1][start] = fin;
    }
}
