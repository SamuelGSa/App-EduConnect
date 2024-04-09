package com.br.educonnect.persistence.repository;



import com.br.educonnect.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario,Integer> {

}
