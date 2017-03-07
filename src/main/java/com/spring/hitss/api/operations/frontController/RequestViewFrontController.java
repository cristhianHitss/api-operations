package com.spring.hitss.api.operations.frontController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by HItss on 20/12/2016.
 */
@Controller
public class RequestViewFrontController {

    @RequestMapping(value = "/login.view")
    public String getLoginView() {return "static/views/access/login.view";}

    @RequestMapping(value = "/main.view")
    public String getMainView() {return "static/views/main/main.view";}

    @RequestMapping(value = "/principal.view")
    public String getPrincipalView() {return "static/views/main/principal.view";}

    @RequestMapping(value = "/users.view")
    public String getUsersView() {return "static/views/users/users.view";}

    @RequestMapping(value = "/operation.search.view")
    public String getOperationFilterView() {return "static/views/operations/operation.search.view";}

    @RequestMapping(value = "/operation.view")
    public String getOperationView() {return "static/views/operations/operation.view";}

    @RequestMapping(value = "/risk.view")
    public String getRiskView() {return "static/views/risk/risk.view";}

    @RequestMapping(value = "/rework.view")
    public String getReworkView() {return "static/views/rework/rework.view";}

}


