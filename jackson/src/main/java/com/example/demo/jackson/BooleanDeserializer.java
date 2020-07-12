package com.example.demo.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class BooleanDeserializer extends StdDeserializer<Boolean> {

	private static final long serialVersionUID = 1L;

	protected BooleanDeserializer() {
		this(null);
	}

	protected BooleanDeserializer(Class<Boolean> t) {
		super(t);
	}

	@Override
	public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		if ("Y".equalsIgnoreCase(p.getValueAsString())) {
			return true;
		}
		return false;
	}
}