import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
	private Model model;
	private View view;
	private ListView<String> list;

	public void link(Model model, View view) {
		this.model = model;
		this.view = view;
		list = view.getList();
		list.setItems(model);

		view.getAddButton().setOnAction(e -> {
			String s = view.getInputField().getText();
			if (!s.equals("")) {
				model.add(s);
				view.getInputField().clear();

			}
		});

		view.getDeleteButton().setOnAction(e -> {

			int index = list.getSelectionModel().getSelectedIndex();
			if (index > -1) {
				model.remove(index);
			} else {
				System.out.println("No item selected!");
			}
		});
		view.getInputField().setOnKeyPressed(new EventHandler<KeyEvent>() { // wenn inputField fokussiert ist kann mit der ENTER-Taste
										    // der add Button bedient werden		
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					view.getAddButton().fire();
				}
			}

		});
	}
}
