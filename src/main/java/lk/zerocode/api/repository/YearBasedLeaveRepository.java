package lk.zerocode.api.repository;

import lk.zerocode.api.model.Employee;
import lk.zerocode.api.model.YearlyBasedLeave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface YearBasedLeaveRepository extends JpaRepository<YearlyBasedLeave,Long> {

    Optional<YearlyBasedLeave> findYearlyBasedLeaveByCategoryAndType(String category, String type);
}
