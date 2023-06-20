/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.facturas.vista;

import java.time.LocalDate;
import java.time.Month;
import uva.ipc.facturas.modelo.Factura;
import uva.ipc.facturas.modelo.ModeloFacturas;

/**
 *
 * @author mcorrales
 */
public class ControladorFacturas {

    private VistaFacturas vista;
    private ModeloFacturas modelo;

    public ControladorFacturas(VistaFacturas v) {
        this.vista = v;
        modelo = new ModeloFacturas();
    }

    public void procesaEventoEditar() {
        String value = this.vista.getNombreFacturaSeleccionada();
        if (value != null) {
            String asunto = value.split(":")[0];
            Factura factura = this.modelo.getFactura(asunto);
            if (factura != null) {
                this.vista.actualizarCamposFacturaExistente(factura);
            }
        }
    }

    public void procesaEventoEliminar() {
        String value = this.vista.getNombreFacturaSeleccionada();
        if (value != null) {
            String asunto = value.split(":")[0];
            Factura factura = this.modelo.getFactura(asunto);
            this.modelo.eliminarFactura(factura);
            this.vista.actualizarMensaje("Factura eliminada con éxito");
        }
        this.vista.actualizarListaFacturas(this.modelo.getListaFacturas());
    }

    public void procesaEventoActualizarOCrear() {
        Factura factura = this.crearFactura();
        if (factura != null) {

            try {
                this.modelo.addFactura(factura);
                this.vista.actualizarMensaje("Factura añadida con éxito");
            } catch (IllegalStateException e) {
                try {
                    this.vista.actualizarMensaje("La factura ya existe");
                    this.modelo.actualizarFactura(factura);
                    this.vista.actualizarMensaje("Factura actualizada con éxito");
                } catch (IllegalStateException e2) {
                    this.vista.actualizarMensaje("La factura no existe");
                }
            }

            
            this.vista.actualizarListaFacturas(this.modelo.getListaFacturas());
        }
    }

    private Factura crearFactura() {
        String asunto = this.vista.getAsunto();
        int dia = this.vista.getDia();
        int mes = this.vista.getMes();
        int ano = this.vista.getAno();
        String cantidad = this.vista.getCantidad();
        String tipo = this.vista.getTipo();
        Factura factura;
        try {
            factura = new Factura(asunto, LocalDate.of(ano, mes, dia), cantidad, tipo);
            return factura;
        } catch (IllegalArgumentException e) {
            this.vista.actualizarMensaje(e.getMessage());
        }

        return null;

    }

}
