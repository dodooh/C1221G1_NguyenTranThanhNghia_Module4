package com.codegym.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserDto implements Validator {

    private Long id;

    @NotBlank(message = "{name.notBlank}")
    @NotEmpty(message = "{name.notEmpty}")
    @NotNull(message = "{name.notNull}")
    @Size(min = 5, max = 45, message = "{name.sizeError}")
    private String firstName;

    @NotBlank(message = "{name.notBlank}")
    @NotEmpty(message = "{name.notEmpty}")
    @NotNull(message = "{name.notNull}")
    @Size(min = 5, max = 45, message = "{name.sizeError}")
    private String lastName;


    @NotNull(message = "{phone.notNull}")
    @NotEmpty(message = "{phone.notEmpty}")
    private String phoneNumber;


    private String dayOfBirth;

    @Email(message = "{email.valid}", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @NotEmpty(message = "{email.notEmpty}")
    private String email;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (!userDto.getPhoneNumber().matches("^0[0-9]{9}$"))  {
            errors.rejectValue("phoneNumber", "phone.format", "unknown error");
        }
        if (!userDto.getDayOfBirth().matches("^20[0-2][0-9]-((0[1-9])|(1[0-2]))-([0-2][1-9]|3[0-1])$")) {
            errors.rejectValue("dayOfBirth", "dayOfBirth.format", "unknown error");
        } else {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            Date birthdayDate = null;
            Date current = new Date();
            try {
                birthdayDate = fmt.parse(userDto.getDayOfBirth());
                System.out.println(birthdayDate);
                // KIEM TRA NGAY CO TRONG QUA KHU KHONG
                if (birthdayDate != null && birthdayDate.compareTo(new Date()) > 0) {
                    errors.rejectValue("dayOfBirth", "dayOfBirth.after", "unknown dob");
                }
                // KIEM TRA TUOI > 18
                OffsetDateTime startOdt = birthdayDate.toInstant().atOffset(ZoneOffset.UTC);
                OffsetDateTime endOdt = current.toInstant().atOffset(ZoneOffset.UTC);
                int years = Period.between(startOdt.toLocalDate(), endOdt.toLocalDate()).getYears();
                System.out.println(years);
                if (years < 18) {
                    errors.rejectValue("dayOfBirth", "dayOfBirth.under18");
                }
            } catch (ParseException e) {
                e.printStackTrace();
                errors.rejectValue("dayOfBirth", "dayOfBirth.form");
            }
        }
    }
}