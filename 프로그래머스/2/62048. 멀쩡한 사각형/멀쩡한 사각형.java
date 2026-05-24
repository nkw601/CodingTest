import java.math.*;

class Solution {
    public long solution(int w, int h) {
        long lw = (long) w;
        long lh = (long) h;
        long gcd = BigInteger.valueOf(lw).gcd(BigInteger.valueOf(lh)).longValue();
        return lw * lh - (lw + lh - gcd);
    }
}