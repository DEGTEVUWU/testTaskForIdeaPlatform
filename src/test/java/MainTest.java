import functions.DifferenceBetweenMeanAndMedian;
import functions.MinFlightTimeByCarrier;
import functions.PricesByCarrier;
import models.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import static org.opentest4j.AssertionFailedError.*;
import org.junit.jupiter.api.Test;
class MainTest {
    private String url;
    private List<Ticket> tickets;

    @BeforeEach
    public void before() {
        String url = "./src/test/resources/test_tickets.json";
        List<Ticket> tickets = Parser.parse(url);
    }
    @Test
    public void testDifferenceBetweenMeanAndMedian() {
        Map<String, Duration> minFlightTimeByCarrier = MinFlightTimeByCarrier.minFlightTimeByCarrier(tickets);
        Map<String, List<Integer>> pricesByCarrier = PricesByCarrier.pricesByCarrier(tickets);
        Map<String, Double> differenceMap = DifferenceBetweenMeanAndMedian.differenceBetweenMeanAndMedian(
            minFlightTimeByCarrier,
            pricesByCarrier
        );
    }
    @Test
    public void testMinFlightTimeByCarrier() {

    }
    @Test
    public void testPricesByCarries() {

    }

}