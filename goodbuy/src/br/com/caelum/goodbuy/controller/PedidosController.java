package br.com.caelum.goodbuy.controller;

import java.util.List;

import br.com.caelum.goodbuy.dao.PedidoDao;
import br.com.caelum.goodbuy.modelo.Item;
import br.com.caelum.goodbuy.modelo.Pedido;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

@Resource
public class PedidosController {
	private final PedidoDao dao;
	private final Result result;
	private final Validator validator;

	public PedidosController(PedidoDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	public void adiciona(final Pedido pedido, final Item item) {
		validator.validate(pedido);
		validator.onErrorUsePageOf(PedidosController.class).formulario();
		dao.salva(pedido);
		result.redirectTo(this).lista();

	}

	public List<Pedido> lista() {
		return dao.listaTudo();
	}

	public void formulario() {
	}
	
	public Pedido listagem(Long id) {
		return dao.carrega(id);
		}
}