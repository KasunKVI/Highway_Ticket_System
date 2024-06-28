package software.kasunkavinda.vehicle_service.service;

import software.kasunkavinda.vehicle_service.dto.VehicleDTO;

public interface VehicleService {
    String newVehicle(VehicleDTO vehicleDTO);
    void deleteVehicle(String id);
    VehicleDTO getVehicle(String id);
    String updateVehicle(VehicleDTO vehicleDTO);
}
