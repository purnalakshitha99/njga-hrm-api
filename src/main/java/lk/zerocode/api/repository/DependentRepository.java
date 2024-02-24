package lk.zerocode.api.repository;

import lk.zerocode.api.model.DependentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependentRepository extends JpaRepository<DependentDetail,Long> {

}
