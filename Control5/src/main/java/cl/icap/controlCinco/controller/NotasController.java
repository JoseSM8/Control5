package cl.icap.controlCinco.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cl.icap.controlCinco.model.dto.NotasDTO;
import cl.icap.controlCinco.service.NotasService;

@Controller
@RequestMapping(value="/notas")
public class NotasController {

	@Autowired
	private NotasService notasService;
	
	@RequestMapping(value="/list")
	public @ResponseBody List<NotasDTO> ajaxList(HttpServletRequest req, HttpServletResponse res) {
		return notasService.list();
	}
	
	@RequestMapping(value="/insert")
	public @ResponseBody int ajaxInsert(HttpServletRequest req, HttpServletResponse res) {
		int rows = 0;
		String requestData;
		try {
			requestData = req.getReader().lines().collect(Collectors.joining());
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			NotasDTO notasDTO = gson.fromJson(requestData, NotasDTO.class);
			rows = notasService.insert(notasDTO);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	@RequestMapping(value="/update")
	public @ResponseBody int ajaxUpdate(HttpServletRequest req, HttpServletResponse res) {
		int rows = 0;
		String requestData;
		try {
			requestData = req.getReader().lines().collect(Collectors.joining());
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			NotasDTO notasDTO = gson.fromJson(requestData, NotasDTO.class);
			rows = notasService.update(notasDTO);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	@RequestMapping(value="/delete")
	public @ResponseBody int ajaxDelete(HttpServletRequest req, HttpServletResponse res) {
		int rows = 0;
		String requestData;
		try {
			requestData = req.getReader().lines().collect(Collectors.joining());
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			NotasDTO notasDTO = gson.fromJson(requestData, NotasDTO.class);
			rows = notasService.delete(notasDTO.getRut(), notasDTO.getNumero_modulo(), notasDTO.getNumero_evaluacion());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
}











