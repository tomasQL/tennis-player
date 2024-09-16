package com.tomasql.springdatajdbc.tennis_player;
import java.sql.Date;

/* This class is a Bean */
public class Player {
    private int id;
    private String nombre;
    private String nacionalidad;
    private Date fecha_nacimiento;
    private int titulos_ganados;

    public Player(){

    }

    public Player(int id, String nombre, String nacionalidad, Date fecha_nacimiento, int titulos_ganados){
        super();
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.titulos_ganados = titulos_ganados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getTitulos_ganados() {
        return titulos_ganados;
    }

    public void setTitulos_ganados(int titulos_ganados) {
        this.titulos_ganados = titulos_ganados;
    }

    @Override
    public String toString(){
        return "\nPlayer [id= "+ id + ", nombre= " + nombre + ", nacionalidad=" + nacionalidad + "," + "\n" +
                " fecha de nacimiento= " + fecha_nacimiento + ", titulos_ganados= " + titulos_ganados + "]";
    }

}

