package demo.pojo;

public class DemoBean {

	public DemoBean() {
		super();
		this.demoVarString = "initial";
		this.demoVarBool = false;
		this.demoVarInt = 0;
	}

	private String demoVarString;

	private boolean demoVarBool;

	private int demoVarInt;

	public String getPropString() {
		return this.demoVarString;
	}

	public boolean getPropBool() {
		return this.demoVarBool;
	}

	public int getPropInt() {
		return this.demoVarInt;
	}

	public void setPropString(String prop) {
		this.demoVarString = prop;
	}

}
