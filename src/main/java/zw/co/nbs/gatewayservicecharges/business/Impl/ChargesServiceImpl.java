package zw.co.nbs.gatewayservicecharges.business.Impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import zw.co.nbs.gatewayservicecharges.Connection.api.gatewayDbConn;
import zw.co.nbs.gatewayservicecharges.business.api.ChargesService;
import zw.co.nbs.gatewayservicecharges.model.Charge;
import zw.co.nbs.gatewayservicecharges.repository.ChargeRepository;
import zw.co.nbs.gatewayservicecharges.response.ChargeResponse;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ChargesServiceImpl implements ChargesService {
    private final ChargeRepository chargeRepository;
    private final gatewayDbConn   gatewayDbCon;

    public ChargesServiceImpl(ApplicationContext context) {
        this.chargeRepository =context.getBean(ChargeRepository.class);
        this.gatewayDbCon=context.getBean(gatewayDbConn.class);
    }
    @Override
    public ResponseEntity<Charge> addCharge(Charge Id) {
        Charge savedCharge = chargeRepository.save(Id);
        return ResponseEntity.ok(savedCharge);
    }
    @Override
    public Response<Charge> editCharge(ChargeResponse obj, String chargeId, String id) {
         Logger logger = LoggerFactory.getLogger(getClass());
         logger.debug(" Edit Charge with chargeId: {}", chargeId);
         Optional<Charge> charges = chargeRepository.findById(chargeId);

        if (charges.isPresent()) {
            Charge charge = charges.get();
            logger.debug("Found charge: {}", charge);
            return (Response<Charge>) chargeRepository.save(charge);
        } else
        {
            logger.error("Charge not found with ID: {}", chargeId);
            throw new RuntimeException("Charge not found with ID: " + chargeId);
        }
    }

    public Response<List<Charge>> findAllCharges(String id) {
        List<Charge> charges = chargeRepository.findAllCharges(id);
        Response<List<Charge>> response = new Response<List<Charge>> () {
            @Override
            public boolean cancel(boolean b) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }
            @Override
            public boolean isDone() {
                return false;
            }
            @Override
            public List get() throws InterruptedException, ExecutionException {
                return null;
            }
            @Override
            public List get(long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }
            @Override
            public Map<String, Object> getContext() {
                return null;
            }
        };

        return response;
    }

    @Override
    public Response<Charge> findChargeById(String id) {
        Charge charge = chargeRepository.findById(id).orElse(null);
        Response<Charge> response = new Response<Charge>() {
            @Override
            public boolean cancel(boolean b) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public Charge get() throws InterruptedException, ExecutionException {
                return null;
            }

            @Override
            public Charge get(long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }

            @Override
            public Map<String, Object> getContext() {
                return null;
            }
        };

        return response;
    }
    }
