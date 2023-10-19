package com.flavia.gestaodeTarefas.task;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "tasks")
@Data
public class taskModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
    private String tittle;
    private String description;
    private String priority;

    
    private LocalDateTime startAt;
    private LocalDateTime endAt;

    private Long idUser;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    
    private void setTittle (String tittle) throws Exception{
    	if (tittle.length() > 50) {
			throw new Exception("O campo title deve conter no máximo 50 caracteres");
		}
    	this.tittle = tittle;
    }
	

}
