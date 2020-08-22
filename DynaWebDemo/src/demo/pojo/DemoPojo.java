package demo.pojo;

import javax.inject.Named;

@Named
public class DemoPojo {

	private String data = "old";

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
