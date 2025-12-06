import java.time.LocalDate;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now(ZoneId.of("Asia/Seoul"));
        System.out.println(today);
    }
}