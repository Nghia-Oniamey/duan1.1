package com.poly.form.khuyenmai.khuyenmai_sanpham.service;

import com.poly.form.khuyenmai.khuyenmai_sanpham.entity.SanPhamChiTietForKhuyenMaiResponse;
import com.poly.form.khuyenmai.khuyenmai_sanpham.entity.SanPhamForKhuyenMaiResponse;
import java.util.List;

public interface SanPhamForKhuyenMaiService {

    SanPhamChiTietForKhuyenMaiResponse getSanPhamChiTietForKhuyenMaiResponse(List<SanPhamChiTietForKhuyenMaiResponse> list, String ma);
    
    SanPhamForKhuyenMaiResponse getSanPhamForKhuyenMaiResponSe(List<SanPhamForKhuyenMaiResponse> list, String ma);
    
    List<SanPhamChiTietForKhuyenMaiResponse> findSanPhamChiTietForKhuyenMaiResponseByMaSanPham(Long id);
    
}
