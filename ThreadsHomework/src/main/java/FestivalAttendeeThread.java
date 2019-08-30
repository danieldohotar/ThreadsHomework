import java.util.Random;

public class FestivalAttendeeThread extends Thread {
    TicketType ticketType;
    FestivalGate festivalGate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate festivalGate) {
        this.ticketType = ticketType;
        this.festivalGate = festivalGate;
    }

    public Thread createThread(FestivalAttendeeThread festivalAttendee) {
        Thread myRunnableThread = new Thread(festivalAttendee);
        return myRunnableThread;
    }


    public void validateTicket() {
        Random random = new Random();
        try {
            sleep(random.nextInt(10) * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        start();
        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "FestivalAttendeeThread{" +
                "ticketType= " + ticketType +
                ", festivalGate= " + festivalGate +
                '}';
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(toString());
            festivalGate.addTicket(ticketType);
        }
    }
}