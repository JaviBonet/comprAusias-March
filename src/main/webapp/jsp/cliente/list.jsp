
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="net.daw.bean.ClienteBean"%>
<%@ page import="net.daw.helper.Contexto"%>
<%
    Contexto oContexto = (Contexto) request.getAttribute("contexto");
    ArrayList<Object> alObjetoParametro = (ArrayList<Object>) oContexto.getParametro();
    ArrayList<ClienteBean> alPagina = (ArrayList<ClienteBean>) alObjetoParametro.get(0);
    Iterator<ClienteBean> oIterador = alPagina.listIterator();
%>
<h1>Listado de clientes</h1>
<%
    if (!oIterador.hasNext()) {
        out.print("<h4>Listado vacío</h4>");
    } else {
%>
<table class="table table-hover table-condensed">
    <tr>
        <th>id</th>
        <th>nombre</th>
        <th>ape1</th>
        <th>ape2</th>
        <th>email</th>
        <th>Operaciones</th>
    </tr>

    <%
        while (oIterador.hasNext()) {
            ClienteBean oClienteBEAN = oIterador.next();
    %>
    <tr>
        <td><%=oClienteBEAN.getId()%></td>
        <td><%=oClienteBEAN.getNombre()%></td>
        <td><%=oClienteBEAN.getApe1()%></td>
        <td><%=oClienteBEAN.getApe2()%></td>
        <td><%=oClienteBEAN.getEmail()%></td>
        <td>
            <div class="btn-toolbar">
                <div class="btn-group">                    
                    <a class="btn btn-mini" href="Controller?class=cliente&method=view&id=<%=oClienteBEAN.getId()%>"><i class="icon-eye-open"></i></a>                    
                    <a class="btn btn-mini" href="Controller?class=cliente&method=update&id=<%=oClienteBEAN.getId()%>"><i class="icon-pencil"></i></a>           
                    <a class="btn btn-mini" href="Controller?class=cliente&method=remove&id=<%=oClienteBEAN.getId()%>"><i class="icon-trash"></i></a>                         
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
