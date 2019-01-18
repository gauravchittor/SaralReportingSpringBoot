/*package com.saral.reporting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONArray;

@Entity 
@Table(name="r_app_json")
public class ReportAppJson {

	@Id
	@Column(name = "aid")
	private Long aid;
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "jsondata")
	private JSONArray jsondata;
	
	
}


CREATE TABLE saral1.r_app_json (
		aid int8 NOT NULL,
		id int8 NULL,
		jsondata json NULL,
		CONSTRAINT tbl_app_json_pkey PRIMARY KEY (aid)
	);*/