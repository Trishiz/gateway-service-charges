package zw.co.nbs.gatewayservicecharges.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.nbs.gatewayservicecharges.model.Charge;

import java.util.List;

public interface ChargeRepository extends JpaRepository<Charge, String> {

    List<Charge> findAllCharges(String id);
}
