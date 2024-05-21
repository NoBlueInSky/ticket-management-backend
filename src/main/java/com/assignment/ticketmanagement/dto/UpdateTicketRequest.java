package com.assignment.ticketmanagement.dto;

import com.assignment.ticketmanagement.model.TicketStatus;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UpdateTicketRequest {

    private String title;
    private String description;
    private String contact;
    private String information;

    private TicketStatus status;
}