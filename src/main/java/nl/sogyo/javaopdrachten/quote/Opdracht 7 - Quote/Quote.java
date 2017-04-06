import java.util.*;
import java.time.*;
import java.text.*;

class Formatting {

public String formatQuote(String input){
        String rest = input.substring(1,input.length());
        String capital = input.substring(0,1);
        capital = capital.toUpperCase();
        capital += rest;
        return capital;                                     //Returns the quote with a capital at the beginning.
}

public String formatName(String input){
        String name = input.trim();                                     //Trims off any unnecessary spaces.
        char[] namechar = new char[100];                                //New char array, shouldn't need more than 100 characters.
        namechar = name.toCharArray();                                  //Place string into char array.
        namechar[0] = Character.toUpperCase(namechar[0]);               //First letter is to be capitalized (it's a name after all). Because it's trimmed, the first char will always be a letter.
        for(int i=0; i<namechar.length; i++) {                          //Find a space or a dash between names.
                if(namechar[i]==' '||namechar[i]=='-') {
                        namechar[i+1] = Character.toUpperCase(namechar[i+1]);     //Capitalize the letter after the space.
                }
        }
        String formattedName = String.copyValueOf(namechar);            //Convert the char array back to String.
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

        if (DayNo > quotes.length) {
                while(DayNo> quotes.length) {
                        DayNo -= quotes.length;
                }
        }

        String quoteCurrent = quotes[DayNo-1][1];
        String nameCurrent = quotes[DayNo-1][0];

        String quoteFormatted = formatter.formatQuote(quoteCurrent);
        String nameFormatted = formatter.formatName(nameCurrent);

        System.out.println("\""+quoteFormatted+".\" --- "+nameFormatted);

}

}
