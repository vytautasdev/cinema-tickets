package uk.gov.dwp.uc.pairtest;

import thirdparty.paymentgateway.TicketPaymentServiceImpl;
import thirdparty.seatbooking.SeatReservationServiceImpl;
import uk.gov.dwp.uc.pairtest.domain.Customer;
import uk.gov.dwp.uc.pairtest.domain.SeatsToReserve;
import uk.gov.dwp.uc.pairtest.domain.TicketPrice;
import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;
import uk.gov.dwp.uc.pairtest.exception.InvalidPurchaseException;

public class TicketServiceImpl implements TicketService {
    /**
     * Should only have private methods other than the one below.
     */

    Customer adult = null;
    Customer child = null;
    Customer infant = null;

    @Override
    public void purchaseTickets(Long accountId, TicketTypeRequest... ticketTypeRequests) throws InvalidPurchaseException {

        var requestToMakePayment = new TicketPaymentServiceImpl();
        var requestToReserveSeat = new SeatReservationServiceImpl();


        var c1 = new Customer();
        c1.setAccountId(accountId);

        var c2 = new Customer();
        c2.setAccountId(accountId);

        var c3 = new Customer();
        c3.setAccountId(accountId);


        for (var item : ticketTypeRequests
        ) {
            var ticketType = item.getTicketType();
            var noOfTickets = item.getNoOfTickets();

            c1.setTicketType(ticketType);
            c1.setNoOfTickets(noOfTickets);
            adult = c1;

            c2.setTicketType(ticketType);
            c2.setNoOfTickets(noOfTickets);
            child = c2;

            c3.setTicketType(ticketType);
            c3.setNoOfTickets(noOfTickets);
            infant = c3;

        }

        if (adult != null) {
            if (adult.getAccountId() > 0) {
                requestToMakePayment.makePayment(adult.getAccountId(), calculateTotalAmountToPay());
                requestToReserveSeat.reserveSeat(adult.getAccountId(), calculateTotalSeatsToReserve());
            } else {
                throw new IllegalArgumentException("Account id must be greater than zero.");
            }
        } else {
            throw new NullPointerException("Customer cannot be null");
        }
    }


    private int calculateTotalAmountToPay() {

        var ticketPrice = new TicketPrice();
        var actualTicketsCount = adult.getNoOfTickets() + child.getNoOfTickets() + infant.getNoOfTickets();

        return ticketPrice.calculateTicketPrice(actualTicketsCount, adult.getNoOfTickets(), child.getNoOfTickets(), infant.getNoOfTickets());
    }

    private int calculateTotalSeatsToReserve() {

        var seatsToReserve = new SeatsToReserve();

        return seatsToReserve.calculateSeatsToReserve(adult.getNoOfTickets(), child.getNoOfTickets());
    }
}
