package com.agroMonitoring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroMonitoring.model.PontoColeta;


public interface PontoColetaRepository extends JpaRepository<PontoColeta, Long> {
	
	@Query(nativeQuery = true, value="select *, 	avg(vl_temperatura), " +
		" avg(vl_ph), 			" 	+
        " avg(umidade_ar), 		" 	+
        " avg(umidade_solo)		" 	+
        " from 	valor_coletado 	" 	+
        " where	DATE_FORMAT(DATE_SUB(sysdate(),INTERVAL :dsDia DAY),'%d/%m/%Y')  = DATE_FORMAT(dt_atualizacao,'%d/%m/%Y');")
	public List<PontoColeta> 
	   obterMediaDia(@Param("dsDia") int qtDia);
}
