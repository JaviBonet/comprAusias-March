<%@page import="net.daw.helper.Contexto"%>
<%@page import="net.daw.bean.ProductoBean"%>
<% Contexto oContexto = (Contexto) request.getAttribute("contexto");
    String strTitulo="";
    String strControlEnabled = "";
    String strValueBoton = "Enviar";
    Integer id = 0;
    String codigo = "";
    String descripcion = "";
    String precio = "";
    String strTipoproducto = "";
    if ("update".equals(oContexto.getMetodo()) || oContexto.getMetodo().equals("view")) {
        ProductoBean oProductoBean = (ProductoBean) oContexto.getParametro();
        id = oProductoBean.getId();
        codigo = oProductoBean.getCodigo();
        descripcion = oProductoBean.getDescripcion();
        precio = Double.toString(oProductoBean.getPrecio());
        strTipoproducto = "(" + Integer.toString(oProductoBean.getTipoProducto().getId()) + ") " + oProductoBean.getTipoProducto().getDescripcion();
    }
    if (oContexto.getMetodo().equals("view")) {
        strTitulo="Vista";
        strControlEnabled = "disabled=\"true\"";
        strValueBoton = "Cerrar";
    }
    if (oContexto.getMetodo().equals("update")) {
        strTitulo="Edición";
        strValueBoton = "Modificar";
    }
    if (oContexto.getMetodo().equals("new")) {
        strTitulo="Alta";
        strValueBoton = "Crear";
    }
%>
<h1><%=strTitulo%> de producto</h1>
<form class="semantic" action="Controller" method="post" id="clienteForm">
    <fieldset>
        <legend>Formulario de producto</legend>
        <input type="hidden" name="id" value="<%=id%>" /> 
        <input type="hidden" name="class" value="producto" /> 
        <input type="hidden" name="method" value="<%=oContexto.getMetodo()%>" /> 
        <input type="hidden" name="phase" value="2" />
        <div>
            <label for="codigo">Código: </label> 
            <input <%=strControlEnabled%>  id="codigo" name="codigo"
                   type="text" size="30" maxlength="50" autofocus="autofocus"
                   value="<%=codigo%>" />
            <br />
        </div>
        <div>
            <label for="descripcion">Descripción: </label> 
            <input <%=strControlEnabled%>  id="descripcion"
                   name="descripcion" type="text" size="30" maxlength="50"
                   value="<%=descripcion%>" />
            <br />
        </div>
        <div>
            <label for="precio">Precio: </label> 
            <input <%=strControlEnabled%>  id="precio"
                   name="precio" type="text" size="30" maxlength="50"
                   value="<%=precio%>" /> 
            <br />
        </div>           
        <div>
            <label for="tipoproducto">Tipo de producto: </label> 
            <input disabled="true"  id="tipoproducto"
                   name="tipoproducto" type="text" size="30" maxlength="50"
                   value="<%=strTipoproducto%>" /> 
            <br />
        </div>             
        <div>
            <input type="submit" name="enviar" value="<%=strValueBoton%>" />
        </div>
    </fieldset>
</form>
