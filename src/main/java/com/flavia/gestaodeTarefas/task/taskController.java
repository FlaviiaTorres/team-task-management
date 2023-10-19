package com.flavia.gestaodeTarefas.task;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class taskController {

	@Autowired
	private taskRepository taskRepository;
	
	@PostMapping("/")
	public ResponseEntity create (@RequestBody taskModel taskModel, HttpServletRequest request) {
		var idUser = request.getAttribute("idUser");
		taskModel.setIdUser((Long) idUser);
		
		var currentDate = LocalDateTime.now();
		if (currentDate.isAfter(taskModel.getStartAt()) || currentDate.isAfter(taskModel.getEndAt())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de inicio / data de termino deve ser maior que a data atual");
		}
		
		if (taskModel.getStartAt().isAfter(taskModel.getEndAt())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de inicio deve ser menor que a data de termino");
		}
		
		var task = this.taskRepository.save(taskModel);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(task);
	}
	
	@GetMapping("/")
	public List<taskModel> list (HttpServletRequest request){
		var idUser = request.getAttribute("idUser");
		return this.taskRepository.findByIdUser((Long) idUser);
	}
	
	
	
	
}
