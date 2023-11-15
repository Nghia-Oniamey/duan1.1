package raven.application.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import raven.application.database.DBConnect;
import raven.application.entity.NhanVien;

public class NhanVienRepo {

    public List<NhanVien> getAllNhanVien() {
        String sql = "select * from nhanvien";
        List<NhanVien> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setHoTen(rs.getString("MaNV"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setVaiTro(rs.getString("VaiTro"));
                list.add(nv);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
}
