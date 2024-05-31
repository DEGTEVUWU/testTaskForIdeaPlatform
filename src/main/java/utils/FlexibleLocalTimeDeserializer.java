package utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FlexibleLocalTimeDeserializer extends JsonDeserializer<LocalTime> {
    private static final DateTimeFormatter FORMATTER_ONE = DateTimeFormatter.ofPattern("H:mm");
    private static final DateTimeFormatter FORMATTER_TWO = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String timeStr = jsonParser.getText();
        try {
            return LocalTime.parse(timeStr, FORMATTER_TWO);
        } catch (DateTimeParseException e) {
            return LocalTime.parse(timeStr, FORMATTER_ONE);
        }
    }
}
