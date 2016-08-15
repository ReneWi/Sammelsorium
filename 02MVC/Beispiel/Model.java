import java.util.ArrayList;

import javafx.collections.ModifiableObservableListBase;

public class Model extends ModifiableObservableListBase<String> {
	private final ArrayList<String> delegate = new ArrayList<String>();

	@Override
	public String get(int index) {
		return delegate.get(index);
	}

	@Override
	public int size() {
		return delegate.size();
	}

	@Override
	protected String doRemove(int index) {
		return delegate.remove(index);
	}

	@Override
	protected void doAdd(int index, String s) {
		delegate.add(index, s);
	}

	@Override
	protected String doSet(int index, String s) {
		return delegate.set(index, s);
	}

}
