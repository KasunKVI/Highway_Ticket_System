package software.kasunkavinda.vehicle_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import software.kasunkavinda.vehicle_service.entity.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, String> {
}
