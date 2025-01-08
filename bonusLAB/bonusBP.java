import java.io.*;
import java.util.StringTokenizer;

public class bonusBP {
    public static void main(String[] args) {
        int num = in.nextInt();
        System.out.println(recursing(num));
    }
    private static final int MOD = 998244353;
    static int recursing(int a){
        if (a <= 2) {
            return 1;
        }else if (a == 3) return 2;
        int temp = (int) (Math.log(a+1)/Math.log(2));
        int L = ((int) (Math.pow(2, temp - 1) - 1)) + Math.min((int) (Math.pow(2, temp - 1)), a + 1 - ((int) (Math.pow(2, temp))));

        long tempA = (binomialCoefficient(a - 1, L) % MOD);
        long tempB = (tempA * (recursing(L) % MOD)) % MOD;
        long tempC = (tempB * (recursing(a - 1 - L) % MOD)) % MOD;

        long result = tempC % MOD;
        return (int)result;
    }
    public static long binomialCoefficient(int a, int b) {
        if (b > a - b) {
            b = a - b;
        }
        long result = 1;
        for (int i = 1; i <= b; i++) {
            result = (result * (a - (b - i)))%MOD;
            result = (result * modInverse(i,MOD)) % MOD;
        }
        return result;
    }
    public static long modInverse(long a, long mod) {
        return power(a, mod - 2, mod);
    }

    public static long power(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }
    static QReader in = new QReader();
    static class QReader {
        private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer = new StringTokenizer("");

        private String innerNextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String nextLine = innerNextLine();
                if (nextLine == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(nextLine);
            }
            return true;
        }

        public String nextLine() {
            tokenizer = new StringTokenizer("");
            return innerNextLine();
        }

        public String next() {
            hasNext();
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
