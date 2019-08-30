import org.junit.Assert;
import org.junit.Test;

public class Tests {
    @Test
    public void gateCorrectlyIncrementsTicketsValidated() {
        FestivalGate gate = new FestivalGate();
        gate.addTicket(TicketType.FREE_PASS);
        int ticketsOfKind = gate.getTicketsPurchased().get(TicketType.FREE_PASS);
        Assert.assertEquals(ticketsOfKind, 1);
    }
}
