package com.poly.form.khuyenmai.khuyenmai_sanpham.service.impl;

import com.poly.form.khuyenmai.khuyenmai_sanpham.entity.SanPhamChiTietForKhuyenMaiResponse;
import com.poly.form.khuyenmai.khuyenmai_sanpham.entity.SanPhamForKhuyenMaiResponse;
import com.poly.form.khuyenmai.khuyenmai_sanpham.repository.KMSanPhamRepository;
import com.poly.form.khuyenmai.khuyenmai_sanpham.service.SanPhamForKhuyenMaiService;
import java.util.List;

public class SanPhamForKhuyenMaiServiceImpl implements SanPhamForKhuyenMaiService{
    
    private KMSanPhamRepository repo = new KMSanPhamRepository();

    @Override
    public SanPhamChiTietForKhuyenMaiResponse getSanPhamChiTietForKhuyenMaiResponse(List<SanPhamChiTietForKhuyenMaiResponse> list, String ma) {
        for (SanPhamChiTietForKhuyenMaiResponse sanPhamForKhuyenMaiResponse : list) {
            if(sanPhamForKhuyenMaiResponse.getMaSanPham().equalsIgnoreCase(ma)){
                return sanPhamForKhuyenMaiResponse;
            }
        }
        return null;
    }

    @Override
    public List<SanPhamChiTietForKhuyenMaiResponse> findSanPhamChiTietForKhuyenMaiResponseByMaSanPham(Long id) {
        return repo.findSanPhamChiTietByMaSanPham(id);
    }

    @Override
    public SanPhamForKhuyenMaiResponse getSanPhamForKhuyenMaiResponSe(List<SanPhamForKhuyenMaiResponse> list, String ma) {
        for (SanPhamForKhuyenMaiResponse sanPhamForKhuyenMaiResponse : list) {
            if(sanPhamForKhuyenMaiResponse.getMa().equalsIgnoreCase(ma)){
                return sanPhamForKhuyenMaiResponse;
            }
        }
        return null;
    }

}
