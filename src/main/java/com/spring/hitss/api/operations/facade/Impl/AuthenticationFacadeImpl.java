package com.spring.hitss.api.operations.facade.Impl;

import com.spring.hitss.api.operations.facade.AuthenticationFacade;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by HItss on 20/01/2017.
 */
@Service("UserInformationFacade")
public class AuthenticationFacadeImpl implements AuthenticationFacade {

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
