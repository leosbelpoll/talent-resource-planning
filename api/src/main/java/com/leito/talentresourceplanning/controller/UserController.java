package com.leito.talentresourceplanning.controller;

import com.leito.talentresourceplanning.controller.util.Mappings;
import com.leito.talentresourceplanning.controller.util.StatusCodesMessages;
import com.leito.talentresourceplanning.request.user.CreateUserRequest;
import com.leito.talentresourceplanning.response.user.CreateUserResponse;
import com.leito.talentresourceplanning.response.user.GetUserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.leito.talentresourceplanning.entity.User;
import com.leito.talentresourceplanning.service.UserService;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@Api(value = "User Controller")
@RestController
@RequestMapping(Mappings.USERS)
public class UserController extends BaseController<User> {

    UserService service;

    public UserController(UserService service) {
        super(service);
        this.service = service;
    }

    @ApiOperation(value = "Get item", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = StatusCodesMessages.STATUS_CODE_200),
            @ApiResponse(code = 404, message = StatusCodesMessages.STATUS_CODE_404)
    })
    @GetMapping(Mappings.ID_PARAMETER)
    public ResponseEntity<GetUserResponse> get(@PathVariable("id") Long id) {
        try {
            User user = service.getById(id);
            return new ResponseEntity<>(new GetUserResponse(user), new HttpHeaders(), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @ApiOperation(value = "Create item", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = StatusCodesMessages.STATUS_CODE_200),
            @ApiResponse(code = 409, message = StatusCodesMessages.STATUS_CODE_409)
    })
    @PostMapping
    public ResponseEntity<CreateUserResponse> create(@RequestBody @Valid CreateUserRequest request) {
        try {
            User newUser = service.create(new User(request));
            return new ResponseEntity<>(new CreateUserResponse(newUser), new HttpHeaders(), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
