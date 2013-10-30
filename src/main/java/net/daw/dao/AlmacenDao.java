/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import java.util.ArrayList;
import java.util.Iterator;

import net.daw.bean.AlmacenBean;
import net.daw.data.Mysql;
import net.daw.helper.Enum;


/**
 *
 * @author mati
 */
public class AlmacenDao {
    
    
    private Mysql oMysql;
    private Enum.Connection enumTipoConexion;
    public AlmacenDao(Enum.Connection tipoConexion) throws Exception {
        oMysql = new Mysql();
        enumTipoConexion=tipoConexion;
    }
    
    
    public int getPages(int intRegsPerPag) throws Exception {
        int pages;
        try {
            oMysql.conexion(enumTipoConexion);
            pages = oMysql.getPages("almacen", intRegsPerPag);
            oMysql.desconexion();
            return pages;
        } catch (Exception e) {
            throw new Exception("AlmacenDao.getPages: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }
    
    
    public ArrayList<AlmacenBean> getPage(int intRegsPerPag, int intPage) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<AlmacenBean> arrAlmacen = new ArrayList<>();
        try {
            oMysql.conexion(enumTipoConexion);
            arrId = oMysql.getPage("almacen", intRegsPerPag, intPage,"");
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                AlmacenBean oAlmacenBean = new AlmacenBean(iterador.next());
                arrAlmacen.add(this.get(oAlmacenBean));
            }
            oMysql.desconexion();
            return arrAlmacen;
        } catch (Exception e) {
            throw new Exception("AlmacenDao.getPage: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }

    
    public ArrayList<String> getNeighborhood(String strLink, int intPageNumber, int intTotalPages, int intNeighborhood) throws Exception {
        oMysql.conexion(enumTipoConexion);        
        ArrayList<String> n = oMysql.getNeighborhood(strLink, intPageNumber, intTotalPages, intNeighborhood);
        oMysql.desconexion();
        return n;
    }
    
    public AlmacenBean get(AlmacenBean oAlmacenBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oAlmacenBean.setNombre(oMysql.getOne("almacen", "nombre", oAlmacenBean.getId()));
            oAlmacenBean.setLocalidad(oMysql.getOne("almacen", "localidad", oAlmacenBean.getId()));
            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("ClienteDao.getCliente: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
        return oAlmacenBean;
    }
    
    
     public void set(AlmacenBean oAlmacenBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.initTrans();
            if (oAlmacenBean.getId() == 0) {
                oAlmacenBean.setId(oMysql.insertOne("almacen"));
            }
            oMysql.updateOne(oAlmacenBean.getId(), "almacen", "nombre", oAlmacenBean.getNombre());
            oMysql.updateOne(oAlmacenBean.getId(), "almacen", "localidad", oAlmacenBean.getLocalidad());
            oMysql.commitTrans();
        } catch (Exception e) {
            oMysql.rollbackTrans();
            throw new Exception("AlmacenDao.setCliente: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }
     
     public void remove(AlmacenBean oAlmacenBean) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            oMysql.removeOne(oAlmacenBean.getId(), "almacen");
            oMysql.desconexion();
        } catch (Exception e) {
            throw new Exception("AlmacenDao.removeCliente: Error: " + e.getMessage());
        } finally {
            oMysql.desconexion();
        }
    }
    
    
    
}
