public class LoanCalc {
	
	static double epsilon = 0.001;  
	static int iterationCounter;    
	
    
	public static void main(String[] args) {		
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
				
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}
	
	
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
		iterationCounter = 0;
		double approximateAnnualPayment = loan/n;

		while (endBalance(loan, rate, n, approximateAnnualPayment) > 0) {
			iterationCounter++;
			approximateAnnualPayment += epsilon;
		}

		return approximateAnnualPayment;
    }
    
    
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		iterationCounter = 0;
		double high = loan, low = 0;
    	while (high - low > epsilon) {
			if (endBalance(loan, rate, n, (high + low) / 2) < 0) {
				high = (high + low) / 2;
			}
			else {
				low = (high + low) / 2;
			}
			iterationCounter++;
		}
    	return (high + low) / 2;
    }
	
	private static double endBalance(double loan, double rate, int n, double payment) {
		for (int i = 0; i < n; i++) {
			loan = (loan - payment) * ((100 + rate) / 100);
		}

    	return loan;
	}
}