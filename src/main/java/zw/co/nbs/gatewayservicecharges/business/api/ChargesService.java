package zw.co.nbs.gatewayservicecharges.business.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import zw.co.nbs.gatewayservicecharges.model.Charge;
import zw.co.nbs.gatewayservicecharges.response.ChargeResponse;

import javax.xml.ws.Response;
import java.util.List;

public interface ChargesService {

    ResponseEntity<Charge> addCharge(Charge Id);

    Response<Charge> editCharge(ChargeResponse obj, String chargeId, String id);

    Response<List<Charge>> findAllCharges(String id);

    Response<Charge> findChargeById(String id);

}
