package org.java.spring.repo;

import org.java.spring.pojo.SpecialSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialSaleRepository extends JpaRepository<SpecialSale, Integer>{

}
