package lk.zerocode.api.repository;

import lk.zerocode.api.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendenceRepository extends JpaRepository<Attendance, Long> {
}
