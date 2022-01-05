/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Thriftshop.Thriftshop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author muham
 */
@Entity
@Table(name = "thrift")
@NamedQueries({
    @NamedQuery(name = "Thrift.findAll", query = "SELECT t FROM Thrift t"),
    @NamedQuery(name = "Thrift.findById", query = "SELECT t FROM Thrift t WHERE t.id = :id"),
    @NamedQuery(name = "Thrift.findByNamapemesan", query = "SELECT t FROM Thrift t WHERE t.namapemesan = :namapemesan"),
    @NamedQuery(name = "Thrift.findByNamabarang", query = "SELECT t FROM Thrift t WHERE t.namabarang = :namabarang"),
    @NamedQuery(name = "Thrift.findBySize", query = "SELECT t FROM Thrift t WHERE t.size = :size"),
    @NamedQuery(name = "Thrift.findByAlamatlengkap", query = "SELECT t FROM Thrift t WHERE t.alamatlengkap = :alamatlengkap"),
    @NamedQuery(name = "Thrift.findByNotelepon", query = "SELECT t FROM Thrift t WHERE t.notelepon = :notelepon"),
    @NamedQuery(name = "Thrift.findByJumlahpesanan", query = "SELECT t FROM Thrift t WHERE t.jumlahpesanan = :jumlahpesanan")})
public class Thrift implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "namapemesan")
    private String namapemesan;
    @Column(name = "namabarang")
    private String namabarang;
    @Column(name = "size")
    private String size;
    @Column(name = "alamatlengkap")
    private String alamatlengkap;
    @Column(name = "notelepon")
    private String notelepon;
    @Column(name = "jumlahpesanan")
    private Integer jumlahpesanan;

    public Thrift() {
    }

    public Thrift(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamapemesan() {
        return namapemesan;
    }

    public void setNamapemesan(String namapemesan) {
        this.namapemesan = namapemesan;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAlamatlengkap() {
        return alamatlengkap;
    }

    public void setAlamatlengkap(String alamatlengkap) {
        this.alamatlengkap = alamatlengkap;
    }

    public String getNotelepon() {
        return notelepon;
    }

    public void setNotelepon(String notelepon) {
        this.notelepon = notelepon;
    }

    public Integer getJumlahpesanan() {
        return jumlahpesanan;
    }

    public void setJumlahpesanan(Integer jumlahpesanan) {
        this.jumlahpesanan = jumlahpesanan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thrift)) {
            return false;
        }
        Thrift other = (Thrift) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Thriftshop.Thriftshop.Thrift[ id=" + id + " ]";
    }
    
}
