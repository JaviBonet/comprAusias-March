package net.daw.dao;

import net.daw.bean.UsuarioBean;
import net.daw.data.Mysql;
import net.daw.helper.Enum;

public class UsuarioDao {

    private final Mysql oMysql;
    private final Enum.Connection enumTipoConexion;

    public UsuarioDao(Enum.Connection tipoConexion) throws Exception {
        oMysql = new Mysql();
        enumTipoConexion = tipoConexion;
    }

    public UsuarioBean get(UsuarioBean oUsuario) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            String strId = oMysql.getId("usuario", "login", oUsuario.getLogin());
            if (strId == null) {
                oUsuario.setId(0);
            } else {
                oUsuario.setId(Integer.parseInt(strId));
            }
            String strPass = oMysql.getOne("usuario", "password", oUsuario.getId());
            if (strPass != null) {
                if (strPass.equals(oUsuario.getPassword())) {
                    oUsuario.setNombre(oMysql.getOne("usuario", "nombre", oUsuario.getId()));
                    oUsuario.setEmail(oMysql.getOne("usuario", "email", oUsuario.getId()));
                }
            } else {
                oUsuario.setNombre("");
                oUsuario.setEmail("");
            }
            oMysql.desconexion();
            return oUsuario;
        } catch (Exception e) {
            throw new Exception("ClienteDao.getPage: Error: " + e.getMessage());
        }
    }
}
