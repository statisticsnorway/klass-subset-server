package no.ssb.subsetserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

//klass-subset-endpoint

@Builder
@Data
@AllArgsConstructor
public class Subset {
    private final String id;
    private final List<no.ssb.subsetserver.domain.Language> name;
    private final List<no.ssb.subsetserver.domain.Language> description;
    private final String shortname;
    private final String administrativeStatus;
    private final String createdDate;
    private final String createdBy;
    private final String version;
    private final String versionValidFrom;
    private final List<no.ssb.subsetserver.domain.Language> versionRationale;
    private final String lastUpdatedDate;
    private final String lastUpdatedBy;
    private final String validFrom;
    private final String validUntil;
    private final List<no.ssb.subsetserver.domain.AdministrativeDetails> administrativeDetails;
    private final List<no.ssb.subsetserver.domain.urn_rank> codes;


}
