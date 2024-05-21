package com.assignment.ticketmanagement.api;

import com.assignment.ticketmanagement.dto.UpdateTicketRequest;
import com.assignment.ticketmanagement.model.Ticket;
import com.assignment.ticketmanagement.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@Valid @RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.createTicket(ticket);
        return ResponseEntity.ok(createdTicket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @Valid @RequestBody UpdateTicketRequest updateTicket) {
        Ticket updatedTicket = ticketService.updateTicket(id, updateTicket);
        return ResponseEntity.ok(updatedTicket);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Ticket>> getAllTickets(
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String description,
        @RequestParam(required = false) String contact,
        @RequestParam(required = false) String information,
        @RequestParam(required = false) String status,
        @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC, size = 10) Pageable pageable) {
        Page<Ticket> tickets = ticketService.getAllTickets(title, description, contact, information, status, pageable);
    return ResponseEntity.ok(tickets);
}
}