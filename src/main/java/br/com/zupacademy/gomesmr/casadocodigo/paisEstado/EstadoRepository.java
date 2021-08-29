/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.paisEstado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author marcelo.gomes
 *
 */
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
