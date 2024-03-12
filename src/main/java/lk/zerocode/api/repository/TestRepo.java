package lk.zerocode.api.repository;

import lk.zerocode.api.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test, Long> {
}
