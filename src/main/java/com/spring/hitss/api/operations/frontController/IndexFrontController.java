package com.spring.hitss.api.operations.frontController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by HItss on 20/12/2016.
 */

@Controller
@RequestMapping("/")
public class IndexFrontController {
    @RequestMapping(method = RequestMethod.GET)
    public String getIndexPage() {
        return "static/index";
    }
}