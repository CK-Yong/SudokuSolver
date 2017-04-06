import java.util.*;
import java.time.*;
import java.text.*;

class Formatting {

public String formatQuote(String input){
        String rest = input.substring(1,input.length());
        String capital = input.substring(0,1);
        capital = capital.toUpperCase();
        capital += rest;
        return capital;
}

public String formatName(String input){
        String name = input;
        for(int i=0; i<name.length(); i++) {
                //need to get name in capitals.
        }
        System.out.println(name);
        String formattedName = name;
        return formattedName;
}

}

public class Quote {
public static void main(String[] args) {
        String[][] quotes = {
                {"galileo", "eppur si muove"},
                {"archimedes", "eureka!"},
                {"erasmus", "in regione caecorum rex est luscus"},
                {"socrates", "I know nothing except the fact of my ignorance"},
                {"rené descartes", "cogito, ergo sum"},
                {"sir isaac newton", "if I have seen further it is by standing on the shoulders of giants"}
        };
        Date date = new Date(); // Initiates new Date
        MonthDay monthday = MonthDay.now();   //Gets current day of month
        int DayNo = monthday.getDayOfMonth();
        DateFormat formatday = new SimpleDateFormat("EEEEE");  //Formats the day from current date in full.
        String day = formatday.format(date);
        DateFormat formatmonth = new SimpleDateFormat("MMMMM"); //Formats the current month in full.
        String month = formatmonth.format(date);
        Formatting formatter = new Formatting();

        if (DayNo>3) {
                System.out.println("Quote for "+day+" the "+DayNo+"th of "+month+":");
        } else if (DayNo==2) {
                System.out.println("Quote for "+day+" the "+DayNo+"nd of "+month+":");
        } else if (DayNo==1) {
                System.out.println("Quote for "+day+" the "+DayNo+"st of "+month+":");
        }

        String quoteCurrent = quotes[DayNo][1];
        String nameCurrent = quotes[DayNo][0];

        String quoteFormatted = formatter.formatQuote(quoteCurrent);
        String nameFormatted = formatter.formatName(nameCurrent);

        System.out.println("\""+quoteFormatted+".\" --- "+nameFormatted);

}

}
