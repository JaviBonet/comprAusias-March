package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daw.bean.ProductoBean;
import net.daw.dao.ProductoDao;
import net.daw.helper.Contexto;
import net.daw.parameter.ProductoParam;

public class ProductoNew2 extends Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/mensaje.jsp");
        ProductoBean oProductoBean = new ProductoBean();
        ProductoDao oProductoDao = new ProductoDao(oContexto.getEnumTipoConexion());
        ProductoParam oProductoParam = new ProductoParam(request);
        oProductoBean = oProductoParam.loadId(oProductoBean);
        try {
            oProductoBean = oProductoParam.load(oProductoBean);
        } catch (NumberFormatException e) {
            return "Tipo de dato incorrecto en uno de los campos del formulario";
        } 
        try {
            oProductoDao.set(oProductoBean);
        } catch (Exception e) {
            throw new ServletException("ProductoController: Update Error: Phase 2: " + e.getMessage());
        }
        return "Se ha añadido la información del producto con id=" + Integer.toString(oProductoBean.getId());
    }

}
