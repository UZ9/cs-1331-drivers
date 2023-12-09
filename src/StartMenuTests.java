import java.io.File;

import com.cs1331.drivers.annotations.AfterTest;
import com.cs1331.drivers.annotations.InjectData;
import com.cs1331.drivers.annotations.TestCase;
import com.cs1331.drivers.annotations.Tip;
import com.cs1331.drivers.exception.TestFailedException;
import com.cs1331.drivers.javafx.RecursiveSearch;
import com.cs1331.drivers.testing.TestFunction;
import com.cs1331.drivers.testing.TestManager;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartMenuTests {
    @TestCase(name = "valid title property")
    @Tip(description = "Make sure you're setting your stage title correctly!")
    public void checkApplicationTitle() throws TestFailedException {
        TestFunction.assertEqual(StageData.stage.getTitle(), "Battleship");
    }

    @TestCase(name = "battleshipImage.jpg exists")
    @Tip(description = "Make sure you have battleshipImage.jpg (NOT png) in the same directory as your files!")
    public void checkBattleshipImage() throws TestFailedException {
        File file = new File("battleshipImage.jpg");

        TestFunction.assertEqual(file.exists(), true);
    }
    
    @TestCase(name = "enemy.txt exists")
    @Tip(description = "Make sure you have enemy.txt in the same directory as your files!")
    public void checkEnemyTxt() throws TestFailedException {
        File file = new File("enemy.txt");

        TestFunction.assertEqual(file.exists(), true);
    }

    
    @TestCase(name = "player.txt exists")
    @Tip(description = "Make sure you have player.txt in the same directory as your files!")
    public void checkPlayerTxt() throws TestFailedException {
        File file = new File("player.txt");

        TestFunction.assertEqual(file.exists(), true);
    }

    @TestCase(name = "Start menu contains a button with text \"Start Game!\"")
    @Tip(description = "Make sure your button formatting is correct!")
    public void checkForButton() throws TestFailedException {
        Scene scene = StageData.stage.getScene();

        Button returned = RecursiveSearch.recursiveSearch(
                ((Button b) -> b.getText().equals("Start Game!")),
                Button.class,
                (Pane) scene.getRoot());

        TestFunction.assertEqual(true, returned != null);
    }


    @TestCase(name = "Start menu contains a label somewhere with \"Battleship\"")
    @Tip(description = "Make sure your button formatting is correct!")
    public void checkForBattleshipLabel() throws TestFailedException {
        Scene scene = StageData.stage.getScene();

        Label returned = RecursiveSearch.recursiveSearch(
                ((Label b) -> b.getText().equals("Battleship")),
                Label.class,
                (Pane) scene.getRoot());

        TestFunction.assertEqual(true, returned != null);
    }

    @AfterTest
    public void afterTest() {
        Scene scene = StageData.stage.getScene();

        Button returned = RecursiveSearch.recursiveSearch(
                ((Button b) -> b.getText().equals("Start Game!")),
                Button.class,
                (Pane) scene.getRoot());

        if (returned != null) {
            Platform.runLater(() -> { returned.fire(); System.out.println("set scene"); StageData.currentScene = returned.getScene(); 
            TestManager.executeNextTest(StageData.stage);
        }  );
        }
    }
}