package com.nnk.springboot.domain;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "curvepoint")
public class CurvePoint {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column
	private Integer id;
	
	@NotNull(message = "Curve Id is mandatory")
	@Max(value = 127, message = "Curve ID can not exceed 127")
	@Column
	private Integer curveId;
	
	@Column
	private Timestamp asOfDate;
	
	@NotNull(message = "Term is mandatory")
	@Column
	private Double term;
	
	@NotNull(message = "Value is mandatory")
	@Column
	private Double value;
	
	@Column
	private Timestamp creationDate;

    
}
