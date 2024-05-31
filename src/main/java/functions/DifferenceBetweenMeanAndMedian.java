package functions;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DifferenceBetweenMeanAndMedian {
    public static Map<String, Double> differenceBetweenMeanAndMedian(
        Map<String, Duration> minFlightTimeByCarrier,
        Map<String, List<Integer>> pricesByCarrier
    ) {
        Map<String, Double> differenceMap = new HashMap<>();

        for (Map.Entry<String, Duration> entry : minFlightTimeByCarrier.entrySet()) {
            String carrier = entry.getKey();
            List<Integer> prices = pricesByCarrier.get(carrier);

            double average = prices.stream().mapToDouble(a -> a).average().orElse(0);
            Collections.sort(prices);
            double median = prices.size() % 2 == 0 ?
                (double) (prices.get(prices.size() / 2) + prices.get(prices.size() / 2 - 1)) / 2 :
                prices.get(prices.size() / 2);
            differenceMap.put(carrier, Math.abs(average - median));
        }
        return differenceMap;
    }

}
