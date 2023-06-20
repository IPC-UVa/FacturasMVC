/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.facturas.modelo;

import java.util.ArrayList;

/**
 *
 * @author mcorrales
 */
public class ModeloFacturas {
    
    private ArrayList<Factura> listaFacturas;
    
    public ModeloFacturas(){
        listaFacturas = new ArrayList<Factura>();
    }
    
    public Factura getFactura(String asunto) {
        for (Factura factura : this.listaFacturas) {
            if (asunto.equals(factura.getAsunto())) {
                return factura;
            }
        }
        return null;
    }
    
    public void eliminarFactura(Factura factura){
        this.listaFacturas.remove(factura);
    }
    
    public ArrayList<Factura> getListaFacturas(){
        return this.listaFacturas;
    }
    
    public void addFactura(Factura factura){
        if(this.listaFacturas.contains(factura)){
            throw new IllegalStateException();
        }
        this.listaFacturas.add(factura);
    }
    
    public void actualizarFactura(Factura factura){
        Factura facturaExistente=getFactura(factura.getAsunto());
        if(facturaExistente==null){
            throw new IllegalStateException();
        }
        facturaExistente.setAsunto(factura.getAsunto());
        facturaExistente.setCantidad(String.valueOf(factura.getCantidad()));
        facturaExistente.setFecha(factura.getFecha());
        facturaExistente.setTipo(factura.getTipo());
        
    }
    
}
