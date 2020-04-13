package com.leito.talentresourceplanning.controller;

import java.util.List;

import com.leito.talentresourceplanning.request.user.CreateUserRequest;
import com.leito.talentresourceplanning.response.user.CreateUserResponse;
import com.leito.talentresourceplanning.response.user.GetUserResponse;
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

@RestController
@RequestMapping(Mappings.USERS)
public class UserController extends BaseController<User> {

    UserService service;

    public UserController(UserService service) {
        super(service);
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> list = service.getAll();
        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(Mappings.ID_PARAMETER)
    public ResponseEntity<GetUserResponse> getUserById(@PathVariable("id") Long id) {
        try {
            User user = service.getById(id);
            return new ResponseEntity<>(new GetUserResponse(user), new HttpHeaders(), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> create(@RequestBody @Valid CreateUserRequest request) {
        try {
            User newUser = service.create(new User(request));
            return new ResponseEntity<>(new CreateUserResponse(newUser), new HttpHeaders(), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "User already exists", e);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }


}
