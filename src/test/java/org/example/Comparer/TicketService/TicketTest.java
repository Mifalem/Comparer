package org.example.Comparer.TicketService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class TicketTest {

//    "тестирование только по цене 1 способ"

    @Test
    public void shouldSortTickets() {
        AviaSouls service = new AviaSouls();

        Ticket ticket1 = new Ticket("SVX", "MSK", 3000, 6, 8);
        Ticket ticket2 = new Ticket("SVX", "SPB", 3500, 3, 10);
        Ticket ticket3 = new Ticket("MSK", "SPB", 4000, 8, 10);
        Ticket ticket4 = new Ticket("SPB", "MSK", 3000, 9, 11);
        Ticket ticket5 = new Ticket("CEK", "MSK", 2500, 3, 5);
        Ticket ticket6 = new Ticket("SVX", "SPB", 2500, 13, 14);
        Ticket ticket7 = new Ticket("SVX", "SPB", 3500, 15, 18);

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);

        Ticket[] actual = service.search("SVX", "SPB");
        Ticket[] expected = {ticket6, ticket2, ticket7};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortTicketsThanNotValue() {
        AviaSouls service = new AviaSouls();

        Ticket ticket1 = new Ticket("SVX", "MSK", 3000, 6, 8);
        Ticket ticket2 = new Ticket("SVX", "SPB", 3500, 3, 10);
        Ticket ticket3 = new Ticket("MSK", "SPB", 4000, 8, 10);
        Ticket ticket4 = new Ticket("SPB", "MSK", 3000, 9, 11);
        Ticket ticket5 = new Ticket("CEK", "MSK", 2500, 3, 5);
        Ticket ticket6 = new Ticket("SVX", "SPB", 2500, 13, 14);
        Ticket ticket7 = new Ticket("SVX", "SPB", 3500, 15, 18);

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);

        Ticket[] actual = service.search("SVX", "AFR");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortTicketsThanOneTicket() {
        AviaSouls service = new AviaSouls();

        Ticket ticket1 = new Ticket("SVX", "MSK", 3000, 6, 8);
        Ticket ticket2 = new Ticket("SVX", "SPB", 3500, 3, 10);
        Ticket ticket3 = new Ticket("MSK", "SPB", 4000, 8, 10);
        Ticket ticket4 = new Ticket("SPB", "MSK", 3000, 9, 11);
        Ticket ticket5 = new Ticket("CEK", "MSK", 2500, 3, 5);
        Ticket ticket6 = new Ticket("SVX", "SPB", 2500, 13, 14);
        Ticket ticket7 = new Ticket("SVX", "SPB", 3500, 15, 18);

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);

        Ticket[] actual = service.search("SVX", "MSK");
        Ticket[] expected = {ticket1};

        Assertions.assertArrayEquals(expected, actual);

    }

//    "Тестирование компоратором 2 способ"

    @Test
    public void shouldSortTicketsByTime() {
        AviaSouls service = new AviaSouls();

        Ticket ticket1 = new Ticket("SVX", "MSK", 3000, 6, 8);
        Ticket ticket2 = new Ticket("SVX", "SPB", 3500, 3, 10);
        Ticket ticket3 = new Ticket("MSK", "SPB", 4000, 8, 10);
        Ticket ticket4 = new Ticket("SPB", "MSK", 3000, 9, 11);
        Ticket ticket5 = new Ticket("CEK", "MSK", 2500, 3, 5);
        Ticket ticket6 = new Ticket("SVX", "SPB", 2500, 13, 14);
        Ticket ticket7 = new Ticket("SVX", "SPB", 3500, 15, 18);

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = service.search("SVX", "SPB", comparator);
        Ticket[] expected = {ticket6, ticket7, ticket2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortTicketsByTimeThanNotValue() {
        AviaSouls service = new AviaSouls();

        Ticket ticket1 = new Ticket("SVX", "MSK", 3000, 6, 8);
        Ticket ticket2 = new Ticket("SVX", "SPB", 3500, 3, 10);
        Ticket ticket3 = new Ticket("MSK", "SPB", 4000, 8, 10);
        Ticket ticket4 = new Ticket("SPB", "MSK", 3000, 9, 11);
        Ticket ticket5 = new Ticket("CEK", "MSK", 2500, 3, 5);
        Ticket ticket6 = new Ticket("SVX", "SPB", 2500, 13, 14);
        Ticket ticket7 = new Ticket("SVX", "SPB", 3500, 15, 18);

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = service.search("SVX", "AFR", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortTicketsByTimeThanOneTicket() {
        AviaSouls service = new AviaSouls();

        Ticket ticket1 = new Ticket("SVX", "MSK", 3000, 6, 8);
        Ticket ticket2 = new Ticket("SVX", "SPB", 3500, 3, 10);
        Ticket ticket3 = new Ticket("MSK", "SPB", 4000, 8, 10);
        Ticket ticket4 = new Ticket("SPB", "MSK", 3000, 9, 11);
        Ticket ticket5 = new Ticket("CEK", "MSK", 2500, 3, 5);
        Ticket ticket6 = new Ticket("SVX", "SPB", 2500, 13, 14);
        Ticket ticket7 = new Ticket("SVX", "SPB", 3500, 15, 18);

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = service.search("MSK", "SPB", comparator);
        Ticket[] expected = {ticket3};

        Assertions.assertArrayEquals(expected, actual);

    }
}
