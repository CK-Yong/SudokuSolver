import java.util.Scanner;

class PrimeCalc {
public void nthPrime(long n){
        int counter = 0;
        int i = 0;
        while(counter < n) { //count primes up to the nth term.
                if(isPrime(i)) {
                        counter++;
                }
                i++;    //Considers all numbers, if a prime is found, counter increases by 1, and the next number is considered. Otherwise, only i is increased.
        }
        int primeNumber = i-1;
        System.out.println("Value of "+ n+"th prime number:"+primeNumber+"\n");
}

public boolean isPrime(long input){     //Checks whether an input is prime.
        if(input < 2) { //0 and 1 are considered exceptions to prime numbers.
                return false;
        }
        if(input == 2) { //2 is a prime number, but dividing by 2 should return false, so this is an exception.
                return true;
        }
        double x = Math.sqrt(input); //Only consider values up to the square root of the input.
        for(int i=2; i<x+1; i++) {
                if(input%i==0) {
                        return false; //if a single divisor is found, return false.
                }
        }
        return true;  //If everything passed, return true, because it's a prime ;).
}
}

public class PrimeCheck {
public static void main(String[] args){
        PrimeCalc prime = new PrimeCalc();

        while(true) {
                Scanner s = new Scanner(System.in);
                System.out.println("Please input a number, and I will calculate the nth prime number. Try 10001 maybe? ;)");
                try{
                        long input = s.nextInt();
                        prime.nthPrime(input);
                } catch (Exception e) {
                        System.out.println("Sorry, that is not a number. Try again!\n");
                        continue;
                }
        }
}
}
