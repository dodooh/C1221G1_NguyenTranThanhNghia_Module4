package com.codegym.furama.service;

public interface IPaidCustomer {

    String getCustomerId();
    String getCustomerName();
    String getCustomerTypeName();
    String getFacilityName();
    Double getFacilityCost();
    String getStartDate();
    String getEndDate();
    String getAttachServiceName();
    String getTotal();
}
