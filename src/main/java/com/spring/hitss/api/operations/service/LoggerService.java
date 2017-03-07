package com.spring.hitss.api.operations.service;

import com.spring.hitss.api.operations.dao.UserDao;
import com.spring.hitss.api.operations.dto.user.UserDto;
import com.spring.hitss.api.operations.facade.AuthenticationFacade;
import com.spring.hitss.api.operations.dao.LogDao;
import com.spring.hitss.api.operations.dto.log.LogDto;
import com.spring.hitss.api.operations.security.OAuth2SecurityConfiguration;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by HItss on 20/01/2017.
 */
@Service("LoggerService")
public class LoggerService {

    private static Logger logger = Logger.getLogger(LoggerService.class);

    @Autowired
    private LogDao logDao;

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    private UserDao userDao;

    @Autowired
    TokenStore tokenStore;

    public void saveActivity(String module, String detail) {
        UserDto userDto = userDao.findByName(authenticationFacade.getAuthentication().getName());
        LogDto logDto = new LogDto(userDto.getId(), module, detail, new Date(), tokenStore.getAccessToken((OAuth2Authentication) authenticationFacade.getAuthentication()).toString(), userDto.getName() + " " + userDto.getLastname());
        logDao.save(logDto);
    }

    public void saveActivity(String module, String detail, UserDto userDto) {
        LogDto logDto = new LogDto(userDto.getId(), module, detail, new Date(), "Oauth2 login", userDto.getName() + " " + userDto.getLastname());
        logDao.save(logDto);
    }

    public List<LogDto> getActivityById(String id) {
        return logDao.findById(id);
    }
}
