package lk.zerocode.api.repository;

import lk.zerocode.api.model.MonthlyBasedLeave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MonthlyBasedLeavesRepository extends JpaRepository<MonthlyBasedLeave , Long> {

    Optional<MonthlyBasedLeave> findMonthlyBasedLeaveByCategoryAndType(String category,String type);
}
