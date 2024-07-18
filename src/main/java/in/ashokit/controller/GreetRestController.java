
package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.client.WelcomeApiClient;

@RestController
public class GreetRestController {

	@Autowired
	private WelcomeApiClient welcomeClient;
	
	@Autowired
	private Environment env;
	

	@GetMapping("/greet")
	public String getGreetMsg() {

		String welcomeResp = welcomeClient.invokeWelcomeMsg();
		
		String port = env.getProperty("server.port");
		
		String greetResp = "GoodMorning("  +(port)+ ")";
		
		return welcomeResp + greetResp;
		
	}
}
