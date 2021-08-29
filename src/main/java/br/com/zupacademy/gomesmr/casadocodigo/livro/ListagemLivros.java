/**
 * 
 */
package br.com.zupacademy.gomesmr.casadocodigo.livro;

/**
 * @author marcelo.gomes
 *
 */
public class ListagemLivros {
	private Long id;
	private String titulo;
	
	/**
	 * @param id
	 * @param titulo
	 */
	public ListagemLivros(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	

}
