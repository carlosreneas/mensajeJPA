<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mensajes</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link href="css/signin.css" rel="stylesheet">
</head>
  <body class="text-center">
    <form class="form-signin" method="post" action="LoginController">
      <img class="mb-4" src="https://images.vexels.com/media/users/3/136393/isolated/preview/a64969983168ba1e8aa409c2e512e3e4-icono-de-mensaje-de-chat-abierta-by-vexels.png" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Credenciales de Ingreso</h1>
      
      <c:set var="alerta" scope="request" value = "${requestScope.msgResultado}"/>
		<c:if test="${alerta!=null}">  
			<div class="alert alert-success" role="alert">
	  			<c:out value="${alerta}"/>
			</div>
		</c:if>
      <label for="usuario" class="sr-only">Email</label>
      <input type="text" id="usuario" name="usuario" class="form-control" placeholder="Usuario" required autofocus>
      <label for="password" class="sr-only">Password</label>
      <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Recuerdame me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>
  </body>
</html>