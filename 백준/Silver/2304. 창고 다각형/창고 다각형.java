import java.io.*;
import java.util.*;

public class Main {
    static class Pillar {
        int x, h;
        Pillar(int x, int h) { this.x = x; this.h = h; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        Pillar[] arr = new Pillar[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[i] = new Pillar(x, h);
        }

        Arrays.sort(arr, Comparator.comparingInt(p -> p.x));

        int maxH = 0;
        for (Pillar p : arr) maxH = Math.max(maxH, p.h);

        int firstMax = -1, lastMax = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i].h == maxH) {
                if (firstMax == -1) firstMax = i;
                lastMax = i;
            }
        }

        long area = 0;

        int curH = arr[0].h;
        int curX = arr[0].x;
        for (int i = 1; i <= firstMax; i++) {
            if (arr[i].h >= curH) {
                area += (long) curH * (arr[i].x - curX);
                curH = arr[i].h;
                curX = arr[i].x;
            }
        }

        curH = arr[N - 1].h;
        curX = arr[N - 1].x;
        for (int i = N - 2; i >= lastMax; i--) {
            if (arr[i].h >= curH) {
                area += (long) curH * (curX - arr[i].x);
                curH = arr[i].h;
                curX = arr[i].x;
            }
        }

        int width = arr[lastMax].x - arr[firstMax].x + 1;
        area += (long) maxH * width;

        System.out.println(area);
    }
}