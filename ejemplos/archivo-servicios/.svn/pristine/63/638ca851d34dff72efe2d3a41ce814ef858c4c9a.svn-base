package dr.gob.hacienda.servicios.utilitarios;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DeserializadorFechaNorticA4 extends JsonDeserializer<Date> {
	public static final String MASCARA_FECHA_HORA_NORTIC_A4 = "yyyy-MM-dd HH:mm:ss";

	private SimpleDateFormat dateFormat = new SimpleDateFormat(MASCARA_FECHA_HORA_NORTIC_A4);

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		try {
			return dateFormat.parse(jp.getValueAsString());
		} catch (ParseException e) {
			throw new RuntimeException(new StringBuilder(100).append("El formato del campo ")
					.append(jp.getCurrentName()).append(" en la clase ").append(ctxt.getClass().getSimpleName())
					.append(" es incorrecto! \nPor favor ajustarse al siguiente estandar: ").append(MASCARA_FECHA_HORA_NORTIC_A4).toString(), e);
		}
	}

}