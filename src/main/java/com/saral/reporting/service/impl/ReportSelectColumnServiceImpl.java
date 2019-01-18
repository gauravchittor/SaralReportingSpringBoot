package com.saral.reporting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saral.reporting.model.ReportSelectColumn;
import com.saral.reporting.repo.ReportSelectColumnRepository;
import com.saral.reporting.service.ReportSelectColumnService;

@Service
public class ReportSelectColumnServiceImpl implements ReportSelectColumnService {

	
	@Autowired
	ReportSelectColumnRepository reportSelectColumnRepository;

	@Override
	public ReportSelectColumn save(ReportSelectColumn reportSelectedColumn) {
		// TODO Auto-generated method stub

		return reportSelectColumnRepository.save(reportSelectedColumn);
	}
}
