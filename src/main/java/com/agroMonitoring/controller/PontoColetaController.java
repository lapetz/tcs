package com.agroMonitoring.controller;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.agroMonitoring.model.PontoColeta;
import com.agroMonitoring.repository.PontoColetaRepository;

@Controller
public class PontoColetaController {
	
	private static final String KEY_VALUE = "QW5z489S4Az49WRFPLWklz";
	@Autowired
	private PontoColetaRepository pcRepo;
	
	@GetMapping("/setvalues")
	public String vem(@RequestParam(value = "key", defaultValue = "") String keyValue,
			@RequestParam(value = "t", defaultValue = "996") Integer vlTemperatura,
			@RequestParam(value = "ph", defaultValue = "997") Integer vlPh,
			@RequestParam(value = "ua", defaultValue = "998") Integer umidadeAr,
			@RequestParam(value = "us", defaultValue = "999") Integer umidadeSolo,
			@RequestParam(value = "i", defaultValue = "n_incendio") String ieIncendio,
			@RequestParam(value = "g", defaultValue = "g_invalid") String dsGeo) {
		
		
		
		if (KEY_VALUE.equals(keyValue)) {
			PontoColeta pontoColeta = new PontoColeta();
			pontoColeta.setVlTemperatura(vlTemperatura);
			pontoColeta.setVlPh(vlPh);
			pontoColeta.setUmidadeAr(umidadeAr);
			pontoColeta.setUmidadeSolo(umidadeSolo);
			pontoColeta.setIeIncendio(ieIncendio);
			pontoColeta.setDtAtualizacao(getLocalDate());
			pontoColeta.setDsGeoLocalizacao(dsGeo);
			
			pcRepo.save(pontoColeta);

			return "index";
		} else {
			return "FAIL";
		}

	}
	
	private Timestamp getLocalDate() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp;
	}
	
}
