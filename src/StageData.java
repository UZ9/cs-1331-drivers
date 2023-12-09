import com.cs1331.drivers.annotations.InjectData;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageData {
    @InjectData(name = "stage")
    public static Stage stage;

    public static Scene currentScene;
}
