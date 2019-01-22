package com.saral.reporting.service;

import java.util.List;

import com.saral.reporting.model.ReportBean;

public interface ReportBeanService {
	
	ReportBean save(ReportBean reportBean);
	
	List<ReportBean> findBySignNo(String sign_no);
	
	ReportBean findByReportId(Long reportId);
	
	void deleteReportBean(Long reportId);

}
