import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] students = new boolean[30];
		
		for(int i = 0; i < 28; i++) {
			int n = Integer.parseInt(br.readLine());
			students[n - 1] = true;
		}
		
		for(int i = 0; i < 30; i++) {
			if(students[i] == false) System.out.println(i + 1);
		}
		
	}
}	
