package io.swagger.api;

import java.io.IOException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.Order;
import io.swagger.model.Orders;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-05-15T11:30:40.071880526Z[GMT]")
@RestController
public class OrdersApiController implements OrdersApi {

    private static final Logger log = LoggerFactory.getLogger(OrdersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OrdersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Boolean> approveOrders(
            @Parameter(in = ParameterIn.PATH, description = "The id of the order to retrieve", required = true, schema = @Schema()) @PathVariable("orderId") String orderId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Boolean>(objectMapper.readValue("false", Boolean.class),
                        HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Boolean>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Orders> listOrders(
            @Parameter(in = ParameterIn.QUERY, description = "status of the order REQUESTED,APPROVED,DENIED", schema = @Schema(allowableValues = {
                    "REQUESTED", "APPROVED",
                    "DENIED" })) @Valid @RequestParam(value = "status", required = false) String status,
            @Parameter(in = ParameterIn.QUERY, description = "if true returns orders of reportees by name for approval", schema = @Schema()) @Valid @RequestParam(value = "reportee", required = false) String reportee,
            @Parameter(in = ParameterIn.QUERY, description = "How many items to return at one time (max 100)", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Orders>(objectMapper.readValue(
                        "[ {\n  \"reason\" : \"reason\",\n  \"comment\" : \"comment\",\n  \"id\" : 0,\n  \"items\" : [ {\n    \"price\" : 1,\n    \"name\" : \"name\",\n    \"description\" : \"description\",\n    \"id\" : 6,\n    \"type\" : \"HARDWARE\"\n  }, {\n    \"price\" : 1,\n    \"name\" : \"name\",\n    \"description\" : \"description\",\n    \"id\" : 6,\n    \"type\" : \"HARDWARE\"\n  } ],\n  \"status\" : \"REQUESTED\"\n}, {\n  \"reason\" : \"reason\",\n  \"comment\" : \"comment\",\n  \"id\" : 0,\n  \"items\" : [ {\n    \"price\" : 1,\n    \"name\" : \"name\",\n    \"description\" : \"description\",\n    \"id\" : 6,\n    \"type\" : \"HARDWARE\"\n  }, {\n    \"price\" : 1,\n    \"name\" : \"name\",\n    \"description\" : \"description\",\n    \"id\" : 6,\n    \"type\" : \"HARDWARE\"\n  } ],\n  \"status\" : \"REQUESTED\"\n} ]",
                        Orders.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Orders>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Orders>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> requestOrder(
            @Parameter(in = ParameterIn.DEFAULT, description = "Send the Order Object", required = true, schema = @Schema()) @Valid @RequestBody Order body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Order> showOrderById(
            @Parameter(in = ParameterIn.PATH, description = "The id of the order to retrieve", required = true, schema = @Schema()) @PathVariable("orderId") String orderId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Order>(objectMapper.readValue(
                        "{\n  \"reason\" : \"reason\",\n  \"comment\" : \"comment\",\n  \"id\" : 0,\n  \"items\" : [ {\n    \"price\" : 1,\n    \"name\" : \"name\",\n    \"description\" : \"description\",\n    \"id\" : 6,\n    \"type\" : \"HARDWARE\"\n  }, {\n    \"price\" : 1,\n    \"name\" : \"name\",\n    \"description\" : \"description\",\n    \"id\" : 6,\n    \"type\" : \"HARDWARE\"\n  } ],\n  \"status\" : \"REQUESTED\"\n}",
                        Order.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Order>(HttpStatus.NOT_IMPLEMENTED);
    }

}
