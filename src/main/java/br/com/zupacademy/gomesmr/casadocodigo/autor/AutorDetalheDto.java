package br.com.zupacademy.gomesmr.casadocodigo.autor;

public class AutorDetalheDto {
	private String nome;
	private String descricao;

	/**
	 * 
	 * @param id
	 * @param nome
	 * @param descricao
	 */
	public AutorDetalheDto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;

	}
	
	public AutorDetalheDto(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
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

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	
	
	
	
}
