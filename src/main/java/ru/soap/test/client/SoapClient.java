package ru.soap.test.client;


import jaxb.generated.GetCountryRequest;
import jaxb.generated.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Repository;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * Created by rakhmetov on 05.12.16.
 */
@Repository
public class SoapClient extends WebServiceGatewaySupport {

    @Autowired
    public SoapClient(Jaxb2Marshaller marshaller) {
        setDefaultUri("http://localhost:8080/ws");
        setMarshaller(marshaller);
        setUnmarshaller(marshaller);
    }

    public GetCountryResponse getResponse(String name) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(name);

        return (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://localhost:8080/ws/countries.wsdl",
                        request,
                        new SoapActionCallback("http://localhost:8080/ws"));
    }
}
