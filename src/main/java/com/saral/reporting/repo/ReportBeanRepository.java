package com.saral.reporting.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saral.reporting.model.ReportBean;

public interface ReportBeanRepository extends JpaRepository<ReportBean, Long> {

	List<ReportBean> findBySignNo(String sign_no);

	ReportBean findByReportId(Long reportId);
	
	void deleteByReportId(Long reportId);

}
