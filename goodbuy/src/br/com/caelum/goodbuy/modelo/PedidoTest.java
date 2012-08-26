package br.com.caelum.goodbuy.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class PedidoTest {

	@Test
	public void listaVazia() {
		Pedido p = new Pedido();
		Calendar data = GregorianCalendar.getInstance();;
		p.setNome("Thiago");
		p.setData(data);
		
		Assert.assertEquals(0.0, p.calculaValorTotal());
	}
	
	@Test
	public void listaUmItemUmaQdd() {
		Pedido p = new Pedido();
		Calendar data = GregorianCalendar.getInstance();;
		p.setNome("Thiago");
		p.setData(data);
		
		List<Item> itens = new ArrayList<Item>();

		Item i = new Item();
		i.setTipo("PS3");
		i.setQuantidade(1);
		i.setValor(900.0);
		itens.add(i);
		
		p.setItens(itens);
		
		Assert.assertEquals(900.0, p.calculaValorTotal());
	}
	
	@Test
	public void listaUmItemVariasQdd() {
		Pedido p = new Pedido();
		Calendar data = GregorianCalendar.getInstance();;
		p.setNome("Thiago");
		p.setData(data);
		
		List<Item> itens = new ArrayList<Item>();

		Item i = new Item();
		i.setTipo("PS3");
		i.setQuantidade(10);
		i.setValor(900.0);
		itens.add(i);
		
		p.setItens(itens);
		
		Assert.assertEquals(9000.0, p.calculaValorTotal());
	}
	
	@Test
	public void listaDoisItemUmaQdd() {
		Pedido p = new Pedido();
		Calendar data = GregorianCalendar.getInstance();;
		p.setNome("Thiago");
		p.setData(data);
		
		List<Item> itens = new ArrayList<Item>();

		Item i1 = new Item();
		i1.setTipo("PS3");
		i1.setQuantidade(1);
		i1.setValor(900.0);
		itens.add(i1);
		
		Item i2 = new Item();
		i2.setTipo("XBOX");
		i2.setQuantidade(1);
		i2.setValor(800.0);
		itens.add(i2);
		
		p.setItens(itens);
		
		Assert.assertEquals(1700.0, p.calculaValorTotal());
	}
	
	@Test
	public void listaDoisItemVariasQdd() {
		Pedido p = new Pedido();
		Calendar data = GregorianCalendar.getInstance();;
		p.setNome("Thiago");
		p.setData(data);
		
		List<Item> itens = new ArrayList<Item>();

		Item i1 = new Item();
		i1.setTipo("PS3");
		i1.setQuantidade(5);
		i1.setValor(900.0);
		itens.add(i1);
		
		Item i2 = new Item();
		i2.setTipo("XBOX");
		i2.setQuantidade(10);
		i2.setValor(800.0);
		itens.add(i2);
		
		p.setItens(itens);
		
		Assert.assertEquals(12500.0, p.calculaValorTotal());
	}
}