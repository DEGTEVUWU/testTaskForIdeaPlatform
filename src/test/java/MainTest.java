import functions.DifferenceBetweenMeanAndMedian;
import functions.MinFlightTimeByCarrier;
import functions.PricesByCarrier;
import models.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MainTest {
    private final String url = "./src/test/resources/test_tickets.json";
    private final List<Ticket> tickets = Parser.parse(url);

    @Test
    public void testDifferenceBetweenMeanAndMedian() {
        Map<String, Duration> minFlightTimeByCarrier = MinFlightTimeByCarrier.minFlightTimeByCarrier(tickets);
        Map<String, List<Integer>> pricesByCarrier = PricesByCarrier.pricesByCarrier(tickets);
        Map<String, Double> differenceMap = DifferenceBetweenMeanAndMedian.differenceBetweenMeanAndMedian(
            minFlightTimeByCarrier,
            pricesByCarrier
        );
        assertThat(differenceMap.get("TK")).isEqualTo(333.33333333333394);
        assertThat(differenceMap.get("S7")).isEqualTo(0.0);

    }
    @Test
    public void testMinFlightTimeByCarrier() {
        Map<String, Duration> minFlightTimeByCarrier = MinFlightTimeByCarrier.minFlightTimeByCarrier(tickets);

        assertThat(minFlightTimeByCarrier.get("TK").toMinutes()).isEqualTo(350);
        assertThat(minFlightTimeByCarrier.get("S7").toMinutes()).isEqualTo(390);

    }
    @Test
    public void testPricesByCarries() {
        Map<String, List<Integer>> pricesByCarrier = PricesByCarrier.pricesByCarrier(tickets);

        assertThat(pricesByCarrier.size()).isEqualTo(2);
        assertThat(pricesByCarrier.get("TK").get(0)).isEqualTo(10000);
        assertThat(pricesByCarrier.get("S7").get(0)).isEqualTo(13100);
    }

}