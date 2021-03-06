package com.coderhouse.service.impl;

import com.coderhouse.builder.UserBuilder;
import com.coderhouse.model.UserFactory;
import com.coderhouse.model.request.UserRequest;
import com.coderhouse.model.response.UserResponse;
import com.coderhouse.repository.UserRepository;
import com.coderhouse.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserFactory userFactory = new UserFactory();

    @Override
    public UserResponse create(UserRequest request) {
        var document= userFactory.createUser(request);
        var documentSaved = repository.save(document);
        return UserBuilder.docToResponseCreate(documentSaved);
    }

    @Override
    public UserResponse update(String id, UserRequest request) {
        var document= userFactory.createUser(request);
        document.setId(id);
        var entitySaved = repository.save(document);
        return UserBuilder.docToResponseCreate(entitySaved);
    }

    @Override
    public List<UserResponse> searchAll() {
        return UserBuilder.listDocToResponse(repository.findAll());
    }
}
