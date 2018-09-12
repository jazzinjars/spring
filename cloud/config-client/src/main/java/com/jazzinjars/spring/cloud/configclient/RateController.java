package com.jazzinjars.spring.cloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RateController {

	@Value("${rate}")
	private String rateamount;
	@Value("${lanecount}")
	private String lanecount;
	@Value("${tollstart}")
	private String tollstart;

	@RequestMapping("/rate")
	public String getRate(Model model) {
		model.addAttribute("rateamount: ", rateamount);
		model.addAttribute("lanes: ", lanecount);
		model.addAttribute("tollstart: ", tollstart);

		//name of the view
		return "rateview";
	}
}
