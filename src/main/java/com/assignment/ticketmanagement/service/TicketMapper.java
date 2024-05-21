package com.assignment.ticketmanagement.service;

import com.assignment.ticketmanagement.dto.UpdateTicketRequest;
import com.assignment.ticketmanagement.model.Ticket;

public class TicketMapper {

    public static void updateTicket(UpdateTicketRequest updateTicket, Ticket existingTicket) {
        existingTicket.setTitle(updateTicket.getTitle() != null ? updateTicket.getTitle() : existingTicket.getTitle());
        existingTicket.setDescription(updateTicket.getDescription() != null ? updateTicket.getDescription() : existingTicket.getDescription());
        existingTicket.setContact(updateTicket.getContact() != null ? updateTicket.getContact() : existingTicket.getContact());
        existingTicket.setInformation(updateTicket.getInformation() != null ? updateTicket.getInformation() : existingTicket.getInformation());
        existingTicket.setStatus(updateTicket.getStatus() != null ? updateTicket.getStatus() : existingTicket.getStatus());
    }
}