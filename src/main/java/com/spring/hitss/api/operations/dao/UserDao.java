package com.spring.hitss.api.operations.dao;

import com.spring.hitss.api.operations.dto.user.UserDto;

import java.util.List;

/**
 * Created by HItss on 22/12/2016.
 */
public interface UserDao {

    UserDto findById(String id);

    UserDto findByName(String name);

    void save(UserDto user);

    void update(UserDto user);

    void delete(UserDto user);

    List<UserDto> findAllUsers();

    public boolean isUserExist(UserDto user);
}
