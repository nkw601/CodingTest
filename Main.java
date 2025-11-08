import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger n = sc.nextBigInteger(); // 총 금액
        BigInteger m = sc.nextBigInteger(); // 사람 수

        System.out.println(n.divide(m));     // 각자 받는 돈
        System.out.println(n.remainder(m));  // 남는 돈
    }
}