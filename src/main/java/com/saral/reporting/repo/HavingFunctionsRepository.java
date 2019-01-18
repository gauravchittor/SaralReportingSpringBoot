package com.saral.reporting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saral.reporting.model.HavingFunctions;

public interface HavingFunctionsRepository extends JpaRepository<HavingFunctions,Long>  {

	HavingFunctions findByFuncId(Long id);

	void deleteByFuncId(Long id);

}
