package cl.icap.controlCinco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping("/controlnotas")
	public String getControl5() {
		return "controlnotas";
	}
}
