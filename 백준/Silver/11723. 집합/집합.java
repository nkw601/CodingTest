import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		HashSet<Integer> set = new HashSet<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n;
			String cmd = st.nextToken();
		
			switch(cmd) {
				case "add":
					n = Integer.parseInt(st.nextToken());
					set.add(n);
					break;
				case "remove":
					n = Integer.parseInt(st.nextToken());
					set.remove(n);
					break;
				case "check":
					n = Integer.parseInt(st.nextToken());
					if(set.contains(n)) sb.append(1).append('\n');
					else sb.append(0).append('\n');
					break;
				case "toggle":
					n = Integer.parseInt(st.nextToken());
					if(set.contains(n)) set.remove(n);
					else set.add(n);
					break;
				case "all":
					set.clear();
					for(int k = 0; k <= 20; k++) set.add(k);
					break;
				case "empty":
					set.clear();
					break;
				
			}
		}
		System.out.println(sb);
	}

}
