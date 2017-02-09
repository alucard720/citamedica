package dr.gob.hacienda.servicios.utilitarios;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class SerializadorFechaNorticA4 extends JsonSerializer<Date> {
	private SimpleDateFormat dateFormat = new SimpleDateFormat(DeserializadorFechaNorticA4.MASCARA_FECHA_HORA_NORTIC_A4);

	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException,JsonProcessingException {
		jgen.writeString(dateFormat.format(value));
	}
}