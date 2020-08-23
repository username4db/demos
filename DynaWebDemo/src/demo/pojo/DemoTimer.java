package demo.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class DemoTimer implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDateTime reqTime;

	public LocalDateTime getReqTime() {
		return reqTime;
	}

	public void setReqTime(LocalDateTime reqTime) {
		this.reqTime = reqTime;
	}

	public LocalDateTime getElapsedTime() {
		return reqTime;
	}
}
