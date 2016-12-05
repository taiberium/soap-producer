package ru.soap.test.client;


import hello.wsdl.GetCountryRequest;
import hello.wsdl.GetCountryResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * Created by rakhmetov on 05.12.16.
 */
public class SoapClient extends WebServiceGatewaySupport {

    public GetCountryResponse getResponse(String name) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(name);

        return (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://localhost:8080/ws/countries.wsdl",
                        request,
                        new SoapActionCallback("http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP"));
    }
}
