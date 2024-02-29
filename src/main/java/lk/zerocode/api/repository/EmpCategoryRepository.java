package lk.zerocode.api.repository;

import lk.zerocode.api.model.EmpCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpCategoryRepository extends JpaRepository<EmpCategory,Long> {

    Optional<EmpCategory> findEmpCategoriesByEmpCategoryAndEmpType(String empCategory,String categoryType);
}
