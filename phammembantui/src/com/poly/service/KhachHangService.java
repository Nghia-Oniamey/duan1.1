/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.service;

import com.poly.entity.HoaDonKhachHang;
import com.poly.entity.KhachHang;
import com.poly.repository.KhachHangRepository;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhachHangService {

    KhachHangRepository khachHangRepository = new KhachHangRepository();

    public List<KhachHang> getAllKhachHang() {
        return khachHangRepository.getAllKhachHang();
    }

    public KhachHang getKhachHangById(String ma) {
        return khachHangRepository.getKhachHangById(ma);
    }

    public boolean createKhachHang(KhachHang kh) {
        return khachHangRepository.createKhachHang(kh);
    }

    public boolean updateKhachHang(String ma, KhachHang kh) {
        return khachHangRepository.updateKhachHang(ma, kh);
    }

    public boolean deleteKhachHangById(String ma) {
        return khachHangRepository.deleteKhachHangById(ma);
    }

    public List<KhachHang> getAllKhachHangDaXoa() {
        return khachHangRepository.getAllKhachHangDaXoa();
    }

    public List<KhachHang> searchByName(String name) {
        return khachHangRepository.searchByName(name);
    }

    public List<KhachHang> getAllKhachHangByGioiTinh(int gioiTinh) {
        return khachHangRepository.getAllKhachHangByGioiTinh(gioiTinh);
    }

    public List<KhachHang> searchByNameAndGioiTinh(String name, int gioiTinh) {
        return khachHangRepository.getAllKhachHangByGioiTinh(gioiTinh);
    }

    public List<KhachHang> getAllKhachHangByCapBac(int capbac) {
        return khachHangRepository.getAllKhachHangByCapBac(capbac);
    }

    public List<KhachHang> searchByNameKhachHangDaXoa(String name) {
        return khachHangRepository.searchByNameKhachHangDaXoa(name);
    }

    public boolean updateIsDeleteKhachHang(String ma) {
        return khachHangRepository.updateIsDeleteKhachHang(ma);
    }

    public boolean updateAllIsDeleteKhachHang() {
        return khachHangRepository.updateAllIsDeleteKhachHang();
    }

    public List<HoaDonKhachHang> getHoaDonByIdKhachHang(int idKhachHang) {
        return khachHangRepository.getHoaDonByIdKhachHang(idKhachHang);
    }

    public int getTongSoTienDaTra(int idKhachHang) {
        return khachHangRepository.getTongSoTienDaTra(idKhachHang);
    }

    public void updateCapBacTheoTien(int idKhachHang) {
        khachHangRepository.updateCapBacupdateCapBacTheoTien(idKhachHang);
    }

}
