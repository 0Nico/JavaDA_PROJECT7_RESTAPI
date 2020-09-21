package com.nnk.springboot.domain;

import org.springframework.beans.factory.annotation.Required;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "bidlist")
public class BidList {
     
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column
	private Integer BidListId;
	
	@NotBlank(message = "Account is mandatory")
	@Column
	private String account;
	
	@NotBlank(message = "Type is mandatory")
	@Column
	private String type;
	
	@NotNull(message = "Bid Quantity is mandatory")
	@Column
	private Double bidQuantity;
	
	@Column
	private Double askQuantity;
	
	@Column
	private Double bid;
	
	@Column
	private Double ask;
	
	@Column
	private String benchmark;
	
	@Column
	private Timestamp bidListDate;
	
	@Column
	private String commentary;
	
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
