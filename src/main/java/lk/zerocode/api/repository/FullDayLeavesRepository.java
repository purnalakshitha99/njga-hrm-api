package lk.zerocode.api.repository;

import lk.zerocode.api.model.FullDayLeave;
import lk.zerocode.api.model.YearlyBasedLeave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FullDayLeavesRepository extends JpaRepository<FullDayLeave,Long> {
    int countByYearBasedLeaveCategoryAndLeaveType(String category, String leaveType);
}
