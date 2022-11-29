package uk.gov.dwp.uc.pairtest.domain;

import java.text.NumberFormat;
import java.util.Scanner;

public class TicketPrice {

    public int calculateTicketPrice(int totalTicketsRequested, int ticketCountAdult, int ticketCountChild, int ticketCountInfant) {

        var priceForInfant = 0;
        var priceForChild = 10;
        var priceForAdult = 20;

        var total = 0;
        var actualTicketsCount = 0;
        var totalPriceAdults = 0;
        var totalPriceChildren = 0;

        if (totalTicketsRequested > 0 && totalTicketsRequested <= 20) {
            if (ticketCountAdult > 0) {
                actualTicketsCount = ticketCountAdult + ticketCountChild + ticketCountInfant;
                totalPriceAdults = ticketCountAdult * priceForAdult;
                totalPriceChildren = ticketCountChild * priceForChild;

                if (actualTicketsCount <= totalTicketsRequested)
                    total = totalPriceAdults + totalPriceChildren + priceForInfant;
                else
                    System.out.println("There was a mismatch between the requested tickets and the actual tickets ordered. Please try again.");

            } else {
                System.out.println("Unable to process your request. Infants and children must be accompanied by an adult.");
            }
        } else {
            System.out.println("Minimum purchase is 1 ticket, maximum 20 tickets.");
        }
        return total;
    }

//    public static void main(String[] args) {
//        var scanner = new Scanner(System.in);
//        var currencyInstance = NumberFormat.getCurrencyInstance();
//        var ticketPrice = new TicketPrice();
//        var seatToReserve = new SeatsToReserve();
//
//        System.out.println();
//        try {
//            System.out.println("How many tickets would you like?");
//            var requestedTicketsCount = scanner.nextInt();
//
//            if (requestedTicketsCount > 0 && requestedTicketsCount <= 20) {
//
//                System.out.println("How many adult tickets would you like?");
//                var totalAdultTicketsCount = scanner.nextInt();
//
//                if (totalAdultTicketsCount > 0) {
//
//                    System.out.println("How many child tickets would you like?");
//                    var totalChildTicketsCount = scanner.nextInt();
//
//                    System.out.println("How many infant tickets would you like?");
//                    var totalInfantTicketsCount = scanner.nextInt();
//
//                    var totalPrice = ticketPrice.calculateTicketPrice(requestedTicketsCount, totalAdultTicketsCount, totalChildTicketsCount, totalInfantTicketsCount);
//                    var formattedCurrency = currencyInstance.format(totalPrice);
//                    var totalSeatsRequired = seatToReserve.calculateSeatsToReserve(totalAdultTicketsCount, totalChildTicketsCount);
//                    var actualTicketsCount = totalAdultTicketsCount + totalChildTicketsCount + totalInfantTicketsCount;
//
//                    if (actualTicketsCount <= requestedTicketsCount) {
//                        System.out.println();
//                        System.out.println("Total amount to pay: " + formattedCurrency);
//                        System.out.println("Total seats to reserve: " + totalSeatsRequired);
//                    }
//
//                } else {
//                    System.out.println("Unable to process your request. Infants and children must be accompanied by an adult.");
//                }
//            } else {
//                System.out.println("Minimum purchase is 1 ticket, maximum 20 tickets.");
//            }
//        } catch (Exception e) {
//            System.out.println("Only numeric values are allowed. Please try again.");
//        }
//    }
}
