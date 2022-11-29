package uk.gov.dwp.uc.pairtest;

import org.junit.Test;
import uk.gov.dwp.uc.pairtest.domain.Customer;
import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;

import static org.mockito.Mockito.*;


public class TicketServiceImplTest {

    @Test
    public void purchaseTickets() {

        var c1 = new Customer();
        var purchaseTicketsMock = mock(TicketServiceImpl.class);

        doNothing().when(purchaseTicketsMock).purchaseTickets(isA(Long.class), isA(TicketTypeRequest.class));

//        purchaseTicketsMock.purchaseTickets(c1.getAccountId());
//        purchaseTicketsMock.purchaseTickets(c1.getAccountId());
        purchaseTicketsMock.purchaseTickets(c1.getAccountId());

        verify(purchaseTicketsMock, times(2)).purchaseTickets(c1.getAccountId());

    }
}