/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.entity;

import java.sql.Date;

//CREATE TABLE khach_hang(
//	id INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
//	ho_ten VARCHAR(50) NOT NULL,
//	gioi_tinh BIT,
//	sdt VARCHAR(12),
//	dia_chi VARCHAR(255) ,
//	email VARCHAR(125) NOT NULL,
//	ngay_sinh DATE ,
//	cap_bac int,
//	thoi_gian_tao DATE,
//	thoi_gian_sua DATE,
//)

public class KhachHang {
    private int id;
    private String hoTen;
    private boolean gioiTinh;
    private String sdt;
    private String diaChi;
    private String email;
    private Date NgaySinh;
    private int capBac;
    private Date thoiGianTao;
    private Date thoiGianSua;
    private boolean isDelete;
    private String ma;
    
    public KhachHang() {
    }

    public KhachHang(String hoTen, boolean gioiTinh, String sdt, String diaChi, String email, Date NgaySinh, int capBac, Date thoiGianSua, boolean isDelete, String ma) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.email = email;
        this.NgaySinh = NgaySinh;
        this.capBac = capBac;
        this.thoiGianSua = thoiGianSua;
        this.isDelete = isDelete;
        this.ma = ma;
    }

    public KhachHang(int id, String hoTen, boolean gioiTinh, String sdt, String diaChi, String email, Date NgaySinh, Date thoiGianTao, Date thoiGianSua, boolean isDelete, String ma) {
        this.id = id;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.email = email;
        this.NgaySinh = NgaySinh;
        this.thoiGianTao = thoiGianTao;
        this.thoiGianSua = thoiGianSua;
        this.isDelete = isDelete;
        this.ma = ma;
    }



    public KhachHang(int id, String hoTen, boolean gioiTinh, String sdt, String diaChi, String email, Date NgaySinh, int capBac, Date thoiGianTao) {
        this.id = id;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.email = email;
        this.NgaySinh = NgaySinh;
        this.capBac = capBac;
        this.thoiGianTao = thoiGianTao;
    }

    public KhachHang(String hoTen, boolean gioiTinh, String sdt, String diaChi, String email, Date NgaySinh, int capBac, Date thoiGianTao, Date thoiGianSua, boolean isDelete) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.email = email;
        this.NgaySinh = NgaySinh;
        this.capBac = capBac;
        this.thoiGianTao = thoiGianTao;
        this.thoiGianSua = thoiGianSua;
        this.isDelete = isDelete;
    }
    
    
    
    public KhachHang(String hoTen, boolean gioiTinh, String sdt, String diaChi, String email, Date NgaySinh, int capBac) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.email = email;
        this.NgaySinh = NgaySinh;
        this.capBac = capBac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public int getCapBac() {
        return capBac;
    }

    public void setCapBac(int capBac) {
        this.capBac = capBac;
    }

    public Date getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Date thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public Date getThoiGianSua() {
        return thoiGianSua;
    }

    public void setThoiGianSua(Date thoiGianSua) {
        this.thoiGianSua = thoiGianSua;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }
    

    @Override
    public String toString() {
        return "KhachHang{" + "id=" + id + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", sdt=" + sdt + ", diaChi=" + diaChi + ", email=" + email + ", NgaySinh=" + NgaySinh + ", capBac=" + capBac + ", thoiGianTao=" + thoiGianTao + ", thoiGianSua=" + thoiGianSua + '}';
    }

    public int getGioiTinh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getTen() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
}
