package lk.zerocode.api.repository;

import lk.zerocode.api.model.MonthlyBasedLeave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyBasedLeavesRepository extends JpaRepository<MonthlyBasedLeave , Long> {
}
