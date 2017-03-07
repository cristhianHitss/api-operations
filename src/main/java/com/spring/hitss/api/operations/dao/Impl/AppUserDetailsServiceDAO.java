package com.spring.hitss.api.operations.dao.Impl;

import java.util.Collection;
import java.util.List;

import com.spring.hitss.api.operations.dao.UserDao;
import com.spring.hitss.api.operations.dto.user.UserDto;
import com.spring.hitss.api.operations.service.LoggerService;
import com.spring.hitss.api.operations.util.Utils;
import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by HItss on 20/12/2016.
 */

public class AppUserDetailsServiceDAO implements UserDetailsService {

    private static Logger logger = Logger.getLogger(AppUserDetailsServiceDAO.class);

    private UserDao userDao;

    private LoggerService loggerService;

    public AppUserDetailsServiceDAO(UserDao userDao, LoggerService loggerService) {
        this.userDao = userDao;
        this.loggerService = loggerService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserDto user = userDao.findByName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        loggerService.saveActivity(Utils.LOGIN_MODULE, Utils.LOGIN, user);
        return new UserDetails() {

            private static final long serialVersionUID = 2059202961588104658L;

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public String getUsername() {
                return user.getUsername();
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
                auths.add(new SimpleGrantedAuthority(user.getPrivileges()));
                return auths;
            }
        };

    }

}
