import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();

        int[] lps = makeLps(P);

        int i = 0, j = 0;

        while (i < S.length()) {
            if (S.charAt(i) == P.charAt(j)) {
                i++;
                j++;
                if (j == P.length()) {
                    System.out.println(1);
                    return;
                }
            } else {
                if (j > 0) j = lps[j - 1];
                else i++;
            }
        }

        System.out.println(0);
    }

    private static int[] makeLps(String p) {
        int[] lps = new int[p.length()];
        int j = 0;

        for (int i = 1; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = lps[j - 1];
            }

            if (p.charAt(i) == p.charAt(j)) {
                lps[i] = ++j;
            }
        }

        return lps;
    }
}