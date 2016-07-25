public class A {

	static void runTimeDuration() {
		for (int n = 100; n < 1000 * 500; n *= 2) {
			long startTime = System.currentTimeMillis();
			long result = executeAlgorithm(n);
			long endTime = System.currentTimeMillis();
			System.out.println(
					"n: " + n + " Result: " + result + " Total execution time: " + (endTime - startTime) + "ms");
		}
	}

	public static long executeAlgorithm(int n) {
		long sum = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = n + i + j - 3; k < n; k++) {
					sum++;
				}
				sum++;
			}
		}
		return sum;
	}

	public static void timeComplexity() {
		for (int i = 1; i < 1000 * 10; i*=3) {
			long sum = executeAlgorithm(i);
			System.out.println("N " + i + " iterations " + sum / i);

		}
	}

	public static void main(String[] args) {
		timeComplexity();
		runTimeDuration();
	}

}
