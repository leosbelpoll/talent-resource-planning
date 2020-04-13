package com.leito.talentresourceplanning.service;

import com.leito.talentresourceplanning.entity.User;
import com.leito.talentresourceplanning.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User>{

    UserRepository repository;

    public UserService(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
