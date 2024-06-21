package com.example.dto;

import com.example.models.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TicketDTO {

    private String username;
    private int scheduleId;
    private String seating;
    private Double total;
}


