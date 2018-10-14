package com.nf.client;

import com.nf.model.iconomi.DAADetails;
import com.nf.model.iconomi.DAAListResponse;
import com.nf.model.iconomi.DAAStructure;
import com.nf.model.iconomi.DaaList;
import com.nf.model.iconomi.Structure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class IconomiClient {

    @Autowired
    private RestTemplate restTemplate;

    public DAAListResponse geAllDAADetails()   {

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-agent", "SomeUserAgent");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        RestTemplate rt = new RestTemplate();
        DAAListResponse result = rt.exchange("https://api.iconomi.net/v1/daa", HttpMethod.GET, entity, DAAListResponse.class).getBody();
        return result;
    }

    public Structure getDAAStructure(String daaticker)   {

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-agent", "SomeUserAgent");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        RestTemplate rt = new RestTemplate();
        Structure result = rt.exchange("https://api.iconomi.net/v1/daa/{daaticker}/structure", HttpMethod.GET, entity, Structure.class, daaticker).getBody();
        return result;
    }



}
