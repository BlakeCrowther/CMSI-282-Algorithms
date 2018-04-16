  public class PracticeProblems {

    public static long gcd (long x, long y) {
        if(y==0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public static long lcm (long x, long y) {
        return (x * y) / gcd(x, y);
    }

    public static long computePower (long x, long y) {
        if(y == 0) {
            return 1;
        } else if(y % 2 == 0) {
            return computePower(x, y / 2) * computePower(x, y / 2);
        } else {
            return x * computePower(x, y / 2) * computePower(x, y / 2);
        }
    }

    public static long hornersRule (long coefficients[], int length, int x) {
        long result = coefficients[0];
        for(int i = 1; i < length; i++) {
            result = result * x + coefficients[i];
        }
        return result;
    }

  public static void main (String[] args) {
      long[] coefficients = {2, -6, 2, -1};
      int x = 3;
      int length = coefficients.length;
      System.out.println(hornersRule(coefficients, length, x));
  }

}
