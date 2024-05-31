package functions;

import models.Ticket;
import java.text.ParseException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinFlightTimeByCarrier {
    public static Map<String, Duration>  minFlightTimeByCarrier(List<Ticket> tickets) {
        Map<String, Duration> minFlightTimeByCarrier = new HashMap<>();
        for (Ticket ticket : tickets) {
            if ("VVO".equals(ticket.getOrigin()) && "TLV".equals(ticket.getDestination())) {
                try {
                    Duration flightDuration = ticket.getFlightDuration();
                    minFlightTimeByCarrier.merge(ticket.getCarrier(), flightDuration,(oldDuration, newDuration) -> {
                        if (newDuration.compareTo(oldDuration) < 0) {
                            return newDuration;
                        } else {
                            return oldDuration;
                        }
                    });
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return minFlightTimeByCarrier;
    }
}
