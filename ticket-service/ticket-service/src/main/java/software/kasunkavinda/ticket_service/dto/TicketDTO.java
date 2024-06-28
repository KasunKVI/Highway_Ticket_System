package software.kasunkavinda.ticket_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TicketDTO {
    private String id;
    private String description;
    private String date;
    private String time;
    private String status;
    private String vehicleId;
    private String paymentId;
}
