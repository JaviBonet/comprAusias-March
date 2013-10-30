package net.daw.bean;

public class ProductoBean {

    private int id = 0;
    private String codigo = "";
    private String descripcion = "";
    private Double precio = 0.0;
    private TipoproductoBean tipoProducto = null;

    public ProductoBean() {
        this.tipoProducto = new TipoproductoBean();
    }

    public ProductoBean(int id) {
        this.id = id;
        this.tipoProducto = new TipoproductoBean();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public TipoproductoBean getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoproductoBean tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

}
