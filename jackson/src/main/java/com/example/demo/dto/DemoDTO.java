package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.example.demo.jackson.BooleanDeserializer;
import com.example.demo.jackson.BooleanSerializer;
import com.example.demo.jackson.DateDeserializer;
import com.example.demo.jackson.DateSerializer;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonPropertyOrder({ "STRING", "time" })
public class DemoDTO {

	@JsonProperty("STRING")
	private String str;

	@JsonProperty("NUMBER")
	private BigDecimal number;

	@JsonProperty("DATETIME")
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	private LocalDateTime datetime;

	@JsonProperty("FLAG")
	@JsonSerialize(using = BooleanSerializer.class)
	@JsonDeserialize(using = BooleanDeserializer.class)
	private Boolean flag;

	@JsonProperty("ARRAY")
	List<String> array;

	@JsonProperty("MAP")
	Map<String, String> map;

//	@JsonGetter("ARRAY")
	public List<String> getArray() {
		return array;
	}

	public void setArray(List<String> array) {
		this.array = array;
	}

	@JsonAnyGetter(enabled = false)
//	@JsonGetter("MAP")
	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public BigDecimal getNumber() {
		return number;
	}

	public void setNumber(BigDecimal number) {
		this.number = number;
	}

	public Boolean isFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "{\n str :" + str //
				+ ",\n number :" + number //
				+ ",\n datetime :" + datetime //
				+ ",\n flag :" + flag //
				+ ",\n array :" + array //
				+ ",\n map :" + map //
				+ "\n}";
	}

}
