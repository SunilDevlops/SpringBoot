package com.soap.consume.SOAPConsumeWS.service;

import com.soap.consumingwebservice.wsdl.CapitalCity;
import com.soap.consumingwebservice.wsdl.CapitalCityResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
public class CountryInfoServiceClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(CountryInfoServiceClient.class);

    public CapitalCityResponse getCapitalCityResponse(String countryISOCode){
        CapitalCity request = new CapitalCity();
        request.setSCountryISOCode(countryISOCode);
        log.info("Requesting Capital City for " + countryISOCode);
        CapitalCityResponse response = (CapitalCityResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL"
                        , request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

        return response;
    }
}
