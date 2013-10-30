/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.parameter;

import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import net.daw.helper.Contexto;

/**
 *
 * @author rafa
 */
public class ContextParam {

    private HttpServletRequest request;

    public ContextParam(HttpServletRequest request) throws Exception {
        this.request = request;
    }

    public Contexto load(Contexto oContexto) throws NumberFormatException {
        try {
            HashMap<String, String> parameterNames = new HashMap<>();
            Enumeration enumeration = request.getParameterNames();
            while (enumeration.hasMoreElements()) {
                String parameterName = (String) enumeration.nextElement();
                parameterNames.put(parameterName, request.getParameter(parameterName));
            }
            oContexto.setParameters(parameterNames);

            if (request.getParameter("id") == null) {
                oContexto.setId(0);
            } else {
                oContexto.setId(Integer.parseInt(request.getParameter("id")));
            }

            if ((request.getParameter("class") == null) || !oContexto.getHaySesion()) {
                oContexto.setClase("usuario");
            } else {
                oContexto.setClase(request.getParameter("class"));
            }

            if (request.getParameter("method") == null || (!oContexto.getHaySesion() && !"login".equals(request.getParameter("method")))) {
                oContexto.setMetodo("ocioso");
            } else {
                oContexto.setMetodo(request.getParameter("method"));
            }

            if (request.getParameter("phase") == null) {
                oContexto.setFase("1");
            } else {
                oContexto.setFase(request.getParameter("phase"));
            }

            if (request.getParameter("page") == null) {
                oContexto.setPage(1);
            } else {
                oContexto.setPage(Integer.parseInt(request.getParameter("page")));
            }

            if (request.getParameter("nrpp") == null) {
                oContexto.setNrpp(10);
            } else {
                oContexto.setNrpp(Integer.parseInt(request.getParameter("nrrp")));
            }

            if (request.getParameter("filter") == null) {
                oContexto.setFilter("nofilter");
                oContexto.setFilterValue("nofilter");
            } else {
                if (request.getParameter("filtervalue") == null) {
                    oContexto.setFilter("nofilter");
                    oContexto.setFilterValue("nofilter");
                } else {
                    oContexto.setFilter(request.getParameter("order"));
                    oContexto.setFilterValue(request.getParameter("filtervalue"));
                }
            }

            if (request.getParameter("order") == null) {
                oContexto.setOrder("noorder");
                oContexto.setOrderValue("noorder");
            } else {
                if (request.getParameter("filtervalue") == null) {
                    oContexto.setOrder("noorder");
                    oContexto.setOrderValue("noorder");
                } else {
                    oContexto.setOrder(request.getParameter("order"));
                    oContexto.setOrderValue(request.getParameter("filtervalue"));
                }
            }

            if (request.getParameter("selectonetable") == null) {
                oContexto.setSelectOneTable("");
            } else {
                oContexto.setSelectOneTable(request.getParameter("selectonetable"));
            }

            if (request.getParameter("selectonefield") == null) {
                oContexto.setSelectOneField("");
            } else {
                oContexto.setSelectOneField(request.getParameter("selectonefield"));
            }

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Controller: Error: load: Formato de datos en parámetros incorrecto " + e.getMessage());
        }
        return oContexto;
    }
}
