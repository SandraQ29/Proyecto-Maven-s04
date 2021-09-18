package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "tb_productos")
@Data
@NoArgsConstructor
public class Producto {
@Id
@Column (name="idprod")
 private String idProducto;
@Column (name="descripcion")
 private String descripcionString;
@Column (name="stock")
 private int stock;
@Column (name="precio")
 private double precio;
@Column (name="idcategoria")
 private int categoria;
@Column (name="estado")
 private int estado;

public Producto(String idProducto, String descripcionString, int stock, double precio, int categoria) {

	this.idProducto = idProducto;
	this.descripcionString = descripcionString;
	this.stock = stock;
	this.precio = precio;
	this.categoria = categoria;
	this.estado =1;
}


 
 
 
 
}
