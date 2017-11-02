package com.example.redsocialcartelesluminosos.domainmodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Imagen {
	
	@Id
	@GeneratedValue
	private Long id; //para persistir con Hibernate
	
	private String URLImg;
	
	@OneToMany(mappedBy = "img", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Post> posts = new ArrayList<Post>();
	
	public String getURLImg(){
		return URLImg;
	}
	public void setURLImg(String URL){
		this.URLImg=URL;
	}
}
