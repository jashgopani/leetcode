import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger b1 = new BigInteger(a,2);
        BigInteger b2 = new BigInteger(b,2);
        BigInteger b3 = b1.add(b2);
        return b3.toString(2);
    }
}