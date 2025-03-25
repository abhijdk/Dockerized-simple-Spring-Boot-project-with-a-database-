package com.bootReact.Spring_Boot_and_React_CRUD_Operation.reposetory;

import com.bootReact.Spring_Boot_and_React_CRUD_Operation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
