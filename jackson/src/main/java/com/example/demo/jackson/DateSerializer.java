package com.example.demo.jackson;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DateSerializer extends StdSerializer<LocalDateTime> {

	private static final long serialVersionUID = 1L;

	protected DateSerializer() {
		this(null);
	}

	protected DateSerializer(Class<LocalDateTime> t) {
		super(t);
	}

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@Override
	public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		gen.writeString(formatter.format(value));
	}
}