package lk.zerocode.api.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String address;
    private String contactNumber;
    private String email;
    private String imagePath;
    private String nic;
    private String workTelephone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "employee")
    private List<PreviousWorkHistory> previousWorkHistories;

    @OneToOne(mappedBy = "employee")
    private CurrentWorkDetail currentWorkDetails;

    @OneToMany(mappedBy = "employee")
    private List<EducationQualification> educationQualificationList;

    @OneToMany(mappedBy = "employee")
    private List<DependentDetail> dependentDetailsList;

    @OneToMany(mappedBy = "employee")
    @JsonBackReference
    private List<EmergencyContact> emergencyContactList;

    @OneToMany(mappedBy = "employee")
    private List<FingerPrint> fingerPrintList;

    @OneToMany(mappedBy = "employee")
    private List<Attendance> attendanceList;

    @ManyToMany(mappedBy = "employeeList")
    private List<Notice> noticeList;

    @OneToMany(mappedBy = "employee")
    private List<FullDayLeave> fullDayLeavesList;

    @OneToMany(mappedBy = "employee")
    private List<OtherLeave> otherLeavesList;




}
