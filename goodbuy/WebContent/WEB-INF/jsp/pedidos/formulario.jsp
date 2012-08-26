<form action="adiciona">
	<fieldset>
		<legend>Adicionar Pedido</legend>
		<label for="nome">Nome:</label> 
		<input id="nome" type="text" name="pedido.nome" value="${pedido.nome }" /> 
		
		
 		<label for="data">Data:</label> 
 		<script type="text/javascript">
 			$(function(){
 				$("#data").datapicker({dateFormat: 'dd/mm/yyyy'});
 			});
		</script>
 		<input id="data" name="pedido.data" type="text">
		
	</fieldset>
	
	
	<fieldset id="item-container">
		<legend>
			Itens
			<img src="${pageContext.request.contextPath}/img/adicionar.png" alt="+" onclick="adicionar();" />
		</legend>

		<c:forEach items="${pedido.itens}" var="item" varStatus="status">
			<div class="item">
				<label>Nome:</label>
				<input type="text" name="pedido.itens[${status.index}].tipo" value="${item.tipo}" />
				
				<label>Quantidade:</label>
				<input type="text" name="pedido.itens[${status.index}].quantidade" value="${item.quantidade}" />
			
				<label>Valor:</label>
				<input type="text" name="pedido.itens[${status.index}].valor" value="${item.valor}" />
				
				<input type="hidden" name="pedido.itens[${status.index}].id" value="${item.id}" />

				<img src="${pageContext.request.contextPath}/img/remover.png" alt="-" class="button-remover" />
			</div>
		</c:forEach>
	</fieldset><br/>
	

	<input type="submit" value="Salvar" />
</form>

<script type="text/javascript">
	var model =
		'<div class="item">' +
			'<label>Nome:</label>' +
			'<input type="text" name="pedido.itens[0].tipo" />' +
			'<label>Quantidade:</label>' +
			'<input type="text" name="pedido.itens[0].quantidade" />' +
			'<label>Valor:</label>' +
			'<input type="text" name="pedido.itens[0].valor" />' +

			'<img src="${pageContext.request.contextPath}/img/remover.png" alt="-" class="button-remover" />' +
		'</div>';

	$('.button-remover').live('click', function() {
		$(this).parent().remove();
		reorderIndexes();
	});

	function adicionar() {
		$('#item-container').append(model);

		reorderIndexes();
	};

	function reorderIndexes() {
		var regex = /\[[0-9]\]/g;

		$('.item').each(function(index) {
			var $campos = $(this).find('input'),
				$input	,
				name	;

			$campos.each(function() {
				$input	= $(this),
				name	= $input.attr('name');

				$input.attr('name', name.replace(regex, '[' + index + ']'));
			});
		});
	};
</script>