package com.assignment.ticketmanagement.service;

import com.assignment.ticketmanagement.api.TicketNotFoundException;
import com.assignment.ticketmanagement.dto.UpdateTicketRequest;
import com.assignment.ticketmanagement.model.Ticket;
import com.assignment.ticketmanagement.model.TicketStatus;
import com.assignment.ticketmanagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.Valid;


@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket createTicket(@Valid Ticket ticket) {
        ticket.setStatus(TicketStatus.PENDING); // Set initial status
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, @Valid UpdateTicketRequest updateTicket) {
        Ticket existingTicket = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException("Ticket not found with id: " + id));

        TicketMapper.updateTicket(updateTicket, existingTicket);

        return ticketRepository.save(existingTicket);
    }

     public Page<Ticket> getAllTickets(String title, String description, String contact, String information, String status, Pageable pageable) {
            return ticketRepository.findAllByCriteria(
                    title, description, contact, information, status, pageable);
    }
}