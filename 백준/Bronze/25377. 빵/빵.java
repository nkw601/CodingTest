import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        // 가는데걸리는시간 빵나오기남은시간 -> 그 전에 도착해야함

        int minTime = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int toGo = Integer.parseInt(st.nextToken());
            int remain = Integer.parseInt(st.nextToken());

            if(toGo <= remain) minTime = Math.min(minTime, remain);
        }

        System.out.println(minTime < Integer.MAX_VALUE ? minTime : -1);
    }
}

