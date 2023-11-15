package com.poly.repository;

import com.poly.database.DBConnect;
import com.poly.entity.HoaDonKhachHang;
import com.poly.entity.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {

    public List<KhachHang> getAllKhachHang() {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT id,ho_ten, ma, gioi_tinh, sdt, dia_chi, email, ngay_sinh, cap_bac, thoi_gian_tao, thoi_gian_sua FROM khach_hang where is_delete = 0";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
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

    public List<KhachHang> getAllKhachHangDaXoa() {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT id,ho_ten,ma, gioi_tinh, sdt, dia_chi, email, ngay_sinh, cap_bac, thoi_gian_tao, thoi_gian_sua FROM khach_hang where is_delete = 1";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
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

    public KhachHang getKhachHangById(String ma) {
        String sql = "SELECT id,ma, ho_ten, gioi_tinh, sdt, dia_chi, email, ngay_sinh, cap_bac, thoi_gian_tao, thoi_gian_sua FROM khach_hang WHERE ma = ? and is_delete = 0";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ma);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                KhachHang kh = new KhachHang();
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

    public boolean createKhachHang(KhachHang kh) {
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

    public boolean updateKhachHang(String ma, KhachHang kh) {
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

    public List<KhachHang> searchByName(String name) {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT id, ho_ten, gioi_tinh, sdt, dia_chi, email, ngay_sinh, cap_bac, thoi_gian_tao, thoi_gian_sua"
                + "FROM khach_hang WHERE is_delete = 0 AND ho_ten LIKE ?";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setId(rs.getInt("id"));
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

    public List<KhachHang> searchByNameAndGioiTinh(String name, int gioiTinh) {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT id, ho_ten, gioi_tinh, sdt, dia_chi, email, ngay_sinh, cap_bac, thoi_gian_tao, thoi_gian_sua "
                + "FROM khach_hang WHERE is_delete = 0 AND ho_ten LIKE ? and gioi_tinh = ?";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            ps.setInt(2, gioiTinh);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setId(rs.getInt("id"));
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

    public List<KhachHang> getAllKhachHangByGioiTinh(int gioiTinh) {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT id, ho_ten, gioi_tinh, sdt, dia_chi, email, ngay_sinh, cap_bac, thoi_gian_tao,thoi_gian_sua "
                + "FROM khach_hang WHERE is_delete = 0 AND gioi_tinh = ?";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, gioiTinh);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setId(rs.getInt("id"));
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

    public List<KhachHang> getAllKhachHangByCapBac(int capbac) {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT id,ma, ho_ten,gioi_tinh, sdt, dia_chi, email, ngay_sinh, cap_bac, thoi_gian_tao, thoi_gian_sua "
                + "FROM khach_hang WHERE is_delete = 0 AND cap_bac = ?";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, capbac);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
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

    public List<KhachHang> searchByNameKhachHangDaXoa(String name) {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT id,ma, ho_ten, gioi_tinh, sdt, dia_chi, email, ngay_sinh, cap_bac, thoi_gian_tao,thoi_gian_sua "
                + "FROM khach_hang WHERE is_delete = 1 AND ho_ten LIKE ?";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
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

        String sql = "SELECT hd.MaHoaDon, hd.NgayTao, hd.TongSanPham, hd.TongTienHoaDon, nv.ten, kh.ho_ten, "
                + "hd.SoTienDaGiam, hd.TongTienSauKhuyenMai, hd.TongTienPhaiTra, hd.GhiChu "
                + "FROM hoadon AS hd "
                + "JOIN nhan_vien AS nv ON hd.IDNhanVien = nv.id "
                + "JOIN khach_hang AS kh ON kh.id = hd.IDHoaDon "
                + "WHERE hd.IDKhachHang = ?";

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

    public int getTongSoTienDaTra(int idKhachHang) throws Exception {
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

    public void updateCapBacupdateCapBacTheoTien(int idKhachHang) throws Exception {
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

    public static void main(String[] args) {
        KhachHangRepository hangRepository = new KhachHangRepository();
        KhachHang kh = hangRepository.getKhachHangById("KH001");
        System.out.println(kh.toString());
    }

}
