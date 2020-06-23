package no.ssb.subsetserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class urn_rank {
    private final String urn;
    private final int rank;
}
