package com.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class News {

	@Id
//	@GenericGenerator(name = "", parameters = @Parameter(name = "prefix", value = "prod"), strategy = "")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@NotNull
	private String id;

	private String title;

	private String fileLink;

	private String shortDescript;

	private Long publisTime;

	@CreationTimestamp
	private Date createTime;

	@UpdateTimestamp
	private Date updateTime;

}
