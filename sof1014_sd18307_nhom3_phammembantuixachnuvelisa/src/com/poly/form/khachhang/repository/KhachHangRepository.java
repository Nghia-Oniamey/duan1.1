/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.form.khachhang.repository;

import com.poly.database.DBConnect;
import com.poly.form.khachhang.entity.HoaDonKhachHang;
import com.poly.form.khachhang.entity.KhachHangHung;
import com.poly.form.khachhang.entity.SanPhamKhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {

    public List<KhachHangHung> getAllKhachHang() {
        List<KhachHangHung> list = new ArrayList<>();
        String sql = "SELECT id,ho_ten, ma, gioi_tinh, sdt, dia_chi, email, ngay_sinh, cap_bac, thoi_gian_tao, thoi_gian_sua FROM khach_hang where is_delete = 0 ORDER BY thoi_gian_tao DESC";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangHung kh = new KhachHangHung();
                kh.setId(rs.getInt("id"));
                kh.setMa(rs.getString("ma"));
                kh.setHoTen(rs.getString("ho_ten"));
                kh.setGioiTinh(rs.getBoolean("gioi_tinh"));
                kh.setSdt(rs.getString("sdt"));
                kh.setDiaChi(rs.getString("dia_chi"));
                kh.setEmail(rs.getString("email"));
                kh.setNgaySinh(rs.getDate("ngay_sinh"));
                kh.setCapBac(rs.getInt("cap_bac"));
                kh.setThoiGianTao(rs.getDate("thoi_gian_tao"));
                kh.setThoiGianSua(rs.getDate("thoi_gian_sua"));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<KhachHangHung> getAllKhachHangDaXoa() {
        List<KhachHangHung> list = new ArrayList<>();
        String sql = "SELECT id,ho_ten,ma, gioi_tinh, sdt, dia_chi, email, ngay_sinh, cap_bac, thoi_gian_tao, thoi_gian_sua FROM khach_hang where is_delete = 1";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangHung kh = new KhachHangHung();
                kh.setId(rs.getInt("id"));
                kh.setMa(rs.getString("ma"));
                kh.setHoTen(rs.getString("ho_ten"));
                kh.setGioiTinh(rs.getBoolean("gioi_tinh"));
                kh.setSdt(rs.getString("sdt"));
                kh.setDiaChi(rs.getString("dia_chi"));
                kh.setEmail(rs.getString("email"));
                kh.setNgaySinh(rs.getDate("ngay_sinh"));
                kh.setCapBac(rs.getInt("cap_bac"));
                kh.setThoiGianTao(rs.getDate("thoi_gian_tao"));
                kh.setThoiGianSua(rs.getDate("thoi_gian_sua"));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public KhachHangHung getKhachHangById(String ma) {
        String sql = "SELECT id,ma, ho_ten, gioi_tinh, sdt, dia_chi, email, ngay_sinh, cap_bac, thoi_gian_tao, thoi_gian_sua FROM khach_hang WHERE ma = ? and is_delete = 0";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ma);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                KhachHangHung kh = new KhachHangHung();
                kh.setId(rs.getInt("id"));
                kh.setMa(rs.getString("ma"));
                kh.setHoTen(rs.getString("ho_ten"));
                kh.setGioiTinh(rs.getBoolean("gioi_tinh"));
                kh.setSdt(rs.getString("sdt"));
                kh.setDiaChi(rs.getString("dia_chi"));
                kh.setEmail(rs.getString("email"));
                kh.setNgaySinh(rs.getDate("ngay_sinh"));
                kh.setCapBac(rs.getInt("cap_bac"));
                kh.setThoiGianTao(rs.getDate("thoi_gian_tao"));
                kh.setThoiGianSua(rs.getDate("thoi_gian_sua"));
                return kh;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean createKhachHang(KhachHangHung kh) {
        int check = 0;
        String sql = "INSERT INTO khach_hang (ma, ho_ten, gioi_tinh, sdt, dia_chi, email, ngay_sinh, cap_bac, thoi_gian_tao, thoi_gian_sua, is_delete) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getHoTen());
            ps.setBoolean(3, kh.isGioiTinh());
            ps.setString(4, kh.getSdt());
            ps.setString(5, kh.getDiaChi());
            ps.setString(6, kh.getEmail());
            ps.setDate(7, kh.getNgaySinh());
            ps.setInt(8, kh.getCapBac());
            ps.setDate(9, kh.getThoiGianTao());
            ps.setDate(10, kh.getThoiGianSua());
            ps.setObject(11, 0);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check > 0;
    }

    public boolean updateKhachHang(String ma, KhachHangHung kh) {
        int check = 0;
        String sql = "UPDATE khach_hang set ho_ten = ?, gioi_tinh = ?, sdt = ?, dia_chi = ?, email = ?, ngay_sinh = ?, cap_bac = ?,thoi_gian_sua = ?, is_delete = ? where ma = ? and is_delete = 0";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, kh.getHoTen());
            ps.setBoolean(2, kh.isGioiTinh());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getDiaChi());
            ps.setString(5, kh.getEmail());
            ps.setDate(6, kh.getNgaySinh());
            ps.setInt(7, kh.getCapBac());
            ps.setDate(8, kh.getThoiGianSua());
            ps.setObject(9, 0);
            ps.setString(10, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check > 0;
    }

    public boolean deleteKhachHangById(String ma) {
        int check = 0;
        String sql = "UPDATE khach_hang SET is_delete = 1 WHERE ma = ?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public List<KhachHangHung> searchByNameOrPhoneOrCode(String keyword) {
        List<KhachHangHung> list = new ArrayList<>();
        String sql = "SELECT k.id, k.ma, k.ho_ten, k.gioi_tinh, k.sdt, k.dia_chi, k.email, k.ngay_sinh, k.cap_bac, k.thoi_gian_tao, k.thoi_gian_sua "
                + "FROM khach_hang AS k WHERE (k.ho_ten LIKE ? OR k.sdt LIKE ? OR k.ma LIKE ?) AND k.is_delete = 0";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            String keywordPattern = "%" + keyword + "%";
            ps.setString(1, keywordPattern);
            ps.setString(2, keywordPattern);
            ps.setString(3, keywordPattern);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangHung kh = new KhachHangHung();
                kh.setId(rs.getInt("id"));
                kh.setMa(rs.getString("ma"));
                kh.setHoTen(rs.getString("ho_ten"));
                kh.setGioiTinh(rs.getBoolean("gioi_tinh"));
                kh.setSdt(rs.getString("sdt"));
                kh.setDiaChi(rs.getString("dia_chi"));
                kh.setEmail(rs.getString("email"));
                kh.setNgaySinh(rs.getDate("ngay_sinh"));
                kh.setCapBac(rs.getInt("cap_bac"));
                kh.setThoiGianTao(rs.getDate("thoi_gian_tao"));
                kh.setThoiGianSua(rs.getDate("thoi_gian_sua"));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<KhachHangHung> searchByNameAndGioiTinh(String name, int gioiTinh) {
        List<KhachHangHung> list = new ArrayList<>();
        String sql = "SELECT id,ma, ho_ten, gioi_tinh, sdt, dia_chi, email, ngay_sinh, cap_bac, thoi_gian_tao, thoi_gian_sua "
                + "FROM khach_hang WHERE is_delete = 0 AND ho_ten LIKE ? and gioi_tinh = ?";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            ps.setInt(2, gioiTinh);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangHung kh = new KhachHangHung();
                kh.setId(rs.getInt("id"));
                kh.setMa(rs.getString("ma"));
                kh.setHoTen(rs.getString("ho_ten"));
                kh.setGioiTinh(rs.getBoolean("gioi_tinh"));
                kh.setSdt(rs.getString("sdt"));
                kh.setDiaChi(rs.getString("dia_chi"));
                kh.setEmail(rs.getString("email"));
                kh.setNgaySinh(rs.getDate("ngay_sinh"));
                kh.setCapBac(rs.getInt("cap_bac"));
                kh.setThoiGianTao(rs.getDate("thoi_gian_tao"));
                kh.setThoiGianSua(rs.getDate("thoi_gian_sua"));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<KhachHangHung> getAllKhachHangByGioiTinh(int gioiTinh) {
        List<KhachHangHung> list = new ArrayList<>();
        String sql = "SELECT id,ma, ho_ten, gioi_tinh, sdt, dia_chi, email, ngay_sinh, cap_bac, thoi_gian_tao,thoi_gian_sua "
                + "FROM khach_hang WHERE is_delete = 0 AND gioi_tinh = ?";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, gioiTinh);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangHung kh = new KhachHangHung();
                kh.setId(rs.getInt("id"));
                kh.setMa(rs.getString("ma"));
                kh.setHoTen(rs.getString("ho_ten"));
                kh.setGioiTinh(rs.getBoolean("gioi_tinh"));
                kh.setSdt(rs.getString("sdt"));
                kh.setDiaChi(rs.getString("dia_chi"));
                kh.setEmail(rs.getString("email"));
                kh.setNgaySinh(rs.getDate("ngay_sinh"));
                kh.setCapBac(rs.getInt("cap_bac"));
                kh.setThoiGianTao(rs.getDate("thoi_gian_tao"));
                kh.setThoiGianSua(rs.getDate("thoi_gian_sua"));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<KhachHangHung> getAllKhachHangByCapBac(int capbac) {
        List<KhachHangHung> list = new ArrayList<>();
        String sql = "SELECT id,ma, ho_ten,gioi_tinh, sdt, dia_chi, email, ngay_sinh, cap_bac, thoi_gian_tao, thoi_gian_sua "
                + "FROM khach_hang WHERE is_delete = 0 AND cap_bac = ?";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, capbac);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangHung kh = new KhachHangHung();
                kh.setId(rs.getInt("id"));
                kh.setMa(rs.getString("ma"));
                kh.setHoTen(rs.getString("ho_ten"));
                kh.setGioiTinh(rs.getBoolean("gioi_tinh"));
                kh.setSdt(rs.getString("sdt"));
                kh.setDiaChi(rs.getString("dia_chi"));
                kh.setEmail(rs.getString("email"));
                kh.setNgaySinh(rs.getDate("ngay_sinh"));
                kh.setCapBac(rs.getInt("cap_bac"));
                kh.setThoiGianTao(rs.getDate("thoi_gian_tao"));
                kh.setThoiGianSua(rs.getDate("thoi_gian_sua"));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<KhachHangHung> searchByNameKhachHangDaXoa(String name) {
        List<KhachHangHung> list = new ArrayList<>();
        String sql = "SELECT id,ma, ho_ten, gioi_tinh, sdt, dia_chi, email, ngay_sinh, cap_bac, thoi_gian_tao,thoi_gian_sua "
                + "FROM khach_hang WHERE is_delete = 1 AND ho_ten LIKE ?";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangHung kh = new KhachHangHung();
                kh.setId(rs.getInt("id"));
                kh.setMa(rs.getString("ma"));
                kh.setHoTen(rs.getString("ho_ten"));
                kh.setGioiTinh(rs.getBoolean("gioi_tinh"));
                kh.setSdt(rs.getString("sdt"));
                kh.setDiaChi(rs.getString("dia_chi"));
                kh.setEmail(rs.getString("email"));
                kh.setNgaySinh(rs.getDate("ngay_sinh"));
                kh.setCapBac(rs.getInt("cap_bac"));
                kh.setThoiGianTao(rs.getDate("thoi_gian_tao"));
                kh.setThoiGianTao(rs.getDate("thoi_gian_sua"));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateIsDeleteKhachHang(String ma) {
        int check = 0;
        String sql = "UPDATE khach_hang set is_delete = ? where ma = ? and is_delete = 1";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, 0);
            ps.setString(2, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check > 0;
    }

    public boolean updateAllIsDeleteKhachHang() {
        int check = 0;
        String sql = "UPDATE khach_hang set is_delete = ? where is_delete = 1";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, 0);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check > 0;
    }

    public List<HoaDonKhachHang> getHoaDonByIdKhachHang(int idKhachHang) {
        List<HoaDonKhachHang> hoaDonList = new ArrayList<>();

        String sql = " SELECT \n"
                + "    hd.MaHoaDon, \n"
                + "    hd.NgayTao, \n"
                + "    COUNT(hdsp.ID) AS TongSanPham,\n"
                + "    hd.TongTienHoaDon, \n"
                + "    nv.ten, \n"
                + "    kh.ho_ten, \n"
                + "    hd.SoTienDaGiam, \n"
                + "    hd.TongTienSauKhuyenMai, \n"
                + "    hd.TongTienPhaiTra, \n"
                + "    hd.GhiChu \n"
                + "FROM \n"
                + "    HoaDon hd \n"
                + "JOIN \n"
                + "    nhan_vien nv ON hd.IDNhanVien = nv.id \n"
                + "JOIN \n"
                + "    khach_hang kh ON kh.id = hd.IDKhachHang \n"
                + "LEFT JOIN \n"
                + "    HoaDon_SanPham hdsp ON hd.IDHoaDon = hdsp.IDHoaDon\n"
                + "WHERE \n"
                + "  kh.id = ?\n"
                + "GROUP BY \n"
                + "    hd.MaHoaDon, hd.NgayTao, hd.TongTienHoaDon, nv.ten, kh.ho_ten, \n"
                + "	hd.SoTienDaGiam, hd.TongTienSauKhuyenMai, hd.TongTienPhaiTra, hd.GhiChu;";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idKhachHang);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                HoaDonKhachHang hoaDon = new HoaDonKhachHang(
                        rs.getString("MaHoaDon"),
                        rs.getDate("NgayTao"),
                        rs.getInt("TongSanPham"),
                        rs.getDouble("TongTienHoaDon"),
                        rs.getString("ten"),
                        rs.getString("ho_ten"),
                        rs.getDouble("SoTienDaGiam"),
                        rs.getDouble("TongTienSauKhuyenMai"),
                        rs.getDouble("TongTienPhaiTra"),
                        rs.getString("GhiChu")
                );
                hoaDonList.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hoaDonList;
    }

    public List<HoaDonKhachHang> getHoaDonByIdKhachHangAndMaHoaDon(int idKhachHang, String maHd) {
        List<HoaDonKhachHang> hoaDonList = new ArrayList<>();

        String sql = "  SELECT \n"
                + "       hd.MaHoaDon, \n"
                + "       hd.NgayTao, \n"
                + "       COUNT(hdsp.ID) AS TongSanPham, \n"
                + "        hd.TongTienHoaDon, \n"
                + "        nv.ten, \n"
                + "      kh.ho_ten, \n"
                + "       hd.SoTienDaGiam, \n"
                + "       hd.TongTienSauKhuyenMai, \n"
                + "        hd.TongTienPhaiTra, \n"
                + "       hd.GhiChu \n"
                + "      FROM \n"
                + "    HoaDon hd \n"
                + "       JOIN \n"
                + "       nhan_vien nv ON hd.IDNhanVien = nv.id \n"
                + "       JOIN \n"
                + "        khach_hang kh ON kh.id = hd.IDKhachHang \n"
                + "        LEFT JOIN \n"
                + "       HoaDon_SanPham hdsp ON hd.IDHoaDon = hdsp.IDHoaDon\n"
                + "      WHERE \n"
                + "        kh.id = ? AND hd.MaHoaDon LIKE ? \n"
                + "        GROUP BY \n"
                + "        hd.MaHoaDon, hd.NgayTao, hd.TongTienHoaDon, nv.ten, kh.ho_ten, \n"
                + "        hd.SoTienDaGiam, hd.TongTienSauKhuyenMai, hd.TongTienPhaiTra, hd.GhiChu;";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idKhachHang);
            ps.setString(2, "%" + maHd + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                HoaDonKhachHang hoaDon = new HoaDonKhachHang(
                        rs.getString("MaHoaDon"),
                        rs.getDate("NgayTao"),
                        rs.getInt("TongSanPham"),
                        rs.getDouble("TongTienHoaDon"),
                        rs.getString("ten"),
                        rs.getString("ho_ten"),
                        rs.getDouble("SoTienDaGiam"),
                        rs.getDouble("TongTienSauKhuyenMai"),
                        rs.getDouble("TongTienPhaiTra"),
                        rs.getString("GhiChu")
                );
                hoaDonList.add(hoaDon);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return hoaDonList;
    }

    public int getTongSoTienDaTra(int idKhachHang) {
        int tongSoTienDaTra = 0;

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT SUM(TongTienHoaDon) FROM HoaDon WHERE IDKhachHang = ?")) {
            ps.setInt(1, idKhachHang);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tongSoTienDaTra = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tongSoTienDaTra;
    }

    public void updateCapBacupdateCapBacTheoTien(int idKhachHang) {
        int tongSoTienDaTra = getTongSoTienDaTra(idKhachHang);

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement("UPDATE khach_hang SET cap_bac = ? WHERE id = ?")) {
            int newCapBac = 1;

            if (tongSoTienDaTra >= 10000000) {
                newCapBac = 2;
            }

            if (tongSoTienDaTra >= 40000000) {
                newCapBac = 3;
            }

            ps.setInt(1, newCapBac);
            ps.setInt(2, idKhachHang);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SanPhamKhachHang> getSanPhamKhachHangTuHoaDon(String maKhachhang) {
        List<SanPhamKhachHang> sanPhamList = new ArrayList<>();
        String sql = "SELECT sp.maSanPham, sp.TenSanPham, sp.MoTaSanPham, tl.TenTheLoai \n" +
"                FROM HoaDon hd \n" +
"				JOIN HoaDon_SanPham hdsp ON hd.IDHoaDon = hdsp.IDHoaDon \n" +
"                JOIN SanPham sp ON hdsp.IDSanPham = sp.IDSanPham\n" +
"				JOIN TheLoai tl on sp.IDTheLoai = tl.IDTheLoai \n" +
"                WHERE hd.MaHoaDon = ? \n" +
"                ORDER BY sp.maSanPham ASC;";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maKhachhang);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPhamKhachHang sanPhamKhachHang = new SanPhamKhachHang();
                sanPhamKhachHang.setMaSanPham(rs.getString("maSanPham"));
                sanPhamKhachHang.setTenSanPham(rs.getString("TenSanPham"));
                sanPhamKhachHang.setMoTa(rs.getString("MoTaSanPham"));
                sanPhamKhachHang.setTheLoai(rs.getString("TenTheLoai"));
                sanPhamList.add(sanPhamKhachHang);
            }
            return sanPhamList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("eee");
        KhachHangRepository hangRepository = new KhachHangRepository();
        List<HoaDonKhachHang> lits = hangRepository.getHoaDonByIdKhachHangAndMaHoaDon(1, "HD0002");
        for (HoaDonKhachHang hd : lits) {
            System.out.println(hd.toString());
        }
    }

}
