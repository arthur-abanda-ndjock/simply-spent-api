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

import io.swagger.model.Item;
import io.swagger.model.Orders;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-05-15T11:30:40.071880526Z[GMT]")
@RestController
public class ItemsApiController implements ItemsApi {

    private static final Logger log = LoggerFactory.getLogger(ItemsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ItemsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createItem(
            @Parameter(in = ParameterIn.DEFAULT, description = "Send the Item Object", required = true, schema = @Schema()) @Valid @RequestBody Item body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Item> getItemById(
            @Parameter(in = ParameterIn.PATH, description = "The id of the item to retrieve", required = true, schema = @Schema()) @PathVariable("itemId") String itemId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Item>(objectMapper.readValue(
                        "{\n  \"price\" : 1,\n  \"name\" : \"name\",\n  \"description\" : \"description\",\n  \"id\" : 6,\n  \"type\" : \"HARDWARE\"\n}",
                        Item.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Item>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Item>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Orders> listItems(
            @Parameter(in = ParameterIn.QUERY, description = "type of the item HARDWARE,SOFTWARE,STATIONARY,TRAINING,MISC", schema = @Schema(allowableValues = {
                    "HARDWARE", "SOFTWARE", "STATIONARY", "TRAINING",
                    "MISC" })) @Valid @RequestParam(value = "type", required = false) String type,
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

}
