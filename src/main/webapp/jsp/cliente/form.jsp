<%@page import="net.daw.helper.Contexto"%>
<%@page import="net.daw.bean.ClienteBean"%>
<% Contexto oContexto = (Contexto) request.getAttribute("contexto");
    String strTitulo = "";
    String strControlEnabled = "";
    String strValueBoton = "Enviar";
    Integer id = 0;
    String nombre = "";
    String apellido1 = "";
    String apellido2 = "";
    String email = "";
    if (oContexto.getMetodo().equals("update") || oContexto.getMetodo().equals("view")) {
        ClienteBean oClienteBean = (ClienteBean) oContexto.getParametro();
        id = oClienteBean.getId();
        nombre = oClienteBean.getNombre();
        apellido1 = oClienteBean.getApe1();
        apellido2 = oClienteBean.getApe2();
        email = oClienteBean.getEmail();
    }
    if (oContexto.getMetodo().equals("view")) {
        strTitulo = "Vista";
        strControlEnabled = "disabled=\"true\"";
        strValueBoton = "Cerrar";
    }
    if (oContexto.getMetodo().equals("update")) {
        strTitulo = "Edición";
        strValueBoton = "Modificar";
    }
    if (oContexto.getMetodo().equals("new")) {
        strTitulo = "Alta";
        strValueBoton = "Crear";
    }
%>
<h1><%=strTitulo%> de cliente</h1>
<form class="semantic" action="Controller" method="post" id="clienteForm">
    <fieldset>
        <legend>Formulario de cliente</legend>
        <input type="hidden" name="id" value="<%=id%>" /> 
        <input type="hidden" name="class" value="cliente" /> 
        <input type="hidden" name="method" value="<%=oContexto.getMetodo()%>" /> 
        <input type="hidden" name="phase" value="2" />
        <div>
            <label for="nombre">Nombre: </label> 
            <input <%=strControlEnabled%> id="nombre" name="nombre" type="text" size="30" maxlength="50" autofocus="autofocus" value="<%=nombre%>" /><br />
        </div>
        <div>
            <label for="ape1">Primer Apellido: </label>
            <input <%=strControlEnabled%> id="ape1" name="ape1" type="text" size="30" maxlength="50" value="<%=apellido1%>" /><br />
        </div>
        <div>
            <label for="ape2">Segundo Apellido: </label> 
            <input <%=strControlEnabled%> id="ape2" name="ape2" type="text" size="30" maxlength="50" value="<%=apellido2%>" /> <br />
        </div>
        <div>
            <label for="email">Email: </label> 
            <input <%=strControlEnabled%> id="email" name="email" type="text" size="30" maxlength="50" value="<%=email%>" /><br />
        </div>
        <div>
            <input type="submit" name="enviar" value="<%=strValueBoton%>" />
        </div>
    </fieldset>
</form>
