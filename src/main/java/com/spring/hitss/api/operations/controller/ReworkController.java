package com.spring.hitss.api.operations.controller;

import com.spring.hitss.api.operations.dao.ReworkDao;
import com.spring.hitss.api.operations.dto.proyect.ProyectDto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by HItss on 08/02/2017.
 */
@RestController
public class ReworkController {

    private static Logger logger = Logger.getLogger(ReworkController.class);

    @Autowired
    private ReworkDao reworkDao;

    @RequestMapping(path = "/api/rework", method = RequestMethod.GET)
    public ResponseEntity<List<ProyectDto>> index() {
        return new ResponseEntity<List<ProyectDto>>(reworkDao.getAllReworkProyects(), HttpStatus.OK);
    }
}
