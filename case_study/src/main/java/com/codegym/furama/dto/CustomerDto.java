package com.codegym.furama.dto;

import com.codegym.furama.model.customer.CustomerType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomerDto implements Validator {

    private String id;
    private String name;
    private String dayOfBirth;
    private Integer gender;
    private String nationalId;
    private String phone;
    private String mail;
    private String address;
    private CustomerType customerType;


    public CustomerDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        String COMMON_NAME_REGEX = "^\\p{Lu}\\p{Ll}*( \\p{Lu}\\p{Ll}*)*$";
        String PHONE_REGEX = "^0[1-9]\\d{8}$";
        String NATIONAL_ID_REGEX = "^\\d{9}$";
        String EMAIL_REGEX = "^\\w+([\\.-]?\\w+)*@[a-z]+\\.(\\w+)(\\.\\w{2,3})?";

        String customerNameCheck = customerDto.getName();
        if (!customerNameCheck.matches(COMMON_NAME_REGEX)) {
            errors.rejectValue("name", "name.format", "Loi khong ton tai");
        }

        String dobCheck = customerDto.getDayOfBirth();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dobCheck); // check neu dung thuc su la ngay thang nam hop le
            // vd: 30/02/2000 => Exception
            String d = dobCheck.split("/")[0];
            String m = dobCheck.split("/")[1];
            String y = dobCheck.split("/")[2];
            customerDto.setDayOfBirth(y + "-" + m + "-" + d);
        } catch (ParseException e) {
            errors.rejectValue("dayOfBirth", "dayOfBirth.valid", "Loi khong ton tai");
        }

        String nationalIDCheck = customerDto.getNationalId();
        if (!nationalIDCheck.matches(NATIONAL_ID_REGEX)) {
            errors.rejectValue("nationalId", "nationalId.format", "Loi khong ton tai");
        }
        String phoneCheck = customerDto.getPhone();
        if (!phoneCheck.matches(PHONE_REGEX)) {
            errors.rejectValue("phone", "phoneNumber.format", "Loi khong ton tai");
        }
        String addressCheck = customerDto.getAddress();
        if (addressCheck.length() == 0) {
            errors.rejectValue("address", "address.empty", "Loi khong ton tai");
        }
        String emailCheck = customerDto.getMail();
        if (!emailCheck.matches(EMAIL_REGEX)) {
            errors.rejectValue("mail", "email.format", "Loi khong ton tai");
        }
        CustomerType customerType = customerDto.getCustomerType();
        if (customerType == null) {
            errors.rejectValue("customerType", "customerType.empty", "Loi khong ton tai");
        }
    }
}
