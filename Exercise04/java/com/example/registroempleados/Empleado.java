package com.example.registroempleados;

public class Empleado {
    private int id;
    private String nya;
    private int telefono;
    private String correo;
    private String departamento;
    private Boolean responsable;

    public Empleado(int id, String nya, int telefono, String correo, String departamento, Boolean responsable) {
        this.id = id;
        this.nya = nya;
        this.telefono = telefono;
        this.correo = correo;
        this.departamento = departamento;
        this.responsable = responsable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNya() {
        return nya;
    }

    public void setNya(String nya) {
        this.nya = nya;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Boolean getResponsable() {
        return responsable;
    }

    public void setResponsable(Boolean responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nya='" + nya + '\'' +
                ", telefono=" + telefono +
                ", correo='" + correo + '\'' +
                ", departamento='" + departamento + '\'' +
                ", responsable=" + responsable +
                '}';
    }
}
