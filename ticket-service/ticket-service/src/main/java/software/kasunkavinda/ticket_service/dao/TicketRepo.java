package software.kasunkavinda.ticket_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import software.kasunkavinda.ticket_service.entity.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,String> {
}
