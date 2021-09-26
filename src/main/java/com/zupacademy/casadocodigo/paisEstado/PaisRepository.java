/**
 * 
 */
package com.zupacademy.casadocodigo.paisEstado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author marcelo.gomes
 *
 */
@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{

}
