package uk.gov.dwp.uc.pairtest;

import org.junit.Test;
import uk.gov.dwp.uc.pairtest.domain.SeatsToReserve;
import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;

import static org.junit.Assert.*;

public class SeatsToReserveTest {

    @Test
    public void calculateSeatsToReserve() {

        var seatsToReserve = new SeatsToReserve();

        var adult = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 3);
        var child = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 2);

//        assertEquals(4, seatsToReserve.calculateSeatsToReserve(adult.getNoOfTickets(), child.getNoOfTickets()));
        assertEquals(5, seatsToReserve.calculateSeatsToReserve(adult.getNoOfTickets(), child.getNoOfTickets()));
    }
}