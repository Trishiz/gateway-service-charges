package zw.co.nbs.gatewayservicecharges.business.Impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import zw.co.nbs.gatewayservicecharges.Connection.api.gatewayDbConn;
import zw.co.nbs.gatewayservicecharges.business.api.ChargesService;
import zw.co.nbs.gatewayservicecharges.model.Charge;
import zw.co.nbs.gatewayservicecharges.repository.ChargeRepository;
import zw.co.nbs.gatewayservicecharges.response.ChargeResponse;
import zw.co.nbs.utils.common.dto.Response;
import java.util.List;

import java.util.Optional;
public class ChargesServiceImpl implements ChargesService {
    private final ChargeRepository chargeRepository;
    private final gatewayDbConn   gatewayDbCon;
    public ChargesServiceImpl(ApplicationContext context) {
        this.chargeRepository =context.getBean(ChargeRepository.class);
        this.gatewayDbCon=context.getBean(gatewayDbConn.class);
    }
    @Override
    public Response<Charge> addCharge(Charge dto) {
        Charge charge = new Charge();
        charge.setAdviceDebitCode(dto.getAdviceDebitCode());
        charge.setAdviceCreditCode(dto.getAdviceCreditCode());
        charge.setDebitCode(dto.getDebitCode());
        charge.setCreditCode(dto.getCreditCode());
        charge.setDescription(dto.getDescription());
        charge.setCurrencyMnemonic(dto.getCurrencyMnemonic());
        charge.setReversalCreditCode(dto.getReversalCreditCode());
        charge.setReversalDebitCode(dto.getReversalDebitCode());
        charge.setValue(dto.getValue());
        charge.setMaximum(dto.getMaximum());
        charge.setMinimum(dto.getMinimum());
        charge.setTransactionalLimit(dto.getTransactionalLimit());
        Charge response = chargeRepository.save(charge);
        return new Response<Charge>().buildSuccessResponse(response);

    }
    @Override
    public Response<Charge> editCharge(ChargeResponse obj, String chargeId, String id) {
         Logger logger = LoggerFactory.getLogger(getClass());
         logger.debug(" Edit Charge with chargeId: {}", chargeId);
         Optional<Charge> charges = chargeRepository.findById(chargeId);

        if (charges.isPresent()) {
            Charge charge = charges.get();
            logger.debug("Found charge: {}", charge);
            Charge response = chargeRepository.save(charge);
            return new Response<Charge>().buildSuccessResponse(response);
        } else
        {
            logger.error("Charge not found with ID: {}", chargeId);
            throw new RuntimeException("Charge not found with ID: " + chargeId);
        }
    }

    public Response<List<Charge>> findAllCharges() {
        List<Charge> charges = chargeRepository.findAll();
        if (charges.isEmpty()) {
            return new Response<List<Charge>>().buildErrorResponse("Charges Not found");
        }
        return new Response<List<Charge>>().buildSuccessResponse(charges);
    }

    }


