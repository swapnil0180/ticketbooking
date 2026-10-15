package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository
        extends JpaRepository<Ticket, Long> {

    List<Ticket> findByMovieNameContainingIgnoreCase(
            String movieName);

    List<Ticket> findByCustomerNameContainingIgnoreCase(
            String customerName);
}

