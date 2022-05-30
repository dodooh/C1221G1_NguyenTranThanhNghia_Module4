package com.codegym.furama.dto;

import com.codegym.furama.model.employee.Department;
import com.codegym.furama.model.employee.EducationDegree;
import com.codegym.furama.model.employee.Position;
import com.codegym.furama.utils.DateConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EmployeeDto implements Validator {

    private String id;
    private String name;
    private String dayOfBirth;
    private String nationalId;
    private String phoneNumber;
    private String email;
    private String address;
    private EducationDegree educationDegree;
    private Position position;
    private Department department;
    private Double salary;

    public EmployeeDto() {
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" + ", name='" + name + '\'' + ", dayOfBirth='" + dayOfBirth + '\'' + ", nationalId='" + nationalId + '\''
            + ", phoneNumber='" + phoneNumber + '\'' + ", email='" + email + '\'' + ", address='" + address + '\'' + ", educationDegree="
            + educationDegree + ", position=" + position + ", department=" + department + ", salary=" + salary + '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        String COMMON_NAME_REGEX = "^\\p{Lu}\\p{Ll}*( \\p{Lu}\\p{Ll}*)*$";
        String PHONE_REGEX = "^0[1-9]\\d{8}$";
        String NATIONAL_ID_REGEX = "^\\d{9}$";
        String EMAIL_REGEX = "^\\w+([\\.-]?\\w+)*@[a-z]+\\.(\\w+)(\\.\\w{2,3})?";
        /*VALIDATE Ten*/
        String employeeNameCheck = employeeDto.getName();
        if (!employeeNameCheck.matches(COMMON_NAME_REGEX)) {
            errors.rejectValue("name", "name.format", "Loi khong ton tai");
        }
        /*VALIDATE CMND*/
        String nationalIDCheck = employeeDto.getNationalId();
        if (!nationalIDCheck.matches(NATIONAL_ID_REGEX)) {
            errors.rejectValue("nationalId", "nationalId.format", "Loi khong ton tai");
        }
        /*VALIDATE Phone NUmber*/
        String phoneCheck = employeeDto.getPhoneNumber();
        if (!phoneCheck.matches(PHONE_REGEX)) {
            errors.rejectValue("phoneNumber", "phoneNumber.format", "Loi khong ton tai");
        }
        /*VALIDATE Address*/
        String addressCheck = employeeDto.getAddress();
        if (addressCheck.length() == 0) {
            errors.rejectValue("address", "address.empty", "Loi khong ton tai");
        }
        /*VALIDATE Email*/
        String emailCheck = employeeDto.getEmail();
        if (!emailCheck.matches(EMAIL_REGEX)) {
            errors.rejectValue("email", "email.format", "Loi khong ton tai");
        }
        /*VALIDATE position*/
        Position positionCheck = employeeDto.getPosition();
        if (positionCheck == null) {
            errors.rejectValue("position", "position.empty", "Loi khong ton tai");
        }
        /*VALIDATE education*/
        EducationDegree educationDegreeCheck = employeeDto.getEducationDegree();
        if (educationDegreeCheck == null) {
            errors.rejectValue("educationDegree", "educationDegree.empty", "Loi khong ton tai");
        }
        /*VALIDATE department*/
        Department departmentCheck = employeeDto.getDepartment();
        if (departmentCheck == null) {
            errors.rejectValue("department", "department.empty", "Loi khong ton tai");
        }
        /*VALIDATE NGAY THANG NAM SIEU CAP VIPPRO*/
        String dobCheck = employeeDto.getDayOfBirth();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dobCheck); // check neu dung thuc su la ngay thang nam hop le
            employeeDto.setDayOfBirth(DateConverter.fromFormToDB(dobCheck));
        } catch (ParseException e) {
            errors.rejectValue("dayOfBirth", "dayOfBirth.valid", "Loi khong ton tai");
        }
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
