package com.saral.reporting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saral.reporting.model.ReportBean;
import com.saral.reporting.repo.ReportBeanRepository;
import com.saral.reporting.service.ReportBeanService;

@Service
public class ReportBeanServiceImpl implements ReportBeanService {

	@Autowired
	ReportBeanRepository reportBeanRepository;

	@Override
	public ReportBean save(ReportBean reportBean) {
		// TODO Auto-generated method stub

		return reportBeanRepository.save(reportBean);
	}

	@Override
	public List<ReportBean> findBySignNo(String sign_no) {
		// TODO Auto-generated method stub
		return reportBeanRepository.findBySignNo(sign_no);
	}
	
	@Override
	public ReportBean findByReportId(Long reportId) {
		// TODO Auto-generated method stub
		return reportBeanRepository.findByReportId(reportId);
	}

	@Override
	public void deleteReportBean(Long reportId) {
		// TODO Auto-generated method stub
		reportBeanRepository.deleteByReportId(reportId);
	}
}
