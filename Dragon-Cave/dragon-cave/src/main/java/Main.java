import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
  private Scanner iStream;
  private PrintStream pStream;
  private int choice;
  private boolean endFlag;

  public Main (InputStream iStream, PrintStream pStream) {
    this.iStream = new Scanner(iStream);
    this.pStream = pStream;
  }

  public int getChoice () {
    return this.choice;
  };
  public int setChoice (int choice) {
    this.choice = choice;
    return this.getChoice();
  };

  public boolean getEndFlag () {
    return this.endFlag;
  };
  public boolean setEndFlag () {
    this.endFlag = true;
    return this.getEndFlag();
  };

  public String choiceOneOrTwo (int choice) {
    String statement;
    if (choice == 1 || choice == 2) {
      if (choice == 1) {
        statement = "You approach the cave...\nIt's quiet, dark, and spooky...\nA large dragon jumps out in front of you!\nHe opens his jaws and... gobbles you down in one bite!";
      } else {
        statement = "You approach the cave...\nYou see colored lights, hear music, and feel thumps on the ground...\nA large dragon jumps out in front of you!\nHe opens his jaws and... invites you inside to dance!";
      }
      this.setEndFlag();
    } else {
      statement = "You're looking for a different path, I see...\nRemember, your only choices are 1 or 2.";
    }
    this.pStream.println(statement);
    return statement;
  };

  public void initGame () {
    String excepStatement;
    this.pStream.println("You are in a land full of dragons.\nIn front of you, you see too caves.\nIn one cave, the dragon is friendly and will share his treasure with you.\nThe other dragon is greedy and hungry, and will eat you on sight.");
    do {
      try {
        this.pStream.println("Which cave will you go into? (1 or 2)");
        int choice = this.iStream.nextInt();
        this.choiceOneOrTwo(this.setChoice(choice));
      } catch (InputMismatchException e) {
        this.iStream.nextLine();
        this.pStream.println("Try again! You may only enter integers.\nRemember, your only choices are 1 or 2.");
      }
    } while (!this.getEndFlag());
    iStream.close();
  };

  public static void main(String[] args) {
    Main DragonCaveGame = new Main(System.in, System.out);
    DragonCaveGame.initGame();
  };
};
