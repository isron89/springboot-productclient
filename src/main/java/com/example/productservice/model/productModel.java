package com.example.productservice.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class productModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "price")
    private Integer price;

    @Column(name = "qty")
    private Integer qty;

    public productModel() {

    }
    public productModel(String nama, Integer price, Integer qty) {
        this.nama = nama;
        this.price = price;
        this.qty = qty;
    }

//    public long getId() {
//        return id;
//    }
//    public String getNama() {
//        return nama;
//    }
//    public void setNama(String nama) {
//        this.nama = nama;
//    }
//    public Integer getPrice() {
//        return price;
//    }
//    public void setPrice(Integer price) {
//        this.price = price;
//    }
//    public Integer getQty() {
//        return qty;
//    }
//    public void setQty(Integer qty) {
//        this.qty = qty;
//    }

    @Override
    public String toString() {
        return "Product [Id=" + id + ", Name=" + nama + ", Price=" + price + ", Quantity=" + qty + "]";
    }
}

