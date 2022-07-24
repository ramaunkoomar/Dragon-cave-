import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
  private ByteArrayInputStream iStream;
  private ByteArrayOutputStream oStream;
  private PrintStream pStream;
  private Main DragonCaveGameTest;

  @BeforeEach
  public void setupTest () {
    this.oStream = new ByteArrayOutputStream();
    this.pStream = new PrintStream(oStream);
  }

  @Test
  public void choiceOneOrTwoTest1 () {
    this.DragonCaveGameTest = new Main(System.in, System.out);
    String expected = "You approach the cave...\nIt's quiet, dark, and spooky...\nA large dragon jumps out in front of you!\nHe opens his jaws and... gobbles you down in one bite!";
    String actual = this.DragonCaveGameTest.choiceOneOrTwo(1);
    assertEquals(expected, actual);
  }

  @Test
  public void choiceOneOrTwoTest2 () {
    this.DragonCaveGameTest = new Main(System.in, System.out);
    String expected = "You approach the cave...\nIt's quiet, dark, and spooky...\nA large dragon jumps out in front of you!\nHe opens his jaws and... gobbles you down in one bite!";
    String actual = this.DragonCaveGameTest.choiceOneOrTwo(1);
    assertEquals(expected, actual);
  }
  
  @Test
  public void mainTestWithChoice1 () {
    this.iStream = new ByteArrayInputStream("1\n".getBytes());
    this.DragonCaveGameTest = new Main(this.iStream, this.pStream);
    this.DragonCaveGameTest.initGame();
    String intro = "You are in a land full of dragons.\nIn front of you, you see too caves.\nIn one cave, the dragon is friendly and will share his treasure with you.\nThe other dragon is greedy and hungry, and will eat you on sight.\n";
    String prompt = "Which cave will you go into? (1 or 2)\n";
    String choiceResult = "You approach the cave...\nIt's quiet, dark, and spooky...\nA large dragon jumps out in front of you!\nHe opens his jaws and... gobbles you down in one bite!\n";
    String expected = intro + prompt + choiceResult;
    String actual = this.oStream.toString();
    assertEquals(expected, actual);
  };

  @Test
  public void mainTestWithChoice2 () {
    this.iStream = new ByteArrayInputStream("2\n".getBytes());
    this.DragonCaveGameTest = new Main(this.iStream, this.pStream);
    this.DragonCaveGameTest.initGame();
    String intro = "You are in a land full of dragons.\nIn front of you, you see too caves.\nIn one cave, the dragon is friendly and will share his treasure with you.\nThe other dragon is greedy and hungry, and will eat you on sight.\n";
    String prompt = "Which cave will you go into? (1 or 2)\n";
    String choiceResult = "You approach the cave...\nYou see colored lights, hear music, and feel thumps on the ground...\nA large dragon jumps out in front of you!\nHe opens his jaws and... invites you inside to dance!\n";
    String expected = intro + prompt + choiceResult;
    String actual = this.oStream.toString();
    assertEquals(expected, actual);
  };

  @Test
  public void mainTestWithChoice3 () {
    this.iStream = new ByteArrayInputStream("3\n".getBytes());
    this.DragonCaveGameTest = new Main(this.iStream, this.pStream);
    this.DragonCaveGameTest.setEndFlag();
    this.DragonCaveGameTest.initGame();
    String intro = "You are in a land full of dragons.\nIn front of you, you see too caves.\nIn one cave, the dragon is friendly and will share his treasure with you.\nThe other dragon is greedy and hungry, and will eat you on sight.\n";
    String prompt = "Which cave will you go into? (1 or 2)\n";
    String choiceResult = "You're looking for a different path, I see...\nRemember, your only choices are 1 or 2.\n";
    String expected = intro + prompt + choiceResult;
    String actual = this.oStream.toString();
    assertEquals(expected, actual);
  }

  @Test
  public void mainTestWithException () {
    this.iStream = new ByteArrayInputStream("38fsdfsdf89\n".getBytes());
    this.DragonCaveGameTest = new Main(this.iStream, this.pStream);
    this.DragonCaveGameTest.setEndFlag();
    this.DragonCaveGameTest.initGame();
    String intro = "You are in a land full of dragons.\nIn front of you, you see too caves.\nIn one cave, the dragon is friendly and will share his treasure with you.\nThe other dragon is greedy and hungry, and will eat you on sight.\n";
    String prompt = "Which cave will you go into? (1 or 2)\n";
    String excepResult = "Try again! You may only enter integers.\nRemember, your only choices are 1 or 2.\n";
    String expected = intro + prompt + excepResult;
    String actual = this.oStream.toString();
    assertEquals(expected, actual);
  }

  @AfterEach
  public void tearDownTest () {
    this.iStream = null;
    this.oStream = null;
    this.pStream = null;
    this.DragonCaveGameTest = null;
  };
};
