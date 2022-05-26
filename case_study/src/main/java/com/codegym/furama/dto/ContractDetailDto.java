package com.codegym.furama.dto;

import com.codegym.furama.model.contract.ServiceExtra;
import com.codegym.furama.model.contract.Contract;

public class ContractDetailDto {
    private String id;
    private Contract contract;
    private ServiceExtra serviceExtra;
    private Integer quantity;

    public ContractDetailDto() {
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

    public ServiceExtra getServiceExtra() {
        return serviceExtra;
    }

    public void setServiceExtra(ServiceExtra serviceExtra) {
        this.serviceExtra = serviceExtra;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
