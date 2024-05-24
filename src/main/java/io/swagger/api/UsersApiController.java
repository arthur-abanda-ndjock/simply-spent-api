package io.swagger.api;

import java.io.IOException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.exceptions.ModelValidationException;
import io.swagger.model.User;
import io.swagger.model.Users;
import io.swagger.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-05-15T11:30:40.071880526Z[GMT]")
@RestController
public class UsersApiController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

    private final ObjectMapper objectMapper;

    @Autowired
    private UserService userService;

    @Autowired
    public UsersApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<Void> createUser(
            @Parameter(in = ParameterIn.DEFAULT, description = "Send the User Object", required = true, schema = @Schema()) @Valid @RequestBody User body) {
        userService.save(body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Users> listUsers(
            @Parameter(in = ParameterIn.QUERY, description = "How many items to return at one time (max 100)", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit) {

        Users users = new Users();
        for (User user : userService.findAll()) {
            users.add(user);
        }
        return new ResponseEntity<Users>(users, HttpStatus.OK);
    }

    public ResponseEntity<User> showUserById(
            @Parameter(in = ParameterIn.PATH, description = "The id of the user to retrieve", required = true, schema = @Schema()) @PathVariable("userId") String userId) {
        try {
            return new ResponseEntity<User>(objectMapper.readValue(
                    "{\n  \"firstName\" : \"firstName\",\n  \"lastName\" : \"lastName\",\n  \"password\" : \"password\",\n  \"role\" : \"MGR\",\n  \"address\" : \"address\",\n  \"phone\" : \"phone\",\n  \"emailId\" : \"emailId\",\n  \"id\" : 0,\n  \"tag\" : \"tag\",\n  \"managerName\" : \"managerName\",\n  \"age\" : 6\n}",
                    User.class), HttpStatus.NOT_IMPLEMENTED);
        } catch (IOException e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ExceptionHandler(ModelValidationException.class)
    public ResponseEntity<String> handleDetailedValidationExceptions(ModelValidationException ex) {
        return new ResponseEntity<String>("{error-msg: " + ex.getMessage() + "}", HttpStatusCode.valueOf(ex.getCode()));
    }

}
