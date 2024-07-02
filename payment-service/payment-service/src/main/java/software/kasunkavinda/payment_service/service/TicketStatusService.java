package software.kasunkavinda.payment_service.service;

import software.kasunkavinda.payment_service.dto.StatusDTO;

public interface TicketStatusService {

    boolean updateTicketStatus(StatusDTO statusDTO);
}
