import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class View extends BorderPane {
	private Button addButton = new Button("Add");
	private Button deleteButton = new Button("Delete");
	private ListView<String> list = new ListView<String>();
	private TextField inputField = new TextField();

	public View() {
		HBox buttonBox = new HBox(addButton, deleteButton);
		setBottom(buttonBox);
		setCenter(inputField);
		setTop(list);

	}

	public Button getAddButton() {
		return addButton;
	}

	public Button getDeleteButton() {
		return deleteButton;
	}

	public ListView getList() {
		return list;
	}

	public TextField getInputField() {
		return inputField;
	}
}
