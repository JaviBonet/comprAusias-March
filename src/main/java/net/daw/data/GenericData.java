/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.data;

import java.util.ArrayList;
import net.daw.helper.Enum;

/**
 *
 * @author rafa
 */
public interface GenericData {

    public abstract void commitTrans() throws Exception;

    public abstract void conexion(Enum.Connection tipo) throws Exception;

    public abstract void desconexion() throws Exception;

    public abstract Boolean existsOne(String tabla, int id) throws Exception;

    public abstract String getId(String tabla, String campo, String valor) throws Exception;

    public abstract String getOne(String tabla, String campo, int id) throws Exception;

    public abstract ArrayList<Integer> getPage(String tabla, int rpp, int pagina, String orden) throws Exception;

    public abstract int getPages(String tabla, int rpp) throws Exception;

    public abstract void initTrans() throws Exception;

    public abstract int insertOne(String tabla) throws Exception;

    public abstract void removeOne(int id, String tabla) throws Exception;

    public abstract void rollbackTrans() throws Exception;
    
    public void setNull(int intId, String strTabla, String strCampo) throws Exception;

    public abstract void updateOne(int id, String tabla, String campo, String valor) throws Exception;
    
    public abstract ArrayList<String> getNeighborhood(String link, int page_number, int total_pages, int neighborhood) throws Exception;
}
