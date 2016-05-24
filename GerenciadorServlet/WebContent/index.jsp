<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${not empty usuarioLogado}">
	Logado como: ${usuarioLogado.email }
</c:if>

<form action="novaEmpresa" method="post">
	Nome: <input type="text" name="nome">
	<input type="submit" name="Enviar">
</form>


<form action="login" method="post">
Email: <input type="email" name="email">
Senha: <input type="password" name="senha">
<input type="submit" name="Enviar">
</form>

<form action="executa" method="post">
<input type="hidden" name="tarefa" value="Logout">
<input type="submit" name="Deslogar">
</form>


</body>
</html>