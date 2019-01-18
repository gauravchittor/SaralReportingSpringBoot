package com.saral.reporting.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saral.reporting.model.AttributeMasterDataSql;

public interface AttributeMasterDataSqlRepository extends JpaRepository<AttributeMasterDataSql, Long>{

	List<AttributeMasterDataSql> findByBaseServiceID(Long baseServiceId);
}
