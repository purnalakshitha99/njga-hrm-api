package lk.zerocode.api.repository;

import lk.zerocode.api.model.CurrentWorkDetail;

import lk.zerocode.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrentWorkDetailRepository extends JpaRepository<CurrentWorkDetail,Long> {

}


