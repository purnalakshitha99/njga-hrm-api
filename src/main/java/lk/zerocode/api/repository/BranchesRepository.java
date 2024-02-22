package lk.zerocode.api.repository;

import lk.zerocode.api.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchesRepository extends JpaRepository<Branch, Long> {
}
