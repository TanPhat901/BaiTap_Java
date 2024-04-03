package Model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	private List<String> collection;

	public Model() {
		this.collection = new ArrayList<String>();
	}
	public void addItem(String item) {
		collection.add(item);
	}
	public List<String> getitem(){
		return collection;
	}

}