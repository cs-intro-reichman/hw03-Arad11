public class Calendar {	
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     
	static int nDaysInMonth = 31; 
	
	public static void main(String args[]) {
		int askedYear = Integer.parseInt(args[0]);

	 	while ((year <= 1999)) {
            if (year == askedYear) {
                if (dayOfWeek % 7 == 0) {
                    System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
                }
                else {
                    System.out.println(dayOfMonth + "/" + month + "/" + year);
                }
            }

            advance();
        }
	 }
	
	 private static void advance() {
		int nDaysInMonth = nDaysInMonth(month, year);
		if (dayOfMonth < nDaysInMonth) {
			dayOfMonth++;
		}
		else if (nDaysInMonth == dayOfMonth) {
			dayOfMonth = 1;
			if (month < 12) {
				month++;
			}
			else if (month == 12) {
				month = 1;
				year++;
			}
			
		}

		dayOfWeek++;
	} 
		 
	private static boolean isLeapYear(int year) {
		return year % 4 == 0 ? true : false;

	}
	 
	private static int nDaysInMonth(int month, int year) {
		if (month == 2) {
			return isLeapYear(year) ? 29 : 28;
		}
		else if (month < 8) {
			return month % 2 == 1 ? 31 : 30;
		}
		else if (month >= 8) {
			return month % 2 == 1 ? 30 : 31;
		}
		return 0;
	}
}
