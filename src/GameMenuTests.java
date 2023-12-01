import com.cs1331.drivers.annotations.TestCase;
import com.cs1331.drivers.annotations.Tip;
import com.cs1331.drivers.exception.TestFailedException;
import com.cs1331.drivers.javafx.RecursiveSearch;
import com.cs1331.drivers.testing.TestFunction;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class GameMenuTests {
    @TestCase(name = "Check guess button is enabled")
    @Tip(description = "Make sure your guess button is enabled!")
    public void checkGuessButtonCanFire() throws TestFailedException {
        Scene scene = StageData.stage.getScene();

        Button returned = RecursiveSearch.recursiveSearch(
                ((Button b) -> b.getText().contains("GUESS")),
                Button.class,
                (Pane) scene.getRoot());

        TestFunction.assertEqual(returned.isDisabled(), false);
    }

    @TestCase(name = "Game menu window name is still Battleship")
    @Tip(description = "Don't change the title!")
    public void checkApplicationName() throws TestFailedException {
        TestFunction.assertEqual(StageData.stage.getTitle(), "Battleship");
    }

    
    @TestCase(name = "Game menu contains label \"Your Ships\"")
    @Tip(description = "Make sure you have a label containing \"Your Ships\"!")
    public void checkForPlayerShipsLabel() throws TestFailedException {
        Scene scene = StageData.stage.getScene();

        Label returned = RecursiveSearch.recursiveSearch(
                ((Label b) -> b.getText().contains("Your Ships")),
                Label.class,
                (Pane) scene.getRoot());

        TestFunction.assertEqual(true, returned != null);

    }

    @TestCase(name = "Game menu contains label \"Battleship\" somewhere")
    @Tip(description = "Make sure you have a label containing \"Battleship\"!")
    public void checkForBattleshipLabel() throws TestFailedException {
        Scene scene = StageData.stage.getScene();

        Label returned = RecursiveSearch.recursiveSearch(
                ((Label b) -> b.getText().equals("Battleship")),
                Label.class,
                (Pane) scene.getRoot());

        TestFunction.assertEqual(true, returned != null);

    }


    @TestCase(name = "Game menu contains label \"Enemy Ships\"")
    @Tip(description = "Make sure you have a label containing \"Enemy Ships\"!")
    public void checkForEnemyShipsLabel() throws TestFailedException {
        Scene scene = StageData.stage.getScene();

        Label returned = RecursiveSearch.recursiveSearch(
                ((Label b) -> b.getText().contains("Enemy Ships")),
                Label.class,
                (Pane) scene.getRoot());

        TestFunction.assertEqual(true, returned != null);

    }

    @TestCase(name = "Game menu contains button labeled \"GUESS\"")
    @Tip(description = "Make sure your button formatting is correct!")
    public void checkForGuessButton() throws TestFailedException {
        Scene scene = StageData.stage.getScene();

        Button returned = RecursiveSearch.recursiveSearch(
                ((Button b) -> b.getText().equals("GUESS")),
                Button.class,
                (Pane) scene.getRoot());

        TestFunction.assertEqual(true, returned != null);
    }


    @TestCase(name = "Game menu contains an character combobox")
    @Tip(description = "Make sure you have a combobox as specified in the docs, and your ComboBox has a default value!")
    public void checkForCharacterCombobox() throws TestFailedException {
        Scene scene = StageData.stage.getScene();

        ComboBox<Character> returned = RecursiveSearch.recursiveSearch(
                ((ComboBox b) -> b.getValue() instanceof Character),
                ComboBox.class,
                (Pane) scene.getRoot());

        TestFunction.assertEqual(true, returned != null);

    }

    @TestCase(name = "Game menu contains an integer combobox")
    @Tip(description = "Make sure you have a combobox as specified in the docs, and your ComboBox has a default value!")
    public void checkForButton() throws TestFailedException {
        Scene scene = StageData.stage.getScene();

        ComboBox<Integer> returned = RecursiveSearch.recursiveSearch(
                ((ComboBox b) -> b.getValue() instanceof Integer),
                ComboBox.class,
                (Pane) scene.getRoot());

        TestFunction.assertEqual(true, returned != null);

    }

    @TestCase(name = "Game menu integer combobox has default value 1")
    @Tip(description = "Make sure your combobox is set to the correct default value!")
    public void checkDefaultIntegerCombobox() throws TestFailedException {
        StageData.stage.setOnShowing(e -> {
            System.out.println("ASHDAHDIWAJ");
        });

        Scene scene = StageData.stage.getScene();

        ComboBox<Integer> returned = RecursiveSearch.recursiveSearch(
                ((ComboBox b) -> b.getValue() instanceof Integer),
                ComboBox.class,
                (Pane) scene.getRoot());

        TestFunction.assertEqual(returned != null, true);
        TestFunction.assertEqual(returned.getValue(), 1);
        TestFunction.assertEqual(true, returned != null);

    }


}