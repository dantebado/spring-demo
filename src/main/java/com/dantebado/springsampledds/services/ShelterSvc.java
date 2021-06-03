package com.dantebado.springsampledds.services;

import com.dantebado.springsampledds.exceptions.GenericException;
import com.dantebado.springsampledds.model.ext.shelters.SheltersPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class ShelterSvc {

    static final String API_AUTHORIZATION = "WTkGRTX5g6vBQYnbIGC82lNJfzf0RvkeS19HrIGG6624LGTYP161jwFdM4tH";

    @Autowired
    ObjectMapper objectMapper;

    public SheltersPage findAll(int offset) {
        try {
            HttpResponse<InputStream> response = Unirest.get("https://api.refugiosdds.com.ar/api/hogares?offset=" + offset)
                    .header("Accept", "application/json")
                    .header("Authorization", "Bearer " + API_AUTHORIZATION)
                    .asBinary();

            return objectMapper.readValue(response.getBody(), SheltersPage.class);
        } catch (Exception e ){
            throw new GenericException(e.getMessage(), GenericException.ExceptionType.SHELTER_API_EXCEPTION);
        }
    }

}
