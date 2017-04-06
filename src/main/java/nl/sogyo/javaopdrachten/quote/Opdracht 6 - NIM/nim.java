import java.util.*;

class GameMasterMulti {
int matches = 11;
int remaining = 0;
int currentTurn = 0;
int winner = 0;

public void initiate(){
        int removedMatches = 0;
        currentTurn = (int)(Math.random()*2+1);

        System.out.println("Multiplayer: The game has been set, get ready to play some Nim!\n");

        (this).switchPlayer();

        while(matches > 0) {
                if(matches > 1) {
                        System.out.print("There are "+matches+" matches, how many will you take? ");
                } else if (matches == 1) {
                        System.out.print("There is "+matches+" match, how many will you take? ");
                }
                Scanner input = new Scanner(System.in);
                try{
                        removedMatches = input.nextInt();
                        (this).take(removedMatches);
                } catch (Exception e) {
                        System.out.println("That's not a number, you dummy!\n");
                }
        }
        (this).switchPlayer();
        System.out.println("There are no matches left. The game is over, and player "+winner+" wins!");
}

public void switchPlayer(){
        if(currentTurn == 1 && matches > 0) {
                currentTurn = 2;
                System.out.println("Player 2, you're up!");
        } else if (matches > 0) {
                System.out.println("Player 1, you're up!");
                currentTurn = 1;
        } else if(currentTurn==1 && matches==0) {
                winner = 2;
        } else {
                winner = 1;
        }
}

public int take(int numberRemoved){
        if (numberRemoved > matches && matches != 1) {
                System.out.println("You can't remove that many matches! There are only "+matches+" left!\n");
        } else if (numberRemoved > matches && matches ==1) {
                System.out.println("You can't remove that many matches! There is only one left!\n");
        } else if(numberRemoved>4 || numberRemoved<=0) {
                System.out.println("Nope, you can only remove 1 to 4 matches. Try again!\n");
        } else {
                if(matches != 1) {
                        System.out.println("Player "+currentTurn+" removed "+numberRemoved+" match(es).\n");
                } else {
                        System.out.println("Player "+currentTurn+" removed the last match.\n");
                }
                matches -= numberRemoved;
                (this).switchPlayer();
        }
        return matches;
}
}

class GameMasterSingle extends GameMaster {
int removedMatches = 0;

public void initiate(){
        currentTurn = 1;

        System.out.println("Singleplayer: The game has been set, get ready to play some Nim!\n");

        while(matches > 0) {
                if(matches > 1) {
                        System.out.print("There are "+matches+" matches, how many will you take? ");
                } else if (matches == 1) {
                        System.out.print("There is "+matches+" match, how many will you take? ");
                }
                Scanner input = new Scanner(System.in);
                try{
                        removedMatches = input.nextInt();
                        (this).take(removedMatches);
                } catch (Exception e) {
                        System.out.println("That's not a number, you dummy!\n");
                }
        }
}

public void switchPlayer(){
        int matchesToTake = 0;
        if(currentTurn == 1 && matches > 0) {
                currentTurn = 2;
                if(matches > 6) {
                        matchesToTake = matches - 6;
                } else if (matches == 6) {
                        matchesToTake = 1;
                } else {
                        matchesToTake = matches - 1;
                }
                (this).PCtake(matchesToTake);
        } else if (matches > 0) {
                System.out.println("Player, you're up!");
                currentTurn = 1;
        } else if(currentTurn==1 && matches==0) {
                System.out.println("There are no matches left. The game is over, and the computer wins!"); //adapt
        } else {
                System.out.println("There are no matches left. The game is over, and you win!"); //adapt
        }
}

public void PCtake(int numberRemoved){
        matches -= numberRemoved;
        if(numberRemoved>1) {
                System.out.println("The computer took "+numberRemoved+" matches.\n");
        } else {
                System.out.println("The computer took "+numberRemoved+" match.\n");
        }
        (this).switchPlayer();
}
}

public class nim {
public static void main(String[] args) {
        GameMasterSingle SinglePlayer = new GameMasterSingle();
        GameMasterMulti MultiPlayer = new GameMasterMulti();
        int selection = 0;

        while(selection == 0 || selection > 2) {
                Scanner selector = new Scanner(System.in);
                System.out.println("Before starting, please type 1 for singleplayer, or 2 for multiplayer. Confirm with ENTER.");
                selection = selector.nextInt();
                if(selection == 1) {
                        SinglePlayer.initiate();
                } else if (selection == 2) {
                        MultiPlayer.initiate();
                } else {
                        System.out.println("That's not a number between 1 and 2.\n");
                }
        }
}
}
