package no.ssb.subsetserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class AdministrativeDetails {
    private final String administativeDetailType;
    private final List<String> values;

}
