
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		View view = new View();
		Model model = new Model();
		Controller controller = new Controller();
		controller.link(model, view);
		Scene scene = new Scene(view);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
