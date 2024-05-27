package ambulance.providers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ambulance.providers.entity.AmbulanceProvider;

public interface AmbulanceProviderRepository extends JpaRepository<AmbulanceProvider, Long> {
}
