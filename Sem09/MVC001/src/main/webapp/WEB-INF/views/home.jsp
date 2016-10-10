<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>SUMA</title>
<style type="text/css">
  #PAGE{
    width: 260px;
    margin: 10px auto;
  }
</style>
</head>
<body>
  <div id="PAGE">
	<h1>SUMA</h1>
	<form method="post" action="sumar.abc">
	 <fieldset>
	   <legend>Datos</legend>
	   <label>N�mero 1: </label>
	   <input type="text" name="n1" />
	   <label>N�mero 2: </label>
     <input type="text" name="n2" />
     <input type="submit" value="Procesar" />
	 </fieldset>
	</form>
	<c:if test="${suma != null }">
	 <p>N�mero 1: ${num1}</p>
	 <p>N�mero 2: ${num2}</p>
	 <p>Suma: ${suma}</p>
	</c:if>
	</div>
</body>
</html>
