package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.DemoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
POST http://localhost:8080/hello HTTP/1.1
Content-Type: application/json;charset=UTF-8

{
	"STRING":"A"
	,"NUMBER":"33.44"
	,"STRINGB":"B"
	,"FLAG":"Y"
	,"DATETIME":"2011-01-01 23:59:59"
	,"ARRAY":["A","B","C"]
	,"MAP":{
		"A":"A"
	}
}
 */

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void serializingTest() throws JsonProcessingException {

		System.out.println("========  serializingTest");

		DemoDTO pojo = new DemoDTO();
		pojo.setFlag(false);
		pojo.setNumber(BigDecimal.TEN);
		pojo.setDatetime(LocalDateTime.now());
		pojo.setStr("java2json");

		List<String> array = new ArrayList<String>();
		array.add("A");
		array.add("B");
		pojo.setArray(array);

		Map<String, String> map = new HashMap<String, String>();
		map.put("A", "A");
		pojo.setMap(map);

		String json = new ObjectMapper() //
				.writerWithDefaultPrettyPrinter() //
				.writeValueAsString(pojo);

		System.out.println(json);
	}

	@Test
	public void deserializingTest() throws JsonProcessingException {
		System.out.println("=========    deserializingTest");

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"STRING\":\"json2java\"");
		sb.append(",\"STRING2\":\"json2java\"");
		sb.append(",\"NUMBER\":\"33.44\"");
		sb.append(",\"DATETIME\":\"1999-01-01 02:02:02\"");
		sb.append(",\"FLAG\":\"N\"");
		sb.append("}");
		DemoDTO pojo = new ObjectMapper() //
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false) //
				.readValue(sb.toString(), DemoDTO.class);
		System.out.println(pojo);
	}

}
