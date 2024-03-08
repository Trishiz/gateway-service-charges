package zw.co.nbs.gatewayservicecharges.business.api;
import org.springframework.http.ResponseEntity;
import zw.co.nbs.gatewayservicecharges.model.Charge;
import zw.co.nbs.gatewayservicecharges.response.ChargeResponse;
import zw.co.nbs.utils.common.dto.Response;

import java.util.List;

public interface ChargesService {

    Response<Charge> addCharge(Charge Id);

    Response<Charge> editCharge(ChargeResponse obj, String chargeId, String id);

    Response<List<Charge>> findAllCharges();


}
