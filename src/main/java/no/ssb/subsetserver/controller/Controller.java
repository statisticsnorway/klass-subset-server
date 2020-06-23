package no.ssb.subsetserver.controller;

import no.ssb.subsetserver.domain.Subset;
import no.ssb.subsetserver.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private static final String HTTP = "https://data.ssb.no/api/klass/v1/classifications";


    @GetMapping("/subset")
    public Subset getTest1(){
        List<String> values = List.of(HTTP + "/68/codesAt.json?date=2020-03-18", HTTP+"/131/codesAt.json?date=2020-03-18");


        List<Language> nyListeName = new ArrayList<Language>();
        List<Language> nyListeDescription = new ArrayList<Language>();
        List<Language> nyListeVersionRationale = new ArrayList<Language>();
        List<AdministrativeDetails> nyListeAdministativeDetails = new ArrayList<AdministrativeDetails>();


        Language nameobj = new Language("Oslo Bærum Felter 1 og 5 v3", "nb");
        Language descobj = new Language("Lagret for test formål", "nb");
        Language verionsRatobj = new Language("Fjernet kode 2", "nb");
        AdministrativeDetails adminobj = new AdministrativeDetails("ANNOTATION", values);
        urn_rank urnRankobj = new urn_rank("urn:klass-api:classifications:68:code:1", 1);
        urn_rank urnRankobj1 = new urn_rank("urn:klass-api:classifications:68:code:5", 4);
        urn_rank urnRankobj2 = new urn_rank("urn:klass-api:classifications:131:code:0301", 2);


        List<urn_rank> nyListeCodes = List.of(urnRankobj, urnRankobj1, urnRankobj2);
        nyListeName.add(nameobj);
        nyListeDescription.add(descobj);
        nyListeVersionRationale.add(verionsRatobj);
        nyListeAdministativeDetails.add(adminobj);



        return Subset.builder()
                .id("1")
                .name(nyListeName)
                .description(nyListeDescription)
                .shortname("Test subset 1")
                .administrativeStatus("OPEN")
                .createdDate("2020-03-24T13:05:17.343Z")
                .createdBy("312 - Seksjon for arbeidsmarked og lønnsstatistikk ")
                .version("3.0.1")
                .versionValidFrom("2020-03-25T13:05:17.343Z")
                .versionRationale(nyListeVersionRationale)
                .lastUpdatedDate("2020-03-24T13:05:17.343Z")
                .lastUpdatedBy("Test user")
                .validFrom("2020-03-25T13:05:17.343Z")
                .validUntil("2021-03-26T13:05:17.343Z")
                .administrativeDetails(nyListeAdministativeDetails)
                .codes(nyListeCodes)
                .build();

    }



    @PostMapping("/subset")
    public Subset postEndepoint1(@RequestBody Subset foresporsell){
        return foresporsell;
    }


}
