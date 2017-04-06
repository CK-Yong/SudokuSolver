import java.util.Scanner;

class LeapYear {
public void checkLeapYear() {
        int InputYear;
        InputYear = 0;
        Scanner in = new Scanner(System.in);
        while(true) {
                if(InputYear == 0) { //Displays another text depending on whether the year has been changed from zero.
                        System.out.println("Please input a year.");
                } else {
                        System.out.println("Input another year or close to quit.");
                }
                try { InputYear = in.nextInt();} catch (Exception e) {
                        System.out.println("Error. Invalid input, please try again.\n");
                        return;
                }

                if(InputYear % 4 == 0 || InputYear % 400 == 0) {
                        System.out.println("Year is a leap year.\n");
                } else {
                        System.out.println("Year is not a leap year.\n");
                }
        }
}
}

public class LeapYearLauncher {
public static void main(String[] args){
        LeapYear leap = new LeapYear();
        while(true) {
                leap.checkLeapYear();
        }
}
}
