package com.assignment.ticketmanagement.repository;

import com.assignment.ticketmanagement.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t WHERE " +
           "(UPPER(t.title) LIKE CONCAT('%', UPPER(:title), '%') OR :title IS NULL) AND " +
           "(UPPER(t.description) LIKE CONCAT('%', UPPER(:description), '%') OR :description IS NULL) AND " +
           "(UPPER(t.contact) LIKE CONCAT('%', UPPER(:contact), '%') OR :contact IS NULL) AND " +
           "(UPPER(t.information) LIKE CONCAT('%', UPPER(:information), '%') OR :information IS NULL) AND" +
           "(UPPER(t.status) LIKE CONCAT('%', UPPER(:status), '%') OR :status IS NULL)")
    Page<Ticket> findAllByCriteria(@Param("title") String title,
                                   @Param("description") String description,
                                   @Param("contact") String contact,
                                   @Param("information") String information,
                                   @Param("status") String status,
                                   Pageable pageable);


}