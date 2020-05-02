package com.leito.talentresourceplanning.controller;

import com.leito.talentresourceplanning.controller.util.Mappings;
import com.leito.talentresourceplanning.request.user.CreateUserRequest;
import com.leito.talentresourceplanning.response.user.CreateUserResponse;
import com.leito.talentresourceplanning.response.user.DetailUserResponse;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import com.leito.talentresourceplanning.entity.User;
import com.leito.talentresourceplanning.service.UserService;

@Api(value = "User Controller")
@RestController
@RequestMapping(Mappings.USERS)
public class UserController extends CrudController<User, CreateUserRequest, CreateUserResponse, DetailUserResponse> {

    UserService service;

    public UserController(UserService service) {
        super(new User(), service, new CreateUserResponse(), new DetailUserResponse());
        this.service = service;
    }
}
