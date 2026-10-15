package com.example.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    // Book a ticket
    public Ticket bookTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Get all tickets
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Get ticket by ID
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Ticket not found with ID: " + id));
    }

    // Search tickets by movie name
    public List<Ticket> searchByMovie(String movieName) {
        return ticketRepository
                .findByMovieNameContainingIgnoreCase(movieName);
    }

    // Search tickets by customer name
    public List<Ticket> searchByCustomer(String customerName) {
        return ticketRepository
                .findByCustomerNameContainingIgnoreCase(customerName);
    }

    // Update ticket
    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        Ticket existingTicket = getTicketById(id);

        existingTicket.setMovieName(updatedTicket.getMovieName());
        existingTicket.setCustomerName(updatedTicket.getCustomerName());
        existingTicket.setSeatNumber(updatedTicket.getSeatNumber());
        existingTicket.setTicketPrice(updatedTicket.getTicketPrice());

        return ticketRepository.save(existingTicket);
    }

    // Cancel ticket
    public void cancelTicket(Long id) {
        Ticket ticket = getTicketById(id);
        ticketRepository.delete(ticket);
    }
}

