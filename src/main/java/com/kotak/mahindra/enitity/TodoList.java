package com.kotak.mahindra.enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "todo_list")
public @Data class TodoList {
	@Id
	@Column(name = "todo_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(strategy = "native", name = "native")	
	private long id;
	@Column(name="skill_level")
	private int skillLevel;
	@Column(name="technologies")
	private String technologies;	
}
