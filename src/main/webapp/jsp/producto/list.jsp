
<%@ page import="net.daw.helper.Contexto"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="net.daw.bean.ProductoBean"%>
<%
    Contexto oContexto = (Contexto) request.getAttribute("contexto");
    ArrayList<Object> alObjetoParametro = (ArrayList<Object>) oContexto.getParametro();
    ArrayList<ProductoBean> alPagina = (ArrayList<ProductoBean>) alObjetoParametro.get(0);
    Iterator<ProductoBean> oIterador = alPagina.listIterator();
%>
<h1>Listado de productos</h1>
<%
    if (!oIterador.hasNext()) {
        out.print("<h4>Listado vacío</h4>");
    } else {
%>
<table class="table table-hover table-condensed">
    <tr>
        <th>id</th>
        <th>código</th>
        <th>descripción</th>
        <th>precio</th>
        <th>tipo</th>
        <th colspan="2">Operaciones</th>
    </tr>
    <%
        while (oIterador.hasNext()) {
            ProductoBean oProductoBEAN = oIterador.next();
    %>
    <tr>
        <td><%=oProductoBEAN.getId()%></td>
        <td><%=oProductoBEAN.getCodigo()%></td>
        <td><%=oProductoBEAN.getDescripcion()%></td>
        <td><%=oProductoBEAN.getPrecio()%>&euro;</td>
        <td>
            <div class="btn-group">
                <a class="btn btn-mini" href="Controller?class=tipoproducto&method=selectone&id=<%=oProductoBEAN.getId()%>&selectonetable=producto&selectonefield=id_tipoproducto"><i class="icon-search"></i></a>                                        
            </div>
            <%=oProductoBEAN.getTipoProducto().getDescripcion()%>
        </td>
        <td>
            <div class="btn-toolbar">
                <div class="btn-group">
                    <a class="btn btn-mini" href="Controller?class=producto&method=view&id=<%=oProductoBEAN.getId()%>"><i class="icon-eye-open"></i></a>                    
                    <a class="btn btn-mini" href="Controller?class=producto&method=update&id=<%=oProductoBEAN.getId()%>"><i class="icon-pencil"></i></a>           
                    <a class="btn btn-mini" href="Controller?class=producto&method=remove&id=<%=oProductoBEAN.getId()%>"><i class="icon-trash"></i></a>            
                </div>
            </div>
        </td>
    </tr>
    <%
        }
    %>
    <%
        ArrayList<String> paginacion = (ArrayList<String>) alObjetoParametro.get(1);
        Iterator<String> iterador2 = paginacion.listIterator();
        while (iterador2.hasNext()) {
            String o = iterador2.next();
            out.print(o);
        }
    %>
</table>
<%
    }
%>
