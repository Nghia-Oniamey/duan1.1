package com.poly.entity.khuyenmai;

public class KhuyenMaiTheoSanPhamRequest {

    private String ma;

    private String ten;

    private Integer giaTri;

    private Long ngayBatDau;

    private Long ngayKetThuc;

    private Boolean trangThai;

    private Long thoiDiemHienTai;

    public KhuyenMaiTheoSanPhamRequest() {
    }

    public KhuyenMaiTheoSanPhamRequest(String ma, String ten, Integer giaTri, Long ngayBatDau, Long ngayKetThuc, Boolean trangThai, Long thoiDiemHienTai) {
        this.ma = ma;
        this.ten = ten;
        this.giaTri = giaTri;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
        this.thoiDiemHienTai = thoiDiemHienTai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(Integer giaTri) {
        this.giaTri = giaTri;
    }

    public Long getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Long ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Long getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Long ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Long getThoiDiemHienTai() {
        return thoiDiemHienTai;
    }

    public void setThoiDiemHienTai(Long thoiDiemHienTai) {
        this.thoiDiemHienTai = thoiDiemHienTai;
    }

}