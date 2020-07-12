package com.example.demo.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class BooleanSerializer extends StdSerializer<Boolean> {

	private static final long serialVersionUID = 1L;

	protected BooleanSerializer() {
		this(null);
	}

	protected BooleanSerializer(Class<Boolean> t) {
		super(t);
	}

	@Override
	public void serialize(Boolean value, JsonGenerator gen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		if (value) {
			gen.writeString("Y");
		} else {
			gen.writeString("N");
		}
	}
}