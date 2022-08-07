package com.leonrv.crud_bp.repositories;
import org.springframework.stereotype.Repository;
import com.leonrv.crud_bp.models.*;

@Repository
public interface ICustomerRepository extends IGenericRepository<Customer, Long>{
    Customer findFirstByEmail(String email);
}
