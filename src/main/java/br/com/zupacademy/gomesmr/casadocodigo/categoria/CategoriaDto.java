package br.com.zupacademy.gomesmr.casadocodigo.categoria;

public class CategoriaDto {
	private Long id;
	private String nome;

	/**
	 * @param nome
	 */
	public CategoriaDto(Long id, String nome) {
		this.id = id;
		this.nome = nome;
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}
