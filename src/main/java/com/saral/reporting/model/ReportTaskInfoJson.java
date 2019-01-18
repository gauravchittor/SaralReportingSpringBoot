/*package com.saral.reporting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONArray;

@Entity 
@Table(name="r_taskinfo_json")
public class ReportTaskInfoJson {
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "a_id")
	private Long a_id;
	
	@Column(name = "jsondata")
	private JSONArray jsondata;

}


CREATE TABLE saral1.r_taskinfo_json (
		id int8 NOT NULL,
		a_id int8 NULL,
		jsondata json NULL,
		CONSTRAINT tbl_taskinfo_json_pkey PRIMARY KEY (id)
	);
*/