package lk.zerocode.api.repository;

import lk.zerocode.api.model.FingerPrint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FingerPrintRepository extends JpaRepository<FingerPrint, Long> {

    Optional<FingerPrint> findByFingerPrintId(String fId);
}
