package functions;

import models.Ticket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PricesByCarrier {
    public static Map<String, List<Integer>> pricesByCarrier(List<Ticket> tickets) {
        Map<String, List<Integer>> pricesByCarrier = new HashMap<>();
        for (Ticket ticket : tickets) {
            if ("VVO".equals(ticket.getOrigin()) && "TLV".equals(ticket.getDestination())) {
                pricesByCarrier.computeIfAbsent(ticket.getCarrier(), k -> new ArrayList<>()).add(ticket.getPrice());
            }
        }
        return pricesByCarrier;
    }
}
