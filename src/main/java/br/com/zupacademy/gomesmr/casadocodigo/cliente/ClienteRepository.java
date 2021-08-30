/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author marcelo.gomes
 *
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
