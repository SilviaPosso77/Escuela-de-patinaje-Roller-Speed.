package com.rollerspeed.v1.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="clase")
public class Clase {
    @Id
    @Column(name = "IDCLASE", nullable = false, unique = true)
    private int IDclase;

    @Column(name="NOMBRECLASE", nullable = false, length = 100)
    private String NombreClase;

    @Column(name="FECHAINICIO", nullable = false)
    private Date FechaInicio;

    @Column(name="FECHAFINAL", nullable = false)
    private Date FechaFinal;

    @Column(name="HORARIO", nullable= false, length = 16)
    private String Horario;

    @Column(name="DIA", nullable= false, length = 16)
    private String Dia;

    public Clase(int IDclase, String NombreClase, Date FechaInicio, Date FechaFinal, String Horario, String Dia){
        this.IDclase= IDclase;
        this.NombreClase= NombreClase;
        this.FechaInicio= FechaInicio;
        this.FechaFinal= FechaFinal;
        this.Horario= Horario;
        this.Dia= Dia;
    }

    public Clase(){

    }

    public int getIDclase(){
        return IDclase;
    }

    public void setIDclase(int IDclase){
        this.IDclase=IDclase;
    }
    
    public String getNombreClase(){
        return NombreClase;
    }
    
    public void setNombreClase(String NombreClase){
        this.NombreClase=NombreClase;
    }

    public Date getFechaInicio(){
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio){
        this.FechaInicio=FechaInicio;
    }

    public Date getFechaFinal(){
        return FechaFinal;
    }

    public void setFechaFinal(Date FechaFinal){
        this.FechaFinal=FechaFinal;
    }

    public String getHorario(){
        return Horario;
    }
    
    public void setHorario(String Horario){
        this.Horario=Horario;
    }
    
    public String getDia(){
        return Dia;
    }
    
    public void setDia(String Dia){
        this.Dia=Dia;
    }
}
