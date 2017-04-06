import java.util.Scanner;

class Processor {
public boolean check(int input, int answer){
        if(input > answer) {
                System.out.println("Try lower");
                return false;
        } else if (input < answer) {
                System.out.println("Try higher");
                return false;
        } else if (input == answer) {
                System.out.println("Congratulations, you are correct! Restarting game now.\n");
                return true;
        }
        return false;
}
}

public class HigherLower {
public static void main(String[] args){
        while(true) { //Saves the hassle of restarting the game manually.
                Processor game = new Processor();
                int answer = (int)(Math.random() * 50 + 1);
                boolean GameOver = false;
                System.out.println("Guess a number between 1 and 50. You've got 10 tries until the game is over.");
                System.out.print("Your guess: ");
                for(int i=0; i<=11; i++) {
                        if(i==11) {
                                System.out.println("You've had your 10 tries. I'm ending the game. Restarting the game for you.\n");
                                break;
                        }
                        Scanner scanner = new Scanner(System.in);
                        int n = scanner.nextInt();
                        GameOver = game.check(n,answer);
                        if(GameOver == true) {
                                break; //if a number is found, end the game, and restart.
                        }
                }
        }
}
}
