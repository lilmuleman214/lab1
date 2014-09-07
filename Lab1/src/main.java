import java.util.Scanner;
//The following code was written by Christopher Mule

public class main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double workRate, retireRate, income, ssi, payment, presentVal, netIncome, yearsWorking, yearsDrawing;
		
		System.out.print("Thank you for using our program. Lets get started... \n"
				+ "How many years do you plan on working? ");
		yearsWorking = in.nextInt();
		
		System.out.print("What is your expected average return on said investments? ");
		workRate = in.nextDouble();
		
		System.out.print("How long would you like to draw from investments? ");
		yearsDrawing = in.nextInt();
		
		System.out.print("What is your expected monthly return percentage during retirement? ");
		retireRate = in.nextDouble();
		
		System.out.print("What is your required income? ");
		income = in.nextDouble();
		
		System.out.print("Lastly, what is your expected SSI income? ");
		ssi = in.nextDouble();
		
		netIncome = income - ssi;
		presentVal = pv((retireRate/1200.0), yearsDrawing * 12, netIncome, 0, false);
		payment = pmt((workRate/1200), yearsWorking * 12, 0, presentVal, false);
		
		System.out.print("Save Each Month:" + payment + "\nWhat you need saved:" + presentVal);
		
		
	}
	
	/**
    * Present value of an amount given the number of future payments, rate, amount
    * of individual payment, future value and boolean value indicating whether
    * payments are due at the beginning of period
    * (false => payments are due at end of period)
    * @param r
    * @param n
    * @param y
    * @param f
    * @param t
    */
   public static double pv(double r, double n, double y, double f, boolean t) {
       double retval = 0;
       if (r == 0) {
           retval = -1*((n*y)+f);
       }
       else {
           double r1 = r + 1;
           retval =(( ( 1 - Math.pow(r1, n) ) / r ) * (t ? r1 : 1)  * y - f)
                    /
                   Math.pow(r1, n);
       }
       return retval;
   }
   
   public static double pmt(double r, double n, double p, double f, boolean t) {
       double retval = 0;
       if (r == 0) {
           retval = -1*(f+p)/n;
       }
       else {
       double r1 = r + 1;
       retval = ( f + p * Math.pow(r1, n) ) * r
                 /
              ((t ? r1 : 1) * (1 - Math.pow(r1, n)));
       }
       return retval;
   }

}
