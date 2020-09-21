package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "rulename")
public class RuleName {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column
	private Integer id;
	
	@NotBlank(message = "Name is mandatory")
	@Column
	private String name;
	
	@NotBlank(message = "Description is mandatory")
	@Column
	private String description;
	
	@NotBlank(message = "Json is mandatory")
	@Column
	private String json;
	
	@NotBlank(message = "Template is mandatory")
	@Column
	private String template;
	
	@NotBlank(message = "Sql Str is mandatory")
	@Column
	private String sqlStr;
	
	@NotBlank(message = "Sql Part is mandatory")
	@Column
	private String sqlPart;

}
