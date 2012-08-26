package br.com.caelum.goodbuy.modelo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.NotNull;

@Entity
public class Pedido {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull(message="Nome precisa ser preenchido")
	private String nome;
	@NotNull(message="Data precisa ser preenchido")
	private Calendar data;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> itens;
	
	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public void setData(Calendar data){
		this.data = data;
	}

	public Calendar getData (){
		return data;	
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

	public double calculaValorTotal(){
		double valorTotal = 0;
		if (this.itens != null)
			for (Item item:itens){
				valorTotal += item.getValor()*item.getQuantidade();
			}
		return valorTotal;
	}
	

	public int calculaQuantidadeTotal(){
		int quantidade = 0;
		for (Item item:itens){
			quantidade += item.getQuantidade();
		}
		return quantidade;
	}


}