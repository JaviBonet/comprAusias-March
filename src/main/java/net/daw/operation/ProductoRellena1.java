package net.daw.operation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.daw.bean.ProductoBean;
import net.daw.dao.ProductoDao;
import net.daw.helper.Contexto;

public class ProductoRellena1 extends Operation {

    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/mensaje.jsp");
        ProductoBean oProductoBean = new ProductoBean();
        ProductoDao oProductoDao = new ProductoDao(oContexto.getEnumTipoConexion());

        ArrayList<String> uno = new ArrayList<>();
        ArrayList<String> dos = new ArrayList<>();
        ArrayList<String> tres = new ArrayList<>();

        uno.add("Llave");
        uno.add("Soldadura");
        uno.add("Pieza");
        uno.add("Bote");
        uno.add("Asadura");
        uno.add("Mecanizado");
        uno.add("Bote");
        uno.add("Manivela");
        uno.add("Pasante");
        uno.add("Rejilla");
        uno.add("Torno");
        uno.add("Accionamiento");
        uno.add("Fijación");
        uno.add("Bajante");
        uno.add("Sujeción");

        dos.add("auxiliar");
        dos.add("manual");
        dos.add("con rodadura");
        dos.add("extensivo");
        dos.add("intensivo");

        tres.add("de emergencia");
        tres.add("de repuesto");
        tres.add("de paso");
        tres.add("de acople");
        tres.add("de mano");

        Random generator;
        String primero;
        String segundo;
        String tercero;
        Integer contador = 0;
        Iterator<String> iterador1 = uno.listIterator();
        while (iterador1.hasNext()) {
            primero = iterador1.next();
            contador++;
            Iterator<String> iterador2 = dos.listIterator();
            while (iterador2.hasNext()) {
                segundo = iterador2.next();
                contador++;
                Iterator<String> iterador3 = tres.listIterator();
                while (iterador3.hasNext()) {
                    tercero = iterador3.next();
                    contador++;
                    generator = new Random();
                    oProductoBean.setId(0);
                    oProductoBean.setCodigo(Character.toUpperCase(primero.charAt(0)) + Character.toUpperCase(segundo.charAt(0)) + contador.toString() + Character.toUpperCase(tercero.charAt(0)));
                    oProductoBean.setDescripcion(primero + " " + segundo + " " + tercero);
                    oProductoBean.setPrecio(Double.parseDouble(Integer.toString(generator.nextInt(2000)) + "." + Integer.toString(generator.nextInt(99))));
                    try {
                        oProductoDao.set(oProductoBean);

                    } catch (Exception e) {
                        throw new ServletException("ProductoController: Update Error: Phase 2: " + e.getMessage());
                    }

                }
            }
        }
        return "OK- información generada.";
    }
}
