import java.util.Random;

public class Festival {

    public static void main(String[] args) {
        FestivalGate festivalGate = new FestivalGate();
        Random random = new Random();

        FestivalStatisticsThread festivalStatistics = new FestivalStatisticsThread(festivalGate);
        try {
            festivalStatistics.start();

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        int attendees = random.nextInt(100) + 1000;

        for (int i = 0; i < attendees; i++) {
            TicketType ticketType = TicketType.values()[random.nextInt(TicketType.values().length)];
            FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(ticketType, festivalGate);
            festivalAttendee.validateTicket();
        }
    }
}
