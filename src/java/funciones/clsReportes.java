
package funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import entidades.clsFactura;
import entidades.clsFacturaProducto;
import java.util.ArrayList;

public class clsReportes {
    
    // listado de todos los clientes con compras mayores a 1000
    // mostrar el numero factura, fecha, total, nombre cliente, ruc y el nombre del cliente 
    //1- mostrar la suma de compras por cada cliente
    //2- el numero de compras que hizo el cliente 
    //3- el numero de compras y el total de la compra
    //4- cliente que mas a comprado
    //5- cliente q menos a comprado
    //6- el promedio de compras 
    //7- el producto q mas se vende
    //8- el producto q mesno se vende
    //9- la s ventas por producto
    
    
    
      public ArrayList<clsFactura> CLIENTEFACTURAMAYORMIL() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT cliente.id_cliente,factura.cliente_id,factura.numero_factura,factura.fecha,factura.total,cliente.nombre, cliente.ruc "+
                "FROM public.cliente INNER JOIN public.factura"+
                " ON cliente.id_cliente = factura.cliente_id ORDER BY cliente.cnombre=ABC";

        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura defa = null;
            while (cres.next())
            {
                defa = new clsFactura();
                defa.setNumero_factura(cres.getInt("numero_factura"));
                defa.setFecha(cres.getDate("fecha"));
                defa.setTotal(cres.getDouble("total"));
                listado.add((defa));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
      //Suma de las compras
        public static ArrayList<clsFactura> sumacompras() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT\n" +
                    "\"public\".cliente.\"id_cliente\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre,\n" +
                    "Sum(\"public\".factura.total) AS \"Total\"\n" +
                    "FROM\n" +
                    "\"public\".cliente\n" +
                    "INNER JOIN \"public\".factura ON \"public\".factura.cliente_id = \"public\".cliente.\"id_cliente\"\n" +
                    "GROUP BY\n" +
                    "\"public\".cliente.\"id\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setTotal(cres.getDouble("total"));
                fac.setCliente(crudCliente.findbyId(cres.getInt("id")));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
         
         //numero de compras
         public static ArrayList<clsFactura> Numerocompras() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT\n" +
                    "\"public\".cliente.\"id_cliente\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre,\n" +
                    "Count(\"public\".factura.numero_factura) AS \"TotalFacturas\"\n" +
                    "FROM\n" +
                    "\"public\".factura\n" +
                    "INNER JOIN \"public\".cliente ON \"public\".factura.cliente_id = \"public\".cliente.\"id_cliente\"\n" +
                    "GROUP BY\n" +
                    "\"public\".cliente.\"id_cliente\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setNumero_factura(cres.getInt("TotalFacturas"));
                fac.setCliente(crudCliente.findbyId(cres.getInt("id")));                
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
         
         public static ArrayList<clsFactura> NumeroDeComprasyTotal() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT\n" +
                    "\"public\".cliente.\"id_cliente\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre,\n" +
                    "Count(\"public\".factura.numero_factura) AS \"TotalFactura\",\n" +
                    "Sum(\"public\".factura.total) AS \"Valor\"\n" +
                    "FROM\n" +
                    "\"public\".factura\n" +
                    "INNER JOIN \"public\".cliente ON \"public\".factura.cliente_id = \"public\".cliente.\"id_cliente\"\n" +
                    "GROUP BY\n" +
                    "\"public\".cliente.\"id_cliente\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre" ;
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setNumero_factura(cres.getInt("TotalFactura"));
                fac.setCliente(crudCliente.findbyId(cres.getInt("id")));
                fac.setTotal(cres.getDouble("Valor"));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
         }
         public static ArrayList<clsFactura> clientemascompras() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT\n" +
                    "\"public\".cliente.\"id_cliente\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre,\n" +
                    "Count(\"public\".factura.numero_factura) AS \"N° Facturas\",\n" +
                    "Sum(\"public\".factura.total) AS valor\n" +
                    "FROM\n" +
                    "\"public\".cliente\n" +
                    "INNER JOIN \"public\".factura ON \"public\".factura.cliente_id = \"public\".cliente.\"id_cliente\"\n" +
                    "GROUP BY\n" +
                    "\"public\".cliente.\"id_cliente\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre\n" +
                    "ORDER BY\n" +
                    "\"N° Facturas\" DESC\n" +
                    "LIMIT 1" ;
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setNumero_factura(cres.getInt("N° Facturas"));
                fac.setCliente(crudCliente.findbyId(cres.getInt("id")));
                fac.setTotal(cres.getDouble("valor"));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
        }
         
         public static ArrayList<clsFactura> Clientemenoscompras() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT\n" +
                    "\"public\".cliente.\"id_cliente\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre,\n" +
                    "Count(\"public\".factura.numero_facturas) AS \"N° Facturas\",\n" +
                    "Sum(\"public\".factura.total) AS valor\n" +
                    "FROM\n" +
                    "\"public\".cliente\n" +
                    "INNER JOIN \"public\".factura ON \"public\".factura.cliente_id = \"public\".cliente.\"id_cliente\"\n" +
                    "GROUP BY\n" +
                    "\"public\".cliente.\"id_cliente\",\n" +
                    "\"public\".cliente.ruc,\n" +
                    "\"public\".cliente.nombre\n" +
                    "ORDER BY\n" +
                    "\"N° Facturas\" ASc\n" +
                    "LIMIT 1" ;
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setNumero_factura(cres.getInt("N° Facturas"));
                fac.setCliente(crudCliente.findbyId(cres.getInt("id")));
                fac.setTotal(cres.getDouble("valor"));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
         
          public static ArrayList<clsFactura> promediocompras() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT\n" +
                    "Count(\"public\".factura.numero_factura) AS \"N° Facturas\",\n" +
                    "Sum(\"public\".factura.total) AS valor\n" +
                    "FROM\n" +
                    "\"public\".factura\n" +
                    "ORDER BY\n" +
                    "\"N° Facturas\" ASC" ;
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setNumero_factura(cres.getInt("N° Facturas"));
                fac.setTotal(cres.getDouble("valor"));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
          
          public static ArrayList<clsFacturaProducto> productomasvendido() {
        ArrayList<clsFacturaProducto> listado = new ArrayList<>();
        String sql = "SELECT\n" +
                "\"public\".producto.\"id\",\n" +
                "\"public\".producto.nombre,\n" +
                "Sum(\"public\".\"dfacturaproducto\".cantidad) AS cantidad,\n" +
                "Sum(\"public\".\"dfacturaproducto\".subtotal) AS valor\n" +
                "FROM\n" +
                "\"public\".producto\n" +
                "INNER JOIN \"public\".\"dfacturaproducto\" ON \"public\".\"dfacturaproducto\".di_producto = \"public\".producto.\"di_producto\"\n" +
                "GROUP BY\n" +
                "\"public\".producto.\"di_producto\",\n" +
                "\"public\".producto.nombre\n" +
                "ORDER BY\n" +
                "cantidad DESC\n" +
                "LIMIT 1" ;
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFacturaProducto pro = null;
            while (cres.next())
            {
                pro = new clsFacturaProducto();
                pro.setCantidad(cres.getInt("cantidad"));
                pro.setProducto(crudProducto.findbyId(cres.getInt("id")));
                pro.setSubtotal(cres.getDouble("valor"));
                listado.add((pro));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
     
          public static ArrayList<clsFacturaProducto> productomenosvendido() {
        ArrayList<clsFacturaProducto> listado = new ArrayList<>();
        String sql = "SELECT\n" +
            "\"public\".producto.\"id\",\n" +
            "\"public\".producto.nombre,\n" +
            "Sum(\"public\".\"DFacturaProducto\".cantidad) AS cantidad,\n" +
            "Sum(\"public\".\"DFacturaProducto\".subtotal) AS valor\n" +
            "FROM\n" +
            "\"public\".producto\n" +
            "INNER JOIN \"public\".\"DFacturaProducto\" ON \"public\".\"DFacturaProducto\".idproducto = \"public\".producto.\"id\"\n" +
            "GROUP BY\n" +
            "\"public\".producto.\"id\",\n" +
            "\"public\".producto.nombre\n" +
            "ORDER BY\n" +
            "cantidad ASC\n" +
            "LIMIT 1" ;
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFacturaProducto pro = null;
            while (cres.next())
            {
                pro = new clsFacturaProducto();
                pro.setCantidad(cres.getInt("cantidad"));
                pro.setProducto(crudProducto.findbyId(cres.getInt("id")));
                pro.setSubtotal(cres.getDouble("valor"));
                listado.add((pro));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    
}
