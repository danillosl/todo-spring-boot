package com.danillosl.todo;

public class TodoModel {

	private String id;
	private String nome;
	private String conteudo;

	public TodoModel(String nome, String conteudo) {
		this.nome = nome;
		this.conteudo = conteudo;
	}
	
	public TodoModel(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
