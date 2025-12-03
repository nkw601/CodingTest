import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double ectSum = 0;
        double sumSco = 0;
        for(int i = 0; i < 20; i++){
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            double ect = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if(grade.equals("A+")) {
                sumSco += 4.5 * ect;
                ectSum += ect;
            } else if(grade.equals("A0")){
                sumSco += 4.0 * ect;
                ectSum += ect;
            } else if(grade.equals("B+")) {
                sumSco += 3.5 * ect;
                ectSum += ect;

            } else if(grade.equals("B0")) {
                sumSco += 3.0 * ect;
                ectSum += ect;
            } else if(grade.equals("C+")) {
                sumSco += 2.5 * ect;
                ectSum += ect;
            } else if(grade.equals("C0")) {
                sumSco += 2.0 * ect;
                ectSum += ect;
            } else if(grade.equals("D+")) {
                sumSco += 1.5 * ect;
                ectSum += ect;
            } else if(grade.equals("D0")) {
                sumSco += 1.0 * ect;
                ectSum += ect;
            } else if(grade.equals("F")){
                ectSum += ect;
            }
        }

        System.out.println(sumSco / ectSum);
    }
}