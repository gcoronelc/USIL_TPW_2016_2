<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<div class="menu">
  <ul>
    
    <li><a href="#" >Home</a></li>
    
    <c:if test="${VEN == 1}">
    <li><a href="#">Ventas</a>
      <ul>
        <li><a href="#">Drop Down CSS Menus</a></li>
        <li><a href="#">Horizontal CSS Menus</a></li>
        <li><a href="#">Vertical CSS Menus</a></li>
        <li><a href="#">Dreamweaver Menus</a></li>
      </ul>
    </li>
    </c:if>
    
    <c:if test="${PLA == 1}">
    <li><a href="#">Planificación</a>
      <ul>
        <li><a href="crearAula.jsp">Crear Aula</a></li>
        <li><a href="crearPeriodo.jsp">Crear Periodo</a></li>
        <li><a href="CargarSeccionForm">Crear Seccion</a></li>
        
      </ul>
    </li>
    </c:if>

     
    <li><a href="#">Consultas</a>
      <ul>
        <li><a href="#">Consulta de clientes</a></li>
        <li><a href="#">Horizontal CSS Menus</a></li>
        <li><a href="#">Vertical CSS Menus</a></li>
        <li><a href="#">Dreamweaver Menus</a></li>
      </ul>
    </li>
     

    <c:if test="${REP == 1}">
    <li><a href="#">Reportes</a>
      <ul>
        <li><a href="CargarAulaForm">Modificar Aula</a></li>
        <li><a href="EliminarAulaForm">Eliminar Aula</a></li>
        <li><a href="CargarPeriodoForm">Modificar Periodo</a></li>
        <li><a href="EliminarPeriodoForm">Eliminar Periodo</a></li>
        <li><a href="ModificarSeccionForm">Modificar Seccion</a></li>
        <li><a href="EliminarSeccionForm">Eliminar Seccion</a></li>
      </ul>
    </li>
    </c:if>
    
    <c:if test="${SEG == 1}">
    <li><a href="#">Seguridad</a>
      <ul>
        <li><a href="#">Drop Down CSS Menus</a></li>
        <li><a href="#">Horizontal CSS Menus</a></li>
        <li><a href="#">Vertical CSS Menus</a></li>
        <li><a href="#">Dreamweaver Menus</a></li>
      </ul>
    </li>
    </c:if>
    
    <li><a href="#">Ayuda</a>
      <ul>
        <li><a href="#">Drop Down CSS Menus</a></li>
        <li><a href="#">Horizontal CSS Menus</a></li>
        <li><a href="#">Vertical CSS Menus</a></li>
        <li><a href="#">Dreamweaver Menus</a></li>
      </ul>
    </li>    
    
    
  </ul>
</div>

