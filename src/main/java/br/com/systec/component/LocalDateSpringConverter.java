package br.com.systec.component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

@Component
public class LocalDateSpringConverter implements Converter<String, LocalDate> {

	@Override
	public LocalDate convert(String value) {
		if(value != null) {
		     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(value, formatter);
		}else {
			return null;
		}
	}

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return null;
	}

}