package com.saral.reporting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_function")
public class HavingFunctions {

	@Id

	@GeneratedValue(generator = "r_app_generator")
	@SequenceGenerator(name = "r_app_generator", sequenceName = "r_app_generator_sequence", initialValue = 1)
	@Column(name = "func_id")
	private Long funcId;

	@Column(name = "name")
	private String name;

	@Column(name = "formula")
	private String formula;

	public Long getFuncId() {
		return funcId;
	}

	public void setFuncId(Long funcId) {
		this.funcId = funcId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

}
