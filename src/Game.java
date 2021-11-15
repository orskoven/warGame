import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Game {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static ArrayList <Cards> playerOneDeck = new ArrayList<>();
    static ArrayList <Cards> playerTwoDeck = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println("Hey waddup let's play a game of war!\nPlayer One type your name, please: ");
        String namePlayerOne = scanner.nextLine();
        playerOneDeck = Cards.createStackOne();
        for (int i = 0; i < playerOneDeck.size(); i++) {
            Collections.swap(playerOneDeck,randomizer(),i);
        }


        System.out.println("Player One type your name, please:");
        String namePlayerTwo = scanner.nextLine();
        playerTwoDeck = Cards.createStackTwo();
        for (int i = 0; i < playerTwoDeck.size(); i++) {
            Collections.swap(playerTwoDeck,randomizer(),i);
        }
        System.out.println("The game begins!");
        Cards playerOneTopCard = playerOneDeck.get(0);
        Cards playerTwoTopCard = playerTwoDeck.get(0);

        System.out.println("Play One's top card is: " + playerOneTopCard);
        System.out.println("VS");
        System.out.println("Play Two's top card is: " + playerTwoTopCard);
        int comparable = playerOneTopCard.compareTo(playerTwoTopCard);

        System.out.println("The winner is: " + determineWinner(playerOneTopCard,playerTwoTopCard,comparable));
    }
    static int randomizer(){
        return random.nextInt(56);
    }
    static String determineWinner(Cards playOneTopCard, Cards playerTwoTopCard, int comparable){
        if (comparable == -1){
            return "Player One!";
        } if (comparable == 1) {
            return "Player Two!";
        } else {
            return "It's a draw";
        }
    }
}
