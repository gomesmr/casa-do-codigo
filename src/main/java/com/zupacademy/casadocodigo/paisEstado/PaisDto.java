/**
 * 
 */
package com.zupacademy.casadocodigo.paisEstado;

/**
 * @author marcelo.gomes
 *
 */
public class PaisDto {

    private Long id;
    private String nome;

    public PaisDto() {
    }

    public PaisDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public PaisDto(Pais pais) {
        this.id = pais.getId();
        this.nome = pais.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

