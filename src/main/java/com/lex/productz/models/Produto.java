package com.lex.productz.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;


@Entity(name = "produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String nome;
	
	@Column(nullable = true)
	private String descricao;
	
	@Column(name = "codigo_barra")
	private String codigoBarra;
	
	@Column
	private String categoria;
	
	@Column(nullable = true)
	private int quantidade;
	
	@Column(name=  "created_at")
	@CreationTimestamp
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime  createdAt;
	
	@Column(name=  "updated_at")
	@CreationTimestamp
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime  updateddAt;
	
	

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdateddAt() {
		return updateddAt;
	}

	public void setUpdateddAt(LocalDateTime updateddAt) {
		this.updateddAt = updateddAt;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
