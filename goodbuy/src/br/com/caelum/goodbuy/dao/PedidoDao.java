package br.com.caelum.goodbuy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.goodbuy.modelo.Pedido;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class PedidoDao {

	private final Session session;

	public PedidoDao(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Pedido> listaTudo() {
		List<Pedido> list = this.session.createCriteria(Pedido.class).list();
		return list;
	}

	public void salva(Pedido pedido) {

		Transaction tx = session.beginTransaction();
		session.save(pedido);
		tx.commit();
	}
	
	public Pedido carrega(Long id) {
		return (Pedido) this.session.load(Pedido.class, id);
		}

}
