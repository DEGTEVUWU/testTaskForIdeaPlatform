package utils;

public class TimeConverter {
    public static String convertMinutesToHoursAndMinutes(long minutes) {
        long hours = minutes / 60;
        long remainingMinutes = minutes % 60;
        return hours + " час(ов) " + remainingMinutes + " минут(а)";
    }
}
