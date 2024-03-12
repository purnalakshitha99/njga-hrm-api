package lk.zerocode.api.repository;

import lk.zerocode.api.model.DependentDetail;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.model.PreviousWorkHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PreviousWorkHistoryRepository extends JpaRepository<PreviousWorkHistory,Long> {

//    Optional<PreviousWorkHistory> findPreviousWorkHistoriesByEmployeeAndId(Employee employee,Long id);

}
