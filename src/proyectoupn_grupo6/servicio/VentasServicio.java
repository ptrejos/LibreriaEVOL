/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.servicio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proyectoupn_grupo6.bd.AccesoDB;
import proyectoupn_grupo6.modelo.Promocion;
import proyectoupn_grupo6.modelo.Venta;

/**
 *
 * @author PABLO TREJO
 */
public class VentasServicio {
    private Connection cn;
    private PreparedStatement pstm;

    private final String GET_VENTASRANGOFECHA = "select idventa, cliente, fecha, idempleado,idpublicacion, "
            + " cantidad, precio, dcto, "
            + "subtotal, impuesto, total from VENTA "
            + "where fecha between ? + ' 00:00:00.000' and ? +  ' 23:59:59.999';";

    private final String GET_ALL = "select idventa, cliente, fecha, idempleado, idpublicacion, "
            + "cantidad, precio, dcto, subtotal, impuesto, total "
            + "from VENTA";
    private final String INSERT_VENTA = "insert into venta values(?,?,?,?,?,?,?,?,?,?,?);";

    private final String GET_IDVENTA = "select count(*) + 1 as codigoVenta  from VENTA; ";

    //Metodo para Listar Ventas
    public List<Venta> listarVentas() throws SQLException {

        List<Venta> ventas = new ArrayList<>();

        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(GET_ALL);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Venta dto = new Venta();
                dto.setIdVenta(rs.getInt("idventa"));
                dto.setCliente(rs.getString("cliente"));
                dto.setFecha(rs.getDate("fecha").toLocalDate());
                dto.setIdEmpleado(rs.getInt("idEmpleado"));
                dto.setIdPublicacion(rs.getString("idPublicacion"));
                dto.setCantidad(rs.getInt("cantidad"));
                dto.setPrecio(rs.getDouble("precio"));
                dto.setDcto(rs.getDouble("dcto"));
                dto.setSubTotal(rs.getDouble("subTotal"));
                dto.setImpuesto(rs.getDouble("impuesto"));
                dto.setTotal(rs.getDouble("total"));

                ventas.add(dto);
            }
            pstm.close();

        } catch (SQLException e) {
            throw new SQLException("error : " + e.getMessage());
        } finally {
            cn.close();
        }
        return ventas;
    }

    //Metodo para Listar Ventas por fecha
    public List<Venta> listarVentasPorRangoFecha(String fechaInicio, String fechTermino) throws SQLException {

        List<Venta> ventas = new ArrayList<>();

        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(GET_VENTASRANGOFECHA);
            pstm.setString(1, fechaInicio);
            pstm.setString(2, fechTermino);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Venta dto = new Venta();
                dto.setIdVenta(rs.getInt("idventa"));
                dto.setCliente(rs.getString("cliente"));
                dto.setFecha(rs.getDate("fecha").toLocalDate());
                dto.setIdEmpleado(rs.getInt("idEmpleado"));
                dto.setIdPublicacion(rs.getString("idPublicacion"));
                dto.setCantidad(rs.getInt("cantidad"));
                dto.setPrecio(rs.getDouble("precio"));
                dto.setDcto(rs.getDouble("dcto"));
                dto.setSubTotal(rs.getDouble("subTotal"));
                dto.setImpuesto(rs.getDouble("impuesto"));
                dto.setTotal(rs.getDouble("total"));

                ventas.add(dto);
            }
            pstm.close();

        } catch (SQLException e) {
            throw new SQLException("error : " + e.getMessage());
        } finally {
            cn.close();
        }
        return ventas;
    }

    //Metodo para calcular los descuentos
    public Venta calcular(Venta dto, double igv) throws SQLException {
        
        PromocionServicio svc = new PromocionServicio();
        //variables de entrada
        int cantidad;
        double Precio;
       
        //variable de salida
        double descuento, total, subtotal, impuesto, totalbruto;
        //reasignacion de variables
        cantidad = dto.getCantidad();
        Promocion promocion = svc.getPorcentajePromocion(cantidad);
        double procentaje = promocion.getPorcentaje();
        
        Precio = dto.getPrecio();
        //proceso
        descuento = cantidad * Precio * procentaje;
        totalbruto = (cantidad * Precio) - descuento;
        impuesto = totalbruto * igv;
        subtotal = totalbruto - impuesto;
        total = subtotal + impuesto;
        
        dto.setPorcentaje(procentaje);
        dto.setDcto(descuento);
        dto.setSubTotal(subtotal);
        dto.setImpuesto(impuesto);
        dto.setTotal(total);

        return dto;

    }

    //Metodo para obtener el IGV
    public int getIdVenta() throws SQLException {

        int idVenta = 0;
        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(GET_IDVENTA);    
            ResultSet rs = pstm.executeQuery();

           rs.next();
           idVenta = rs.getInt("codigoVenta");
           pstm.close();
        } catch (SQLException e) {
            throw new SQLException("error : " + e.getMessage());
        } finally {
            cn.close();
        }
        return idVenta;
    }
    
    //Metodo para insertar Ventas
     public boolean insertarVenta(Venta dto) throws SQLException {
        boolean respuesta = false;
        
        
        try {
            cn = AccesoDB.getConnection();

            pstm = cn.prepareStatement(INSERT_VENTA);
            pstm.setInt(1,dto.getIdVenta() );
            pstm.setString(2, dto.getCliente() );
            pstm.setDate(3, Date.valueOf(dto.getFecha()));
            pstm.setInt(4, dto.getIdEmpleado());
            pstm.setString(5, dto.getIdPublicacion());
            pstm.setInt(6, dto.getCantidad());
            pstm.setDouble(7, dto.getPrecio() );
            pstm.setDouble(8, dto.getDcto());
            pstm.setDouble(9,dto.getSubTotal() );
            pstm.setDouble(10, dto.getImpuesto());
            pstm.setDouble(11,dto.getTotal() );
  
            if (pstm.executeUpdate() > 0) {
                respuesta = true;
            }
            pstm.close();

        } catch (SQLException e) {
            throw new SQLException("error : " + e.getMessage());
        } finally {
            cn.close();
        }
        return respuesta;
    }
}
