package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "trade")
public class Trade {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column
	private Integer tradeId;
	
	@NotBlank(message = "Account is mandatory")
	@Column
	private String account;
	
	@NotBlank(message = "Type is mandatory")
	@Column
	private String type;
	
	@NotNull(message = "Buy Quantity is mandatory")
	@Column
	private Double buyQuantity;
	
	@Column
	private Double sellQuantity;
	
	@Column
	private Double buyPrice;
	
	@Column
	private Double sellPrice;
	
	@Column
	private String benchmark;
	
	@Column
	private Timestamp tradeDate;
	
	@Column
	private String security;
	
	@Column
	private String status;
	
	@Column
	private String trader;
	
	@Column
	private String book;
	
	@Column
	private String creationName;
	
	@Column
	private Timestamp creationDate;
	
	@Column
	private String revisionName;
	
	@Column
	private Timestamp revisionDate;
	
	@Column
	private String dealName;
	
	@Column
	private String dealType;
	
	@Column
	private String sourceListId;
	
	@Column
	private String side;

}
