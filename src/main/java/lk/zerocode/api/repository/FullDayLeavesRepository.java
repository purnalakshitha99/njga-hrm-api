package lk.zerocode.api.repository;

import lk.zerocode.api.model.FullDayLeave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FullDayLeavesRepository extends JpaRepository<FullDayLeave,Long> {
}
