package lk.zerocode.api.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empId;
    private String firstName;
    private String lastName;
    private String nic;
    private String gender;
    private LocalDate dob;
    private String email;
    private String address;
    private String contactNumber;
    private String workTelephone;
    private String imagePath;

    @OneToMany(mappedBy = "employee")
    private List<PreviousWorkHistory> previousWorkHistories;

    @OneToOne(mappedBy = "employee")
    private CurrentWorkDetails currentWorkDetails;

    @OneToMany(mappedBy = "employee")
    private List<EducationQualification> educationQualificationList;

    @OneToMany(mappedBy = "employee")
    private List<DependentDetails> dependentDetailsList;

    @OneToMany(mappedBy = "employee")
    private List<EmergencyContact> emergencyContactList;

    @ManyToOne
    private Branch branch;

    @OneToMany(mappedBy = "employee")
    private List<FingerPrint> fingerPrintList;

    @OneToMany(mappedBy = "employee")
    private List<Attendance> attendanceList;

    @ManyToMany(mappedBy = "employeeList")
    private List<Notice> noticeList;

    @OneToMany(mappedBy = "employee")
    private List<FullDayLeaves> fullDayLeavesList;

    @OneToMany(mappedBy = "employee")
    private List<OtherLeaves> otherLeavesList;







}
