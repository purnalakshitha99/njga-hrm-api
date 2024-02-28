package lk.zerocode.api.repository;

import lk.zerocode.api.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BranchesRepository extends JpaRepository<Branch, Long> {

    Optional<Branch>findBranchByBranchCode(String branchCode);
}
