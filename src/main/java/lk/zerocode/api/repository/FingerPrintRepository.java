package lk.zerocode.api.repository;

import lk.zerocode.api.model.FingerPrint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FingerPrintRepository extends JpaRepository<FingerPrint, Long> {
}
