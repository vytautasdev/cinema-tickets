package uk.gov.dwp.uc.pairtest.domain;

public class SeatsToReserve {

    public int calculateSeatsToReserve(int ticketCountAdult, int ticketCountChild) {
        return ticketCountAdult + ticketCountChild;
    }
}

