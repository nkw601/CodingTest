import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	static int totalE, N;
	static Atom[] atoms;
//	static int[] dx = {0, 0, -1, 1}; // dx
//	static int[] dy = {1, -1, 0, 0}; // dy
	static int[] dx = {1, -1, 0, 0}; // dx
	static int[] dy = {0, 0, -1, 1}; // dy
	
	private static class Atom{
		int x, y, d, energy;
		boolean isAlive;

		public Atom(int x, int y, int d, int energy) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.energy = energy;
			this.isAlive = true;
		}

		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++){
			N = Integer.parseInt(br.readLine());
			
			// 초기화
			totalE = 0;
			
			atoms = new Atom[N];

			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				// x, y -> c, r
				int x = Integer.parseInt(st.nextToken()) * 2; // 0.5초 처리
				int y = Integer.parseInt(st.nextToken()) * 2;
				int d = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				
				atoms[i] = new Atom(y, x, d, k);
			}
			
			for (int i = 0; i <= 4000 && N > 0; i++) checkCrash();

			
			sb.append('#').append(tc).append(' ').append(totalE).append('\n');
		}
		System.out.println(sb);
	}
	private static void checkCrash() {
		// 1. 이동하고
		HashMap<Long, Integer> overlap = new HashMap<>(N * 2);
		for(int i = 0; i < N; i++) {
			Atom a = atoms[i];
			if(!a.isAlive) continue; // 죽었으면 처리 안하기
			
			int nx = a.x + dx[a.d];
			int ny = a.y + dy[a.d];
			
			if(nx < -2000 || nx > 2000 || ny < -2000 || ny > 2000) {
				a.isAlive = false;
				continue;
			}
			
			a.x = nx;
			a.y = ny;
			long k = key(nx, ny);
			
			overlap.put(k, overlap.getOrDefault(k, 0) + 1);
		}
		// 2. 겹치는 부분 처리
		ArrayList<Atom> next = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
	        Atom a = atoms[i];
	        if (!a.isAlive) continue;

			long key = key(a.x, a.y);
	        int cnt = overlap.get(key);
	        // cnt가 2보다 크면 터지기
	        if (cnt >= 2) {
	            totalE += a.energy;
	            a.isAlive = false;
	        } else {
	            next.add(a);
	        }
	    }
		// 3. 다음으로
		atoms = next.toArray(new Atom[next.size()]);
	    N = atoms.length;
	}
	private static long key(int x, int y) {
	    return (((long) x) << 32) ^ (y & 0xffffffffL);
	}

}

/*
 * 입력
 * T
 * N
 * N: x, y, d, K
 * (0, 1, 2, 3: 상하좌우)
 * 출력
 * 원자들이 소멸되면서 방출하는 에너지의 총합
 * 
 * 이해
 * 상하좌우 속도 1
 * 두 개 이상의 원자가 동시에 충돌할 경우 보유한 에너지 방출하고 소멸
 * 
 * 생각
 * 이름부터 시뮬레이션이다
 * xy 첨부터 배열로 생각하고 하자 헷갈리지 말자
 * 
 * 충돌 가능성
 * 1. 같은 행 반대방향 주행: 정면으로 쾅
 * 2. 같은 열 반대방향 주행: 정면으로 쾅
 * 3. 직각 주행: (r1, c1), r1++ (r2, c2) c2++, t초 후 같으면 쾅
 * 			-> x2 + dx*t = x1 && y1 + dy*t = y2
 * 
 * 아 부딪히는 시간을 관리해야하는구나
 * -> 계산한 결과를 모두 pq에 넣고, 하나씩 꺼내면서 생존 여부 확인 후 충돌처리
 * 아
 * 아 
 * 아
 * 안 녕 . . .
 * 
 */

