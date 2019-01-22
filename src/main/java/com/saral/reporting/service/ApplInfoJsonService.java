package com.saral.reporting.service;

import java.util.List;

import com.saral.reporting.model.ApplInfoJson;

public interface ApplInfoJsonService {

	List<ApplInfoJson> findByServiceId(Long serviceId);
}
