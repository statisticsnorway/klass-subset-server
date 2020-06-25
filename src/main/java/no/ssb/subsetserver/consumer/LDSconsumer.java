package no.ssb.subsetserver.consumer;

import com.fasterxml.jackson.databind.JsonNode;
import no.ssb.subsetserver.domain.Subset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class LDSconsumer {

    private static final Logger LOG = LoggerFactory.getLogger(LDSconsumer.class);
    static String LDS_URL;

    public LDSconsumer (String ldsSubsetApi){
        LDS_URL = ldsSubsetApi;
    }

    ResponseEntity<Subset> getFrom(String additional) {
        try {
            ResponseEntity<Subset> response = new RestTemplate().getForEntity(LDS_URL + additional, Subset.class);
            return response;
        }catch (HttpClientErrorException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    ResponseEntity<Subset> postTo (String additional, Subset json){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Subset> request = new HttpEntity<>(json, headers);
        ResponseEntity<Subset> response = new RestTemplate().postForEntity(LDS_URL+additional, request, Subset.class);
        LOG.debug("POST to"+LDS_URL+additional+" - Status: " + response.getStatusCodeValue() + " " + response.getStatusCode().name());
        return response;
    }

    ResponseEntity<Subset> putTo(String additional, Subset json){
        return postTo(additional, json);
    }


}
