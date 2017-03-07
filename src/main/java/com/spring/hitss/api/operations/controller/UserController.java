package com.spring.hitss.api.operations.controller;

import java.util.List;

import com.spring.hitss.api.operations.dao.UserDao;
import com.spring.hitss.api.operations.dto.log.LogDto;
import com.spring.hitss.api.operations.dto.user.UserDto;
import com.spring.hitss.api.operations.service.LoggerService;
import com.spring.hitss.api.operations.util.Utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    UserDao userDao;

    @Autowired
    private LoggerService loggerService;

    @RequestMapping(value = "/api/user/", method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> listAllUsers() {
        List<UserDto> users = userDao.findAllUsers();
        loggerService.saveActivity(Utils.USER_MODULE, Utils.LOAD_USERS);
        return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/user/{username}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserDto> getUser(@PathVariable("username") String username) {
        UserDto user = userDao.findByName(username);
        logger.info(user);
        if (user == null) {
            loggerService.saveActivity(Utils.USER_MODULE, "Error en la carga de detalle del usuario " + username);
            return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
        }
        loggerService.saveActivity(Utils.USER_MODULE, "Carga de detalle del usuario " + username);
        return new ResponseEntity<UserDto>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/user/", method = RequestMethod.POST, headers = "Accept=application/json", consumes = {MediaType.ALL_VALUE})
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto, UriComponentsBuilder ucBuilder) {
        userDto.setPrivileges("ROLE_ADMIN");
        if (userDto.getUsertype() == 1) {
            userDto.setUsertypedetail("Administrador");
        } else if (userDto.getUsertype() == 2) {
            userDto.setUsertypedetail("Operacion");
        } else if (userDto.getUsertype() == 3) {
            userDto.setUsertypedetail("Visitante");
        }
        if (userDao.isUserExist(userDto)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        userDao.save(userDto);
        loggerService.saveActivity(Utils.USER_MODULE, "Creacion del nuevo usuario " + userDto.getUsername());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(userDto.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") String id, @RequestBody UserDto user) {
        if (user.getUsertype() == 1) {
            user.setUsertypedetail("Administrador");
        } else if (user.getUsertype() == 2) {
            user.setUsertypedetail("Operacion");
        } else if (user.getUsertype() == 3) {
            user.setUsertypedetail("Visitante");
        }
        UserDto currentUser = userDao.findById(id);

        if (currentUser == null) {
            loggerService.saveActivity(Utils.USER_MODULE, "Intento actualizar un usuario pero no se encontro, el usuario fue " + user.getUsername());
            return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
        } else if (!currentUser.getUsername().equalsIgnoreCase(user.getUsername())) {
            if (userDao.isUserExist(user)) {
                loggerService.saveActivity("Usuarios", "Intento actualizar un usuario que ya existe, el usuario fue " + user.getUsername());
                return new ResponseEntity<UserDto>(HttpStatus.CONFLICT);
            }
        }
        userDao.update(user);
        loggerService.saveActivity(Utils.USER_MODULE, "Actualizacion del usuario " + user.getUsername());
        return new ResponseEntity<UserDto>(currentUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserDto> deleteUser(@PathVariable("id") String id) {
        UserDto user = userDao.findById(id);
        if (user == null) {
            loggerService.saveActivity(Utils.USER_MODULE, "Intento borrar un usuario pero no se encontro, el usuario fue " + user.getUsername());
            return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
        }
        userDao.delete(user);
        loggerService.saveActivity(Utils.USER_MODULE, "Borro el usuario " + user.getUsername());
        return new ResponseEntity<UserDto>(HttpStatus.OK);
    }

    @RequestMapping(path = "/api/user/activity/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<LogDto>> getUserActivity(@PathVariable("id") String id) {
        return new ResponseEntity<List<LogDto>>(loggerService.getActivityById(id), HttpStatus.OK);
    }

}
