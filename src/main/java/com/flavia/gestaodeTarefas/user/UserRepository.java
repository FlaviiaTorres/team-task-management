package com.flavia.gestaodeTarefas.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long>{

	UserModel findByUserName(String userName);

}
