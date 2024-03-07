package zw.co.nbs.gatewayservicecharges.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.nbs.gatewayservicecharges.business.api.ChargesService;
import zw.co.nbs.gatewayservicecharges.model.Charge;
import zw.co.nbs.gatewayservicecharges.repository.ChargeRepository;
import zw.co.nbs.gatewayservicecharges.response.ChargeResponse;

import javax.xml.ws.Response;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api", headers = "Accept=application/json")
@Api(value = "/api", tags = {"Gateway Service Charges"}, consumes = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@CrossOrigin
public class RequestController {
    @Autowired
    ChargeRepository chargeRepository;

    ChargesService chargesService;
    private Charge id;

    @PostMapping(value = {"/add"})
    @Operation(summary = "New Charge", description = "New Charge", method = "addNewCharge", tags = {""})
    public ResponseEntity<Charge> addCharge(@RequestBody final ChargeResponse obj,
                                             @RequestHeader(value = HttpHeaders.AUTHORIZATION) final String jwt) {
        return chargesService.addCharge(id);
    }


    @GetMapping(value = {"/charges/find-charge/{id}"})
    @ApiOperation(notes = "find charge", value = "Find charges",
            nickname = "findCharge")
    public Response<Charge> findChargebyId(@PathVariable("id") final String id) throws IOException {
        log.info("Process Request ");
        return chargesService.findChargeById(id);
    }

    @PutMapping(value = {"/{id}"})
    @Operation(summary = "edit charge", description = "Edit Charge", method = "editCharge", tags = {""})
    public Response<Charge> editCharge(@PathVariable("id") final String id, @RequestBody final ChargeResponse obj,
                                         @RequestHeader(value = HttpHeaders.AUTHORIZATION) final String jwt) {
        return chargesService.editCharge(obj,jwt ,id);
    }







}
