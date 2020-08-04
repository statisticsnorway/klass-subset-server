package no.ssb.subsetserver.domain;

import java.util.ArrayList;
import java.util.List;

public class SubsetFactory {
    private static final String HTTP = "https://data.ssb.no/api/klass/v1/classifications";

    public static Subset subsetList(){
        List<String> values = List.of(HTTP + "/68/codesAt.json?date=2020-03-18", HTTP+"/131/codesAt.json?date=2020-03-18");


        List<Language> nyListeName = new ArrayList<Language>();
        List<Language> nyListeDescription = new ArrayList<Language>();
        List<Language> nyListeVersionRationale = new ArrayList<Language>();
        List<AdministrativeDetails> nyListeAdministativeDetails = new ArrayList<AdministrativeDetails>();


        Language nameobj = new Language("Oslo Bærum Felter 1 og 5 v3", "nb");
        Language descobj = new Language("Lagret for test formål", "nb");
        Language verionsRatobj = new Language("Fjernet kode 2", "nb");
        AdministrativeDetails adminobj = new AdministrativeDetails("ANNOTATION", values);
        Code urnRankobj = new Code("urn:klass-api:classifications:68:code:1", 1);
        Code urnRankobj1 = new Code("urn:klass-api:classifications:68:code:5", 4);
        Code urnRankobj2 = new Code("urn:klass-api:classifications:131:code:0301", 2);


        List<Code> nyListeCodes = List.of(urnRankobj, urnRankobj1, urnRankobj2);
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
                .version("3")
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
}
