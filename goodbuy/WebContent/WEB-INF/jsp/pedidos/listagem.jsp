<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div style="-moz-border-radius: 3px;
	background-color: #c7c9cb;
	font-weight: bold;
	padding: 3px;
	margin-bottom: 15px;
	font-size: 16pt;
	color: #365372;">Cliente</div>

	Nome: ${pedido.nome }</br>
	Data: <fmt:formatDate value="${pedido.data.time}"
			pattern="dd/MM/yyyy" />


	</br></br>
	<div style="-moz-border-radius: 3px;
	background-color: #c7c9cb;
	font-weight: bold;
	padding: 3px;
	margin-bottom: 15px;
	font-size: 16pt;
	color: #365372;">Itens</div>
	
		<table align="right">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Quantidade</th>
					<th>Valor</th>
					<th>Total</th>


				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pedido.itens}" var="item">
					<tr>
						<td>${item.tipo}</td>
						<td>${item.quantidade}</td>
						
						<td>
						<fmt:formatNumber type="currency"
						value="${item.valor}"/>
						</td>
						
						<td>
						<fmt:formatNumber type="currency"
						value="${item.quantidade * item.valor }"/>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
</body>
</html>