package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.ProductoBean;
import net.daw.bean.TipoproductoBean;
import net.daw.dao.ProductoDao;
import net.daw.helper.Contexto;
import net.daw.parameter.ProductoParam;

public class ProductoUpdatetipoproducto1 extends Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/mensaje.jsp");   
        ProductoBean oProductoBean = new ProductoBean();
        ProductoDao oProductoDao = new ProductoDao(oContexto.getEnumTipoConexion());
        ProductoParam oProductoParam = new ProductoParam(request);
        oProductoBean = oProductoParam.loadId(oProductoBean);
        
        oProductoBean=oProductoDao.get(oProductoBean);
        oProductoBean.setTipoProducto(oProductoParam.loadTipoProducto(oProductoBean).getTipoProducto());
                           
        oProductoBean = oProductoParam.loadTipoProducto(oProductoBean);
        try {
            oProductoDao.set(oProductoBean);
        } catch (Exception e) {
            throw new ServletException("ProductoController: Update Error: Phase 2: " + e.getMessage());
        }
        return "Se ha modificado la información del producto con id=" + Integer.toString(oProductoBean.getId()) + " <br /> <a href=\"Controller?class=producto&method=list\">Volver al listado de producto</a>";
    }
}
