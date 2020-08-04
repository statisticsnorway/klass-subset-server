package no.ssb.subsetserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.ssb.subsetserver.domain.Subset;
import no.ssb.subsetserver.domain.*;
import no.ssb.subsetserver.repository.SubsetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class Controller {

    @Autowired
    SubsetRepository repository;

    private static final String HTTP = "https://data.ssb.no/api/klass/v1/classifications";
    private static Controller instance;


    static final String LDS_PROD = "https://lds-klass.staging-bip-app.ssb.no/ns/ClassificationSubset/";
    static final String LDS_LOCAL = "http://localhost:9090/ns/ClassificationSubset";
    private static String LDS_SUBSET_API = "";

    private static String KLASS_CLASSIFICATIONS_API = "https://data.ssb.no/api/klass/v1/classifications";

    private static final boolean prod = true;

    public  Controller(){
        instance = this;
        updateLDSURL();
    }

    public static Controller getInstance(){
        return instance;
    }

    private void updateLDSURL(){
        if (prod){
            LDS_SUBSET_API = System.getenv().getOrDefault("API_LDS", LDS_PROD);
        } else {
            LDS_SUBSET_API = LDS_LOCAL;
        }
        KLASS_CLASSIFICATIONS_API = System.getenv().getOrDefault("API_KLASS", KLASS_CLASSIFICATIONS_API);
    }

    /*
    @GetMapping("/v1/subsets")
    public ResponseEntity<Subset> getSubsets() {
        LDSconsumer consumer = new LDSconsumer(LDS_SUBSET_API);
        return consumer.getFrom("");
    }

     */


/*
    @GetMapping("/v1/subsets/{id}")
    public List<Subset> getId(){

    }

 */



    @GetMapping("/v1/subsets/{id}")
    public Subset getSubsets(@PathVariable String id) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        List<SubsetDAO> subsetDAOS = repository.findBySubsetIdOrderByVersionDesc(id);
        Subset subset = objectMapper.readValue(subsetDAOS.get(0).getJsonContent(), Subset.class); //finne løsning på nullpointerexception


        return subset;

    }



    @PostMapping("v1/subsets")
    public Subset postEndepoint1(@RequestBody Subset foresporsell) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonValue = objectMapper.writeValueAsString(foresporsell);

        repository.save(SubsetDAO.builder()
                .subsetId(foresporsell.getId())
                .version(foresporsell.getVersion())
                .jsonContent(jsonValue)
                .build());
        return foresporsell;

    }


}
