package uk.gov.dwp.uc.pairtest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private long accountId;
    private int noOfTickets;
    private TicketTypeRequest.Type ticketType;

}
