package com.tozzr.reqif.web;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Specification {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	@Enumerated
	private SpecificationType type;
    
    private String text;
    private String examples;
    
    	
    @NotNull
    @ManyToOne
    private Project project;
    
    @OneToOne
    private Specification next;
    
    public Specification() {
	}
    
    public Specification(SpecificationType type, Project project) {
    	this.type = type;
    	this.project = project;
    }

    public static Specification version(Specification spec) {
		Specification s = new Specification(spec.getType(), spec.getProject());
		s.setText(spec.getText());
		spec.setNext(s);
		return s;
	}

}
