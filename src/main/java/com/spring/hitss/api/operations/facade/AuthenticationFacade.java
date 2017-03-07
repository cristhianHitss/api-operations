package com.spring.hitss.api.operations.facade;

import org.springframework.security.core.Authentication;

/**
 * Created by HItss on 20/01/2017.
 */
public interface AuthenticationFacade {
    Authentication getAuthentication();
}
