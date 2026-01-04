import java.io.*;
import java.util.*;

public class Main {

    static class Team {
        int id;
        int total;
        int submitCnt;
        int lastTime;

        Team(int id, int total, int submitCnt, int lastTime) {
            this.id = id;
            this.total = total;
            this.submitCnt = submitCnt;
            this.lastTime = lastTime;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀 수
            int k = Integer.parseInt(st.nextToken()); // 문제 수
            int myId = Integer.parseInt(st.nextToken()); // 내 팀
            int m = Integer.parseInt(st.nextToken()); // 로그 수

            int[][] best = new int[n + 1][k + 1];
            int[] submitCnt = new int[n + 1];
            int[] lastTime = new int[n + 1];

            for (int t = 1; t <= m; t++) {
                st = new StringTokenizer(br.readLine());
                int team = Integer.parseInt(st.nextToken());
                int prob = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                submitCnt[team]++;
                lastTime[team] = t;

                if (score > best[team][prob]) best[team][prob] = score;
            }

            List<Team> teams = new ArrayList<>(n);
            for (int id = 1; id <= n; id++) {
                int total = 0;
                for (int prob = 1; prob <= k; prob++) total += best[id][prob];
                teams.add(new Team(id, total, submitCnt[id], lastTime[id]));
            }

            teams.sort((a, b) -> {
                if (a.total != b.total) return b.total - a.total;                 // 총점 내림
                if (a.submitCnt != b.submitCnt) return a.submitCnt - b.submitCnt; // 제출수 오름
                return a.lastTime - b.lastTime;                                   // 마지막 제출 오름
            });

            int rank = 1;
            for (Team team : teams) {
                if (team.id == myId) break;
                rank++;
            }

            out.append(rank).append('\n');
        }

        System.out.print(out.toString());
    }
}