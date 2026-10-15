package com.example.demo;



import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    // POST /api/tickets
    @PostMapping
    public ResponseEntity<Ticket> bookTicket(
            @Valid @RequestBody Ticket ticket) {

        Ticket savedTicket = ticketService.bookTicket(ticket);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedTicket);
    }

    // GET /api/tickets
    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(
                ticketService.getAllTickets());
    }

    // GET /api/tickets/1
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                ticketService.getTicketById(id));
    }

    // GET /api/tickets/search?movieName=Avengers
    @GetMapping("/search")
    public ResponseEntity<List<Ticket>> searchByMovie(
            @RequestParam String movieName) {

        return ResponseEntity.ok(
                ticketService.searchByMovie(movieName));
    }

    // GET /api/tickets/search/customer?customerName=Rahul
    @GetMapping("/search/customer")
    public ResponseEntity<List<Ticket>> searchByCustomer(
            @RequestParam String customerName) {

        return ResponseEntity.ok(
                ticketService.searchByCustomer(customerName));
    }

    // PUT /api/tickets/1
    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(
            @PathVariable Long id,
            @Valid @RequestBody Ticket ticket) {

        return ResponseEntity.ok(
                ticketService.updateTicket(id, ticket));
    }

    // DELETE /api/tickets/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelTicket(
            @PathVariable Long id) {

        ticketService.cancelTicket(id);
        return ResponseEntity.noContent().build();
    }
}
