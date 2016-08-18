package templateMethodPattern;

public abstract class Window {
	void display(){
		SetFocus();
		DoDisplay();
	}
	void SetFocus(){}
	abstract void DoDisplay();
}

class MyWindow extends Window{

	@Override
	void DoDisplay() {
		// TODO Auto-generated method stub
		
	}
	
}
