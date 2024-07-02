package software.kasunkavinda.vehicle_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VehicleDTO {
    private String id;
    private String type;
    private String userId;
}