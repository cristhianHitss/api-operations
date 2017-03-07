package com.spring.hitss.api.operations.dao;

import com.spring.hitss.api.operations.dto.proyect.ProyectDto;

import java.util.List;

/**
 * Created by HItss on 08/02/2017.
 */
public interface ReworkDao {
    
     List<ProyectDto> getAllReworkProyects();
}
