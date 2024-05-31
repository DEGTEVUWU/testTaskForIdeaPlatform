import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import models.Ticket;
import models.TicketsWrapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<Ticket> parse(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        List<Ticket> tickets = new ArrayList<>();

        try {
            TicketsWrapper ticketsWrapper = objectMapper.readValue(new File(filePath), TicketsWrapper.class);
            tickets = ticketsWrapper.getTickets();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tickets;
    }
}
