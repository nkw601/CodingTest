import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] map;
    private static int N, K, L;
    private static HashMap<Integer, String> direction;

    private static int[] dr = {0, 1, 0, -1}, dc ={1, 0, -1, 0}; // 우 -> 하 -> 좌 -> 상

    private static int d = 0; // 오른쪽 출발
    private static int[] head = {0, 0}, tail = {0, 0}; // 머리 위치
    private static ArrayDeque<int[]> snake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        snake = new ArrayDeque<>();

        // init
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        map[0][0] = 1; // 시작점 뱀의 위치

        snake.add(new int[] {0, 0});

        K = Integer.parseInt(br.readLine()); // 사과의 개수
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            map[r][c] = 2; // 사과
        }

        L = Integer.parseInt(br.readLine()); // 뱀의 방향 전환 횟수
        direction = new HashMap<>();

        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine()); // 초 방향
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken();

            direction.put(t, d);
        }

        // 게임
        int time = 0;
        while (true) {
            time++;

            // 머리 늘리기
            int nr = head[0] + dr[d];
            int nc = head[1] + dc[d];

            // 게임 종료
            if(!isIn(nr, nc)) break;

            if (map[nr][nc] == 1) {
                boolean isTail = (tail[0] == nr && tail[1] == nc);
                if (!(isTail)) {
                    break;
                }
            }

            if(map[nr][nc] != 2) { // 사과 없음
                tail = snake.pollLast();
                map[tail[0]][tail[1]] = 0;
            }

            map[nr][nc] = 1;
            snake.addFirst(new int[]{nr, nc});
            head[0] = nr;
            head[1] = nc;

            // 머리 바꾸기
            String dir = direction.get(time);
            if(dir != null) {
                if(dir.equals("D")) d = (d + 1) % 4;
                else d = (d + 3) % 4;
            }

        }

        System.out.println(time);

    }

    private static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

}

/*
    뱀 이동
    1) 머리 다음 칸
    2) 벽 / 자기 몸이면 게임 종료
    3-1) 사과 있으면 사과 없어지고 꼬리 움직임 X
    3-2) 사과 없으면 꼬리 비우기

    몇 초 후에 종료?

    // 0: 빈 칸 1: 뱀 2: 사과
*/