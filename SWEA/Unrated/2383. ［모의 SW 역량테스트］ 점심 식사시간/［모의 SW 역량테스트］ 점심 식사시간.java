import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	static class Person implements Comparable<Person>{
		int r, c, arrivalTime; // 행, 열,계단 입구 도착 시간

		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.arrivalTime, o.arrivalTime);
		}
		
	}
	private static int N, min, cnt; //맵의 크기, 최소 이동 시간, 사람 수
	private static int[][] sList; // 계단 리스트(계단: r, c, height) // 계단0, 계단1
	private static ArrayList<Person> pList; // 사람 리스트
	private static int[] selected; // 사람마다 어떤 계단에 배정되었는지
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			pList = new ArrayList<>();
			sList = new int[2][];
			min = Integer.MAX_VALUE;
			for(int i = 0, k = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					int c = Integer.parseInt(st.nextToken());
					if(c==1) pList.add(new Person(i, j)); // 사람
					else if(c > 1) sList[k++] = new int[] {i, j, c};
				}
			}
			cnt = pList.size();
			selected = new int[cnt];
			
			 divide(0);
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void divide(int idx) {// idx에 해당하는 사람의 계단 배정
		if(idx == cnt) {
			makeList();
			return;
		}
		
		selected[idx] = 0;
		divide(idx+1);
		selected[idx] = 1;
		divide(idx+1);
	}

	private static void makeList() { // 계단 배정에 따른 사람들 리스트에 배치
		ArrayList<Person>[] list = new ArrayList[] {new ArrayList<Person>(), new ArrayList<Person>()};
		
		for(int i = 0; i < cnt; i++) {
			Person p = pList.get(i);
			int no = selected[i];
			
			p.arrivalTime = Math.abs(p.r - sList[no][0]) + Math.abs(p.c - sList[no][1]);
			list[no].add(p);
		}
		
		// 각각 계단의 사람리스트를 이용해 내려가기 구현
		int timeA = processDown(list[0], sList[0][2]); // 0번 계단의 높이
		int timeB = processDown(list[1], sList[1][2]); // 1번 계단의 높이
		int res = Math.max(timeA, timeB); // 두 계단을 모두 내려가는데 소요되는 시간
		
		min = Math.min(min, res);
	}
	
	private static int processDown(ArrayList<Person> list, int height) {
		if(list.size() == 0) return 0;
		Collections.sort(list); // 계단 오름차순 기준 오름차순 정렬
		int size = list.size() + 3; // padding: 3
		int[] D = new int[size]; // 3인덱스: 계단 입구에 가장 빨리 도착한 사람을 의미, 4인덱스: 그 다음도착 ...
		
		for(int i = 3; i < size; i++) {
			Person p = list.get(i - 3);
			if(D[i-3] <= p.arrivalTime + 1) D[i] = p.arrivalTime + 1 + height;
			else D[i] = D[i - 3] + height;
		} 
		
		
		return D[size - 1];
	}
}
