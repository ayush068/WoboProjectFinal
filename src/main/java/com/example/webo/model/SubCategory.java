package com.example.webo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SubCategory {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name ="subcategory_id")
private int  id;
	
private String name;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
	
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}


}