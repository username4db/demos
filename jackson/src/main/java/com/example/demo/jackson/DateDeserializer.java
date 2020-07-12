package com.example.demo.jackson;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class DateDeserializer extends StdDeserializer<LocalDateTime> {

	private static final long serialVersionUID = 1L;

	protected DateDeserializer() {
		this(null);
	}

	protected DateDeserializer(Class<LocalDateTime> t) {
		super(t);
	}

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@Override
	public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return LocalDateTime.parse(p.getValueAsString(), formatter);
	}
}