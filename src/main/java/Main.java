
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import functions.DifferenceBetweenMeanAndMedian;
import functions.MinFlightTimeByCarrier;
import functions.PricesByCarrier;
import models.Ticket;
import models.TicketsWrapper;
import view.Output;

import java.io.File;
import java.io.IOException;

import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class Main {
        public static void main(String[] args) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            List<Ticket> tickets = new ArrayList<>();
            try {
                TicketsWrapper ticketsWrapper = objectMapper.readValue(new File("src/main/resources/tickets.json"), TicketsWrapper.class);
                tickets = ticketsWrapper.getTickets();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Map<String, Duration> minFlightTimeByCarrier = MinFlightTimeByCarrier.minFlightTimeByCarrier(tickets);
            Map<String, List<Integer>> pricesByCarrier = PricesByCarrier.pricesByCarrier(tickets);
            Map<String, Double> difference = DifferenceBetweenMeanAndMedian.differenceBetweenMeanAndMedian(
                minFlightTimeByCarrier,
                pricesByCarrier
            );

            Output.output(
                minFlightTimeByCarrier,
                difference
                );
        }
    }
