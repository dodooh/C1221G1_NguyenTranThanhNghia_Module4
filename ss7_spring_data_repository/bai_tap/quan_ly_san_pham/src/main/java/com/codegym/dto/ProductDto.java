package com.codegym.dto;


import com.codegym.service.IProductService;
import java.util.List;
import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//@GroupSequence(value={Cheap.class,Expensive.class})
public class ProductDto implements Validator {

    private Integer id;

    private String productCode;

    @NotBlank(message = "not blank")
    @Size(min= 5, max=20, message = "not size")
    private String name;


    private Double price;
    @NotBlank(message = "not blank des")
    private String description;
    private String manufacture;
    private List<String> productCodeList;

    public List<String> getProductCodeList() {
        return productCodeList;
    }

    public void setProductCodeList(List<String> productCodeList) {
        this.productCodeList = productCodeList;
    }

    public ProductDto(Integer id, String productCode, String name, Double price, String description, String manufacture) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacture = manufacture;
    }

    public ProductDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        if (!productDto.getName().matches("^[a-zA-Z ]+$")) {
            errors.rejectValue("name", "name.regex", "Loi Regex");
        }
        if (productDto.productCodeList.contains(productDto.productCode)) {
            errors.rejectValue("productCode", "name.regex", "Trung Product Code");
        }

    }
}
