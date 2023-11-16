package com.poly.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.poly.database.DBConnect;
import com.poly.entity.khuyenmai.KhuyenMaiTheoSanPham;
import com.poly.entity.khuyenmai.KhuyenMaiTheoSanPhamRequest;

public class KhuyenMaiTheoSanPhamReposirory {

    public List<KhuyenMaiTheoSanPham> getAllDataKhuyenMai() throws Exception {
        String query = "SELECT * FROM khuyen_mai ORDER BY thoi_gian_tao DESC ";
        List<KhuyenMaiTheoSanPham> listKhuyenMai = new ArrayList<>();

        try (Connection conn = DBConnect.getConnection(); PreparedStatement ps
                = conn.prepareStatement(query)) {
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String ten = rs.getString("ten_khuyen_mai");
                String ma = rs.getString("ma_khuyen_mai");
                Integer giaGiam = rs.getInt("phan_tram_giam_gia");
                Long thoiGianBatDau = rs.getLong("thoi_gian_bat_dau");
                Long thoiGianKetThuc = rs.getLong("thoi_gian_ket_thuc");
                Long thoiGianSua = rs.getLong("thoi_gian_sua");
                Long thoiGianTao = rs.getLong("thoi_gian_tao");
                Boolean trangThai = rs.getBoolean("trang_thai");
                listKhuyenMai.add(new KhuyenMaiTheoSanPham(id, ma, ten, giaGiam,
                        thoiGianBatDau, thoiGianKetThuc,
                        thoiGianTao, thoiGianSua, trangThai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhuyenMai;
    }

    public ArrayList<KhuyenMaiTheoSanPham> getPhanTrang(int trang) {
        ArrayList<KhuyenMaiTheoSanPham> list = new ArrayList<>();
        String query = "SELECT TOP 6 * FROM khuyen_mai where MAHD not in (SELECT TOP " + "(? * 6 - 6)"
                + "ma_khuyen_mai FROM khuyen_mai ORDER BY  DESC) AND (TRANGTHAI=1 OR TRANGTHAI=2) ORDER BY NGAYTAO DESC ";
        try (Connection conn = DBConnect.getConnection(); PreparedStatement ps
                = conn.prepareStatement(query)) {
            ps.setInt(1, trang);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String ten = rs.getString("ten_khuyen_mai");
                String ma = rs.getString("ma_khuyen_mai");
                Integer giaGiam = rs.getInt("phan_tram_giam_gia");
                Long thoiGianBatDau = rs.getLong("thoi_gian_bat_dau");
                Long thoiGianKetThuc = rs.getLong("thoi_gian_ket_thuc");
                Long thoiGianSua = rs.getLong("thoi_gian_sua");
                Long thoiGianTao = rs.getLong("thoi_gian_tao");
                Boolean trangThai = rs.getBoolean("trang_thai");
                list.add(new KhuyenMaiTheoSanPham(id, ma, ten, giaGiam,
                        thoiGianBatDau, thoiGianKetThuc,
                        thoiGianTao, thoiGianSua, trangThai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Long countAllHD() throws Exception{
        String query = "SELECT count(*) From khuyen_mai as trang";

        try (Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.execute();

            ResultSet rs = ps.getResultSet();

            Long count = null;

            while (rs.next()) {
                count = rs.getLong("trang");
            }

            return count;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void themKhuyenMai(KhuyenMaiTheoSanPham khuyenMaiTheoSanPham)
            throws Exception {
        String query = "INSERT INTO khuyen_mai (ten_khuyen_mai ,ma_khuyen_mai,"
                + " phan_tram_giam_gia, thoi_gian_bat_dau, thoi_gian_ket_thuc,"
                + " thoi_gian_sua, thoi_gian_tao, trang_thai) VALUES"
                + "(?, ? ,?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnect.getConnection(); PreparedStatement ps
                = conn.prepareStatement(query)) {
            ps.setString(1, khuyenMaiTheoSanPham.getTen());
            ps.setString(2, khuyenMaiTheoSanPham.getMa());
            ps.setInt(3, khuyenMaiTheoSanPham.getGiaTri());
            ps.setLong(4, khuyenMaiTheoSanPham.getNgayBatDau());
            ps.setLong(5, khuyenMaiTheoSanPham.getNgayKetThuc());
            ps.setLong(6, khuyenMaiTheoSanPham.getThoiGianSua());
            ps.setLong(7, khuyenMaiTheoSanPham.getThoiGianTao());
            ps.setBoolean(8, khuyenMaiTheoSanPham.getTrangThai());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void suaKhuyenMai(KhuyenMaiTheoSanPham khuyenMaiTheoSanPham) throws Exception {
        String query = "UPDATE khuyen_mai "
                + "SET ten_khuyen_mai = ?, "
                + "phan_tram_giam_gia = ?, "
                + "thoi_gian_bat_dau = ?, "
                + "thoi_gian_ket_thuc = ?, "
                + "thoi_gian_sua = ?, "
                + "trang_thai = ? "
                + "WHERE ma_khuyen_mai = ?";

        try (Connection conn = DBConnect.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, khuyenMaiTheoSanPham.getTen());
            ps.setInt(2, khuyenMaiTheoSanPham.getGiaTri());
            ps.setLong(3, khuyenMaiTheoSanPham.getNgayBatDau());
            ps.setLong(4, khuyenMaiTheoSanPham.getNgayKetThuc());
            ps.setLong(5, khuyenMaiTheoSanPham.getThoiGianSua());
            ps.setBoolean(6, khuyenMaiTheoSanPham.getTrangThai());
            ps.setString(7, khuyenMaiTheoSanPham.getMa());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void capNhatTrangThaiKhuyenMaiBangMa(String maKhuyenMai, boolean trangThai) throws Exception {
        String query = "UPDATE khuyen_mai SET trang_thai = ? WHERE ma_khuyen_mai = ?";

        try (Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setBoolean(1, trangThai);
            ps.setString(2, maKhuyenMai);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void timKiemTheoNhieuTruong(KhuyenMaiTheoSanPhamRequest khuyenMaiTheoSanPham) throws Exception {
        String query = "SELECT * FROM khuyen_mai WHERE "
                + "(? IS NULL OR ten_khuyen_mai LIKE ?) "
                + "AND (? IS NULL OR ma_khuyen_mai LIKE ?) "
                + "AND (? IS NULL OR phan_tram_giam_gia = ?) "
                + "AND ("
                + "(? IS NULL OR ? IS NULL) "
                + "OR ("
                + "(? IS NOT NULL AND ? IS NOT NULL) "
                + "AND (? BETWEEN thoi_gian_bat_dau AND thoi_gian_ket_thuc) "
                + "AND (? BETWEEN thoi_gian_bat_dau AND thoi_gian_ket_thuc)"
                + ") OR ("
                + "(? IS NOT NULL AND ? >= ?) "
                + "AND (? IS NOT NULL AND ? <= ?) "
                + "AND (thoi_gian_bat_dau <= thoi_gian_ket_thuc)"
                + ")) AND ( ? IS NULL OR trang_thai = ? )";

        try (Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, "%" + khuyenMaiTheoSanPham.getTen() + "%");
            ps.setString(2, "%" + khuyenMaiTheoSanPham.getTen() + "%");
            ps.setString(3, "%" + khuyenMaiTheoSanPham.getMa() + "%");
            ps.setString(4, "%" + khuyenMaiTheoSanPham.getMa() + "%");
            ps.setInt(5, khuyenMaiTheoSanPham.getGiaTri());
            ps.setInt(6, khuyenMaiTheoSanPham.getGiaTri());
            ps.setLong(7, khuyenMaiTheoSanPham.getNgayBatDau());
            ps.setLong(8, khuyenMaiTheoSanPham.getNgayKetThuc());
            ps.setLong(9, khuyenMaiTheoSanPham.getNgayBatDau());
            ps.setLong(10, khuyenMaiTheoSanPham.getNgayKetThuc());
            ps.setLong(11, khuyenMaiTheoSanPham.getThoiDiemHienTai());
            ps.setLong(12, khuyenMaiTheoSanPham.getNgayBatDau());
            ps.setLong(13, khuyenMaiTheoSanPham.getNgayKetThuc());
            ps.setLong(14, khuyenMaiTheoSanPham.getThoiDiemHienTai());
            ps.setLong(15, khuyenMaiTheoSanPham.getNgayBatDau());
            ps.setLong(16, khuyenMaiTheoSanPham.getNgayKetThuc());
            ps.setBoolean(17, khuyenMaiTheoSanPham.getTrangThai());
            ps.setBoolean(18, khuyenMaiTheoSanPham.getTrangThai());
            // Gán các giá trị cho các tham số khác nếu cần
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
