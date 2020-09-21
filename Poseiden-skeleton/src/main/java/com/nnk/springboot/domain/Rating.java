package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "rating")
public class Rating {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column
	private Integer id;
	
	@NotBlank(message = "Moodys Rating is mandatory")
	@Column
	private String moodysRating;
	
	@NotBlank(message = "Sand P Rating is mandatory")
	@Column
	private String sandPRating;
	
	@NotBlank(message = "Fitch Rating is mandatory")
	@Column
	private String fitchRating;
	
	@NotNull(message = "Order is mandatory")
	@Max(value = 127, message = "Order Number can not exceed 127")
	@Column
	private Integer orderNumber;
}
