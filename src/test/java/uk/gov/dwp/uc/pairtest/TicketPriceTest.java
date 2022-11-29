package uk.gov.dwp.uc.pairtest;

import org.junit.Test;
import uk.gov.dwp.uc.pairtest.domain.TicketPrice;

import static org.junit.Assert.assertEquals;

public class TicketPriceTest {

    @Test
    public void calculateTicketPrice() {
        var tpc = new TicketPrice();

        // Check if total tickets count is greater than 0 and <= 20
//        assertEquals(0, tpc.calculateTicketPrice(0, 1,2,1));
//        assertEquals(40, tpc.calculateTicketPrice(5, 1,2,1));
//        assertEquals(0, tpc.calculateTicketPrice(21, 1,2,1));
//        assertEquals(340, tpc.calculateTicketPrice(20, 15,4,1));

        // Check if at least 1 customer is an adult
//        assertEquals(0, tpc.calculateTicketPrice(5, 0, 2, 2));
//        assertEquals(30, tpc.calculateTicketPrice(3, 1, 1, 1));
//        assertEquals(50, tpc.calculateTicketPrice(4, 2, 1, 1));

        // Check if total requested tickets and actual ordered tickets are equal
//        assertEquals(40, tpc.calculateTicketPrice(5, 1, 2, 2));
//        assertEquals(0, tpc.calculateTicketPrice(5, 1, 2, 3));
//        assertEquals(0, tpc.calculateTicketPrice(3, 1, 2, 1));

    }
}