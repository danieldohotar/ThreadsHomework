import java.util.Map;

public class FestivalStatisticsThread extends Thread {
    public final FestivalGate gate;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!gate.getTicketsPurchased().isEmpty()) {
                printStatistics();
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private void printStatistics() {
        for (Map.Entry<TicketType, Integer> entry : gate.getTicketsPurchased().entrySet()) {
            System.out.println(entry.getValue() + " tickets of type " + entry.getKey());
        }
    }
}
