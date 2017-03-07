package com.spring.hitss.api.operations.controller;

import com.spring.hitss.api.operations.dto.operation.OperationDto;
import com.spring.hitss.api.operations.dto.operation.SearchEngineRequestDto;
import com.spring.hitss.api.operations.service.OperationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HItss on 03/01/2017.
 */
@RestController
public class OperationController {

    private static Logger logger = Logger.getLogger(OperationController.class);

    @Autowired
    OperationService operationService;

    @RequestMapping(value = "/api/search", method = RequestMethod.POST, headers = "Accept=application/json", consumes = {MediaType.ALL_VALUE})
    public ResponseEntity<List<List<OperationDto>>> searchEngine(@RequestBody SearchEngineRequestDto searchEngineRequestDto) {
        logger.info(searchEngineRequestDto);
        return new ResponseEntity<List<List<OperationDto>>>(operationService.delegateSearch(searchEngineRequestDto), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/operation/", method = RequestMethod.POST, headers = "Accept=application/json", consumes = {MediaType.ALL_VALUE})
    public ResponseEntity<List<OperationDto>> searchOperation(@RequestBody SearchEngineRequestDto searchEngineRequestDto) {
        logger.info(searchEngineRequestDto);
        List<OperationDto> operationDtoList = new ArrayList<>();
        return new ResponseEntity<List<OperationDto>>(operationDtoList, HttpStatus.OK);
    }

}
