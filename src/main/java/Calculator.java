public class Calculator {

    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is only defined for non-negative integers.");
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public int binomialCoefficient(int n, int k) {
        if (n < 0 || k < 0) {
            throw new IllegalArgumentException("n and k must be non-negative.");
        }
        if (k > n) {
            throw new IllegalArgumentException("Subset size cannot exceed the set size.");
        }
        return factorial(n) / (factorial(k) * factorial(n - k));
    }
}
