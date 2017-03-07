package com.spring.hitss.api.operations.controller;

import com.spring.hitss.api.operations.dao.RiskDao;
import com.spring.hitss.api.operations.dto.proyect.ProyectDto;
import com.spring.hitss.api.operations.dto.risk.HistoricalModificationsDto;
import com.spring.hitss.api.operations.dto.risk.RiskDependeciesDto;
import com.spring.hitss.api.operations.dto.risk.RiskDto;
import com.spring.hitss.api.operations.service.LoggerService;
import com.spring.hitss.api.operations.service.RiskService;
import com.spring.hitss.api.operations.util.Utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by HItss on 09/01/2017.
 */
@RestController
public class RiskController {

    private static Logger logger = Logger.getLogger(RiskController.class);

    @Autowired
    private RiskDao riskDao;

    @Autowired
    private LoggerService loggerService;

    @Autowired
    private RiskService riskService;

    @RequestMapping(path = "/api/risk", method = RequestMethod.GET)
    public ResponseEntity<List<ProyectDto>> index() {
        loggerService.saveActivity(Utils.RISK_MODULE, Utils.LOAD_RIKS);
        return new ResponseEntity<List<ProyectDto>>(riskDao.getAllRiskProyect(), HttpStatus.OK);
    }

    @RequestMapping(path = "/api/risk/dependencies", method = RequestMethod.GET)
    public ResponseEntity<RiskDependeciesDto> getRiskDependecies() {
        return new ResponseEntity<RiskDependeciesDto>(riskDao.getRiskDependencies(), HttpStatus.OK);
    }

            @RequestMapping(path = "/api/risk/historic/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<HistoricalModificationsDto>> getRiskHistorical(@PathVariable("id") String id) {
        return new ResponseEntity<List<HistoricalModificationsDto>>(riskDao.getAllHistoricById(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/api/risk", method = RequestMethod.POST, headers = "Accept=application/json", consumes = {MediaType.ALL_VALUE})
    public ResponseEntity<Void> createRisk(@RequestBody RiskDto riskDto) {
        riskDto.setDetection_Date(new Date());
        logger.info(riskDto);
        loggerService.saveActivity(Utils.RISK_MODULE, Utils.CREATE_NEW_RISK);
        riskDto.getCommentRisk().add(riskService.getComment(null));
        riskDao.save(riskDto);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/api/risk/{id}", method = RequestMethod.PUT, headers = "Accept=application/json", consumes = {MediaType.ALL_VALUE})
    public ResponseEntity<Void> updateRisk(@PathVariable("id") String id, @RequestBody RiskDto riskDto) {
        RiskDto riskDtodb = riskDao.findById(id);
        if (riskDtodb == null) {
            loggerService.saveActivity(Utils.RISK_MODULE, "Ocurrio un error en la carga de detalle del riesgo " + id);
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        riskDao.saveHistorical(riskService.CheckChangesFields(riskDtodb, riskDto, riskDto));
        riskDto.getCommentRisk().add(riskService.getComment(riskDto.getTmp_comment()));
        riskDao.update(riskDto);
        loggerService.saveActivity(Utils.USER_MODULE, "Actualizacion del riesgo " + id);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/api/risk/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ProyectDto> getProyectRisks(@PathVariable("id") String Id) {
        ProyectDto proyectDto = riskDao.findProyectRisksById(Id);
        if (proyectDto == null) {
            loggerService.saveActivity(Utils.RISK_MODULE, "Error en la carga de detalle del riesgo " + Id);
            return new ResponseEntity<ProyectDto>(HttpStatus.NOT_FOUND);
        }
        loggerService.saveActivity(Utils.RISK_MODULE, "Carga de detalle del riesgo " + Id);
        return new ResponseEntity<ProyectDto>(proyectDto, HttpStatus.OK);
    }
}
