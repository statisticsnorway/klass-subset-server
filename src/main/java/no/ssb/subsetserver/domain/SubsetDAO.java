package no.ssb.subsetserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SUBSET")
public class SubsetDAO {
    private static final String ID_COLUMN = "SUBSET_ROWID";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_" + ID_COLUMN)
    @SequenceGenerator(name = "SEQ_" + ID_COLUMN, sequenceName = "SEQ_" + ID_COLUMN, allocationSize = 1)
    @Column(name = ID_COLUMN, nullable = false, updatable = false)
    private Long id;

    @Column(name="SUBSET_ID")
    private String subsetId;

    @Column(name="VERSION")
    private String version;

    @Column(name="JSON_CONTENT")
    private String jsonContent; //kommer tilbake til dette. Ønskelig med en representasjon av json-objektet (i råformat, samme som postman) og ikke som et java-objekt

}
