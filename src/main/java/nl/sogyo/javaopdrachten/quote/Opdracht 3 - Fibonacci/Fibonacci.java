import java.util.Scanner;

class Fcounter {
public long count(long n){
        long f1 = 0;
        long f2 = 1;
        long answer = 0;
        if(n==0) {
                return 0; //the first to third terms seem to be exceptions, so this returns the correct results.
        } else if (n==1||n==2) {
                return 1;
        }
        for(long i=0; i<n-1; i++) { //keeps finding the next fibonacci value until the right answer is found.
                answer = f1 + f2;
                f1 = f2;
                f2 = answer;
        }
        return answer;
}
}

public class Fibonacci {
public static void main(String[] args){
        Fcounter counter = new Fcounter();
        while(true) {
                Scanner input = new Scanner(System.in);
                System.out.println("Please input your number, and I will calculate its corresponding Fibonacci number.");
                System.out.print("Your number: ");
                long n = input.nextLong();
                long answer = counter.count(n-1);
                System.out.println("The value of the "+n+"th term of the Fibonacci sequence is "+answer+"\n");
        }
}
}
