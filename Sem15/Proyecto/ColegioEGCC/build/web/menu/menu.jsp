<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<div class="menu">
  <ul>
    
    <li><a href="#" >Home</a></li>
    
    <c:if test="${modVentas == 1}">
    <li><a href="#">Ventas</a>
      <ul>
        <li><a href="#">Estudiantes</a></li>
        <li><a href="procIngresoPaso1.jsp">Cuota Ingreso</a></li>
        <li><a href="#">Matricula</a></li>
        <li><a href="#">Pago de Cuota</a></li>
      </ul>
    </li>
    </c:if>
    
    <c:if test="${modPlan == 1}">
    <li><a href="#">Planificación</a>
      <ul>
        <li><a href="#">Aulas</a></li>
        <li><a href="#">Periodos</a></li>
        <li><a href="#">Sección</a></li>
      </ul>
    </li>
    </c:if>

     <c:if test="${modCon == 1}">
    <li><a href="#">Consultas</a>
      <ul>
        <li><a href="conClientes.jsp">Consulta de clientes</a></li>
        <li><a href="#">Horizontal CSS Menus</a></li>
        <li><a href="#">Vertical CSS Menus</a></li>
        <li><a href="#">Dreamweaver Menus</a></li>
      </ul>
    </li>
     </c:if>

    <c:if test="${modRepo == 1}">
    <li><a href="#">Reportes</a>
      <ul>
        <li><a href="#">Drop Down CSS Menus</a></li>
        <li><a href="#">Horizontal CSS Menus</a></li>
        <li><a href="#">Vertical CSS Menus</a></li>
        <li><a href="#">Dreamweaver Menus</a></li>
      </ul>
    </li>
    </c:if>
    
    <c:if test="${modSegu == 1}">
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

