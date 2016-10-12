<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>VENTA</title>
<style type="text/css">
	body {
		background-color: aqua;
	}
	#PAGE {
		width: 250px;
		margin: 10px auto;
		padding: 10px;
		background-color: white;
		font-size: 16px;
	}
	
	label {
		display: inline-block;
		width: 70px;
	}
	
	input {
		display: inline-block;
		width: 120px;
	}
</style>
</head>
<body>
	<div id="PAGE">
		<h1>VENTA</h1>
		<form method="post" action="venta.papo">
			<fieldset>
				<legend>Datos</legend>
				<label>Precio:</label> 
				<input type="text" name="precio" /> 
				<label>Cantidad:</label>
				<input type="text" name="cant" /> 
				<input type="submit" value="Procesar" />
			</fieldset>
		</form>
	</div>
</body>
</html>
