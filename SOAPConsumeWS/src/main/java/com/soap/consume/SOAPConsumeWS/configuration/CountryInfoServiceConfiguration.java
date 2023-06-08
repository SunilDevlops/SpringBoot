package com.soap.consume.SOAPConsumeWS.configuration;

import com.soap.consume.SOAPConsumeWS.service.CountryInfoServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountryInfoServiceConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.soap.consumingwebservice.wsdl");
        return marshaller;
    }

    @Bean
    public CountryInfoServiceClient countryInfoServiceClient(Jaxb2Marshaller marshaller) {
        CountryInfoServiceClient countryInfoClient = new CountryInfoServiceClient();
        countryInfoClient.setDefaultUri("http://localhost:8080/ws");
        countryInfoClient.setMarshaller(marshaller);
        countryInfoClient.setUnmarshaller(marshaller);
        return countryInfoClient;
    }
}
