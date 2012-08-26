<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<table>
	<thead>
		<tr>
			<th>Nome</th>
			<th>Data</th>
			<th>Qtd Itens</th>
			<th>Valor Total</th>


		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pedidoList}" var="pedido">
		<tr>
		<td>${pedido.nome }</td>

 		<td><fmt:formatDate value="${pedido.data.time}" pattern="dd/MM/yyyy"/> </td>
		
		<td>${pedido.calculaQuantidadeTotal() }</td>
		
		<td><fmt:formatNumber type="currency"
						value="${pedido.calculaValorTotal() }"/></td>
		
		
		<td style= "width: auto;"><a href="listagem?id=${pedido.id }">Mostrar</a></td>
		</tr>
		</c:forEach>
		
	</tbody>
</table>