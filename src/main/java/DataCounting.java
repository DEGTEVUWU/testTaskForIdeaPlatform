
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
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DataCounting {
    public static void generate(String filePath) {
        List<Ticket> tickets = Parser.parse(filePath);

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

