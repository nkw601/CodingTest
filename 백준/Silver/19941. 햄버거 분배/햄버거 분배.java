import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 자신보다 왼쪽 -> 오른쪽에 있는 햄버거 먹기
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] table = br.readLine().toCharArray();
        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(table[i] != 'P') continue;
            // 왼쪽
            boolean eaten = false;
            for(int d = K; d > 0; d--){
                int idx = i - d;
                if(idx >= 0 && table[idx] == 'H'){
                    eaten = true;
                    table[idx] = '.'; // 먹었음
                    cnt++;
                    break;
                }
            }
            if(eaten) continue;
            
            // 오른쪽
            for(int d = 1; d <= K; d++){
                int idx = i + d;
                if(idx < N && table[idx] == 'H') {
                    eaten = true;
                    table[idx] = '.'; // 먹었음
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}