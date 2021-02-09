package powerJava;
import java.util.Scanner;

class DiceGame {
    int diceFace;
    int userGuess;

    private void RollDice(){
        diceFace = (int)(Math.random()*6) + 1;

    }

    private int getUserInput(String prompt){
        System.out.println(prompt);
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }
    private void checkUserGuess(){
        if(diceFace == userGuess){
            System.out.println("맞았습니다");
        }else{
            System.out.println("틀렸음");
        }
    }

    public void startPlaying() {
    	userGuess = this.getUserInput("예상값을 입력하시오: ");
    	this.RollDice();
    	this.checkUserGuess();
    }
    
}


public class DiceGameTest{
    public static void main(String [] args){
        DiceGame game = new DiceGame();
        game.startPlaying();

    }
}
