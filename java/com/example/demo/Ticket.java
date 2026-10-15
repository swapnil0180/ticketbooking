package com.example.demo;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "movie_tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @NotBlank(message = "Movie name is required")
    @Column(nullable = false)
    private String movieName;

    @NotBlank(message = "Customer name cannot be empty")
    @Column(nullable = false)
    private String customerName;

    @NotBlank(message = "Seat number is required")
    @Column(nullable = false)
    private String seatNumber;

    @Positive(message = "Ticket price must be positive")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal ticketPrice;
}

