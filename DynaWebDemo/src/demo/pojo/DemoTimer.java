package demo.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class DemoTimer implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDateTime reqTime;

	private String[] localeNames = { "A", "B", "C" };

	private String selectedLocaleString;

	private String selectedLocale;

	private String locale;

	private String date;

	public LocalDateTime getReqTime() {
		return reqTime;
	}

	public void setReqTime(LocalDateTime reqTime) {
		this.reqTime = reqTime;
	}

	public LocalDateTime getElapsedTime() {
		return reqTime;
	}

	public String[] getLocaleNames() {
		return localeNames;
	}

	public void setLocaleNames(String[] localeNames) {
		this.localeNames = localeNames;
	}

	public String getSelectedLocaleString() {
		return selectedLocaleString;
	}

	public void setSelectedLocaleString(String selectedLocaleString) {
		this.selectedLocaleString = selectedLocaleString;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSelectedLocale() {
		return selectedLocale;
	}

	public void setSelectedLocale(String selectedLocale) {
		this.selectedLocale = selectedLocale;
	}
}
