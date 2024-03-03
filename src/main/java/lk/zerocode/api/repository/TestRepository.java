package lk.zerocode.api.repository;

import lk.zerocode.api.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {

}
