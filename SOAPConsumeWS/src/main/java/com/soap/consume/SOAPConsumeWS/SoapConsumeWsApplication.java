package com.soap.consume.SOAPConsumeWS;

import com.soap.consume.SOAPConsumeWS.service.CountryInfoServiceClient;
import com.soap.consumingwebservice.wsdl.CapitalCityResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapConsumeWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapConsumeWsApplication.class, args);
	}
	@Bean
	CommandLineRunner lookup(CountryInfoServiceClient quoteClient) {
		return args -> {
			String country = "AF";

			if (args.length > 0) {
				country = args[0];
			}
			CapitalCityResponse response = quoteClient.getCapitalCityResponse(country);
			System.err.println(response.getCapitalCityResult());
		};
	}
}
