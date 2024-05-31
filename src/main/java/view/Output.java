package view;
import utils.TimeConverter;
import java.time.Duration;
import java.util.Map;

public class Output {
    public static void output(
        Map<String, Duration> minFlightTimeByCarrier,
        Map<String, Double> differenceMap
    ) {
        for (Map.Entry<String, Duration> entry : minFlightTimeByCarrier.entrySet()) {
            String carrier = entry.getKey();
            Duration minFlightTime = entry.getValue();
            String convertMinFlightTime = TimeConverter.convertMinutesToHoursAndMinutes(minFlightTime.toMinutes());
            Double difference = differenceMap.get(carrier);

            System.out.println("Перевозчик: " + carrier);
            System.out.println("Мин. время полета: " + convertMinFlightTime);
            System.out.println("Разница между средней ценой и медианой: " + difference +  " руб.");
            System.out.println();
        }
    }
}
