package com.codegym.furama.model.contract;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class ContractDetail {

    @Id
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
        parameters = @Parameter(name = "prefix", value = "HDCT"),
        strategy = "com.codegym.furama.utils.IdentityCodeGenerator")
    private String id;


    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_service_id", referencedColumnName = "id")
    private ServiceExtra serviceExtra;

    private Integer quantity;

    public ContractDetail() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ServiceExtra getServiceExtra() {
        return serviceExtra;
    }

    public void setServiceExtra(ServiceExtra serviceExtra) {
        this.serviceExtra = serviceExtra;
    }
}
