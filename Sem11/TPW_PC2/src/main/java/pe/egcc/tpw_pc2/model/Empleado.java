package pe.egcc.tpw_pc2.model;

import java.util.Date;

public class Empleado {

  private String id;
  private String apellido;
  private String nombre;
  private Date fecha;
  private String email;
  private String telefono;
  private String cargo;
  private int departamento;
  private double sueldo;
  private double comision;
  private String jefe;

  public Empleado() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public int getDepartamento() {
    return departamento;
  }

  public void setDepartamento(int departamento) {
    this.departamento = departamento;
  }

  public double getSueldo() {
    return sueldo;
  }

  public void setSueldo(double sueldo) {
    this.sueldo = sueldo;
  }

  public double getComision() {
    return comision;
  }

  public void setComision(double comision) {
    this.comision = comision;
  }

  public String getJefe() {
    return jefe;
  }

  public void setJefe(String jefe) {
    this.jefe = jefe;
  }

}
