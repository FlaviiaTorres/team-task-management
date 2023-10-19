package com.flavia.gestaodeTarefas.task;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface taskRepository extends JpaRepository<taskModel, Long> {
	List<taskModel> findByIdUser (Long id);

}
