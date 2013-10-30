/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.parameter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import net.daw.bean.ProductoBean;
import net.daw.bean.TipoproductoBean;

/**
 *
 * @author rafa
 */
public class ProductoParam {

    private HttpServletRequest request;

    public ProductoParam(HttpServletRequest request) throws Exception {
        this.request = request;
    }

    public ProductoBean loadId(ProductoBean oProducto) throws ServletException {
        try {
            if (request.getParameter("id") != null) {
                oProducto.setId(Integer.parseInt(request.getParameter("id")));
            } else {
                oProducto.setId(0);
            }
        } catch (NumberFormatException e) {
            throw new ServletException("Controller: Error: loadId: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oProducto;

    }

    public ProductoBean load(ProductoBean oProducto) throws NumberFormatException {
        try {
            if ((request.getParameter("codigo") != null)) {
                oProducto.setCodigo(request.getParameter("codigo"));
            }
            if ((request.getParameter("descripcion") != null)) {
                oProducto.setDescripcion(request.getParameter("descripcion"));
            }
            if ((request.getParameter("precio") != null)) {
                oProducto.setPrecio(Double.parseDouble(request.getParameter("precio")));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oProducto;
    }

    public ProductoBean loadTipoProducto(ProductoBean oProducto) throws NumberFormatException {
        try {
            if ((request.getParameter("id_tipoproducto") != null)) {
                TipoproductoBean oTipoproducto = new TipoproductoBean(Integer.parseInt(request.getParameter("id_tipoproducto")));
                oProducto.setTipoProducto(oTipoproducto);
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: loadTipoProducto: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oProducto;
    }
}
