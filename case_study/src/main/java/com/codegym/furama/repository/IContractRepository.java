package com.codegym.furama.repository;

import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.service.IPaidCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract, String> {

    @Query(value = "select customer.id customerId,\n" + "       contract.id contractId,\n" + "       customer.name customerName,\n"
        + "       customer_type.customer_type_name customerTypeName,\n" + "       facility.name facilityName,\n"
        + "       facility.cost facilityCost,\n" + "       contract.start_date startDate,\n" + "       contract.end_date endDate,\n"
        + "       GROUP_CONCAT(CONCAT(attach_service.name,'x',contract_detail.quantity)) attachServiceName,\n"
        + "       sum(coalesce(contract_detail.quantity * attach_service.cost, 0)) + facility.cost  as total\n" + "from contract\n"
        + "         inner join customer on contract.customer_id = customer.id\n"
        + "         left join customer_type on customer.customer_type_id = customer_type.id\n"
        + "         left join contract_detail on contract.id = contract_detail.contract_id\n"
        + "         left join facility  on contract.facility_id = facility.id\n"
        + "         left join attach_service on contract_detail.attach_service_id = attach_service.id\n" + "group by contract.id", countQuery =
        "select customer.id customerId,\n" + "       contract.id contractId,\n" + "       customer.name customerName,\n"
            + "       customer_type.customer_type_name customerTypeName,\n" + "       facility.name facilityName,\n"
            + "       facility.cost facilityCost,\n" + "       contract.start_date startDate,\n" + "       contract.end_date endDate,\n"
            + "       GROUP_CONCAT(CONCAT(attach_service.name,'x',contract_detail.quantity)) attachServiceName,\n"
            + "       sum(coalesce(contract_detail.quantity * attach_service.cost, 0)) + facility.cost  as total\n" + "from contract\n"
            + "         inner join customer on contract.customer_id = customer.id\n"
            + "         left join customer_type on customer.customer_type_id = customer_type.id\n"
            + "         left join contract_detail on contract.id = contract_detail.contract_id\n"
            + "         left join facility  on contract.facility_id = facility.id\n"
            + "         left join attach_service on contract_detail.attach_service_id = attach_service.id\n"
            + "group by contract.id", nativeQuery = true)
    Page<IPaidCustomer> getPaidCustomerPage(Pageable pageable);


    Page<Contract> findAllByEndDateBefore(String endDate, Pageable pageable);

    Page<Contract> findAllByStartDateAfter(String startDate, Pageable pageable);

    Page<Contract> findAllByStartDateAfterAndEndDateBefore(String startDate,String endDate, Pageable pageable);

}
