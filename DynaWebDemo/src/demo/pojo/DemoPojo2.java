package demo.pojo;

import javax.enterprise.context.ApplicationScoped;

import org.jboss.logging.Logger;

import demo.utils.JsonToStringBuilder;

@ApplicationScoped
public class DemoPojo2 {

	private final Logger LOG = Logger.getLogger(this.getClass());

	private int data = 0;

	public int getData() {
		return data++;
	}

	public void setData(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		JsonToStringBuilder builder = new JsonToStringBuilder(this);
		builder.append("LOG", LOG);
		builder.append("data", data);
		return builder.toString();
	}
}
