package commandPattern;

public class GUICommand {
	void Execute(){}
}
class PasteCommand extends GUICommand{
	Document document;
	void Execute(){
		document.Paste();
	}
}
class MenuItem{
	GUICommand command;
	void DefaultInit(){
		command = new GUICommand();
	}
	void Clicked(){
		if(clicked){
			command.Execute();
		}
	}
}
class Application{
	MenuItem mi;
	PasteCommand pc;
	boolean real_use;
	
	void StoreCommand(GUICommand c){
		mi.command = c;
	}
	void AddMenuItem(){
		mi = new MenuItem();
		if(real_use){
			pc = new PasteCommand();
			StoreCommand(pc);
		}else{
			mi.DefaultInit();
		}
	}
}
