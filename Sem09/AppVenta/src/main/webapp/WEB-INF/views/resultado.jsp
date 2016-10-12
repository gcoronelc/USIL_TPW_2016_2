<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RESULTADO</title>
<style type="text/css">
  body {
    background-color: aqua;
  }
  #PAGE {
    width: 300px;
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
    <h1>RESULTADO</h1>
    <table>
      <tr>
        <td>Precio:</td>
        <td>${venta.precio}</td>
      </tr>
      <tr>
        <td>Cantidad:</td>
        <td>${venta.cant}</td>
      </tr>
      <tr>
        <td>Importe:</td>
        <td>${venta.importe}</td>
      </tr>
      <tr>
        <td>Impuesto:</td>
        <td>${venta.impuesto}</td>
      </tr>
      <tr>
        <td>Total:</td>
        <td>${venta.total}</td>
      </tr>
    </table>
    <a href='<c:url value="/"/>'>Retornar</a>
  </div>
</body>
</html>