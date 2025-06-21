import java.util.HashMap;

public class FinancialForecasting {


    public static void explainRecursion() {
        System.out.println("=== Understanding Recursion ===");
        System.out.println("- Recursion is when a method calls itself to solve smaller instances of a problem.");
        System.out.println("- It simplifies problems like calculating future values, factorials, Fibonacci, etc.");
        System.out.println("- Requires a base case to stop the recursive calls.\n");
    }


    public static double futureValueRecursive(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return (1 + rate) * futureValueRecursive(presentValue, rate, years - 1);
    }


    public static double futureValueMemoized(double presentValue, double rate, int years, HashMap<Integer, Double> memo) {
        if (years == 0) {
            return presentValue;
        }
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
        double result = (1 + rate) * futureValueMemoized(presentValue, rate, years - 1, memo);
        memo.put(years, result);
        return result;
    }


    public static void analyzeComplexity() {
        System.out.println("\n=== Time Complexity Analysis ===");
        System.out.println("- Naive recursive version: O(n) since it makes 'n' recursive calls.");
        System.out.println("- Optimized (memoized) version: Also O(n), but avoids redundant work by caching.");
        System.out.println("- Iterative or closed-form solutions can achieve O(1) using Math.pow().");
    }


    public static void main(String[] args) {
        explainRecursion();

        double presentValue = 1000.0;
        double rate = 0.10;
        int years = 5;

        System.out.println("=== Recursive Forecast ===");
        double fvRecursive = futureValueRecursive(presentValue, rate, years);
        System.out.printf("Future Value after %d years: %.2f\n", years, fvRecursive);

        System.out.println("\n=== Memoized Forecast ===");
        double fvMemoized = futureValueMemoized(presentValue, rate, years, new HashMap<>());
        System.out.printf("Future Value after %d years (memoized): %.2f\n", years, fvMemoized);

        analyzeComplexity();
    }
}
