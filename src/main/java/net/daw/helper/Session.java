package net.daw.helper;

import javax.servlet.http.HttpServletRequest;

public class Session {

    public static Contexto loadSession(HttpServletRequest request, Contexto oContexto) {
        oContexto.setHaySesion(request.getSession().getAttribute("usuarioBean") != null);
        return oContexto;
    }
}
