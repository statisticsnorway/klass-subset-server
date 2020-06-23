package no.ssb.subsetserver.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Language {

    private final String languageText;
    private final String languageCode;


}
