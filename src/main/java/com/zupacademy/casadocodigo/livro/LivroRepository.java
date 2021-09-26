/**
 * 
 */
package com.zupacademy.casadocodigo.livro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author marcelo.gomes
 *
 */
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
