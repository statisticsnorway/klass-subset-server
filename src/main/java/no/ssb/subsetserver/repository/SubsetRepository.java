package no.ssb.subsetserver.repository;

import no.ssb.subsetserver.domain.SubsetDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubsetRepository extends JpaRepository<SubsetDAO, Long> {
    SubsetDAO findBySubsetIdAndVersion(String subsetId, String version);

    List<SubsetDAO> findBySubsetIdOrderByVersionDesc(String subsetId);



}
