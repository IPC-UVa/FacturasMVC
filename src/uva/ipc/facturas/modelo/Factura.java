/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uva.ipc.facturas.modelo;

import java.time.LocalDate;

/**
 *
 * @author macoas
 */
public class Factura {

    private String asunto;
    private LocalDate fecha;
    private double cantidad;
    private String tipo;

    public Factura(String asunto, LocalDate fecha, String cantidad, String tipo) {
        setAsunto(asunto);
        setFecha(fecha);
        setCantidad(cantidad);
        setTipo(tipo);
    }
    

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        if (asunto.isEmpty() || asunto.length() > 10) {
            throw new IllegalArgumentException("El asunto debe tener entre 1 y 10 caractéres");
            //errorLabel.setText("El asunto debe tener entre 1 y 10 caractéres");        
        }
        this.asunto = asunto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        if(fecha==null){
            throw new IllegalArgumentException("La fecha no puede ser nula");
        }
        this.fecha = fecha;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        double cantidadEnDouble=0.0;
        try{
            cantidadEnDouble = Double.parseDouble(cantidad);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("La cantidad debe ser un número positivo");
        }
        if (cantidadEnDouble < 0) {
            throw new IllegalArgumentException("La cantidad debe ser un número positivo");
        }
        this.cantidad = cantidadEnDouble;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        if(tipo==null){
            throw new IllegalArgumentException("El tipo no puede ser nulo");
        }
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Factura)) {
            return false;
        }

        Factura factura = (Factura) o;

        return this.asunto.equals(factura.getAsunto());
    }
    
    @Override
    public String toString(){
        return this.asunto+":"+this.tipo+":"+this.cantidad+":"+this.fecha;
    }

}
