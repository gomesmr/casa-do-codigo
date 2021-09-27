/**
 * 
 */
package com.zupacademy.casadocodigo.paisEstado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author marcelo.gomes
 *
 */
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{
    List<Estado> findByPais(String pais);

}
