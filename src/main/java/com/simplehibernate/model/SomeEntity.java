package com.simplehibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class SomeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	// @CollectionOfElements
	@ElementCollection(targetClass = String.class)
	@CollectionTable(name = "UserFilter_orgUnits", joinColumns = @JoinColumn(name = "UserFilter_FILTER_ID"))
	@Column(columnDefinition = "varchar(255)", name = "element")
	private Set<String> orgUnits = new HashSet<String>();

	public Set<String> getOrgUnits() {
		return orgUnits;
	}
 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setOrgUnits(Set<String> orgUnits) {
		this.orgUnits = orgUnits;
	}

}
