package com.poly.form.doihang.view;

import com.formdev.flatlaf.FlatClientProperties;
import com.poly.Application;
import com.poly.form.doihang.entity.DoiHangResponse.HoaDon;
import com.poly.menu.Menu;
import com.poly.form.doihang.service.DoiHangService.IPhieuDoiService;
import com.poly.form.doihang.service.DoiHangService.impl.PhieuDoiService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raven
 */
public class FormQuanLyDoiHang extends javax.swing.JPanel {

    private Menu menu;
    private DoiHangConfigs doiHangConfigs;
    private DefaultTableModel tableModel = new DefaultTableModel();
    private PhieuDoiService phieuDoiService = new PhieuDoiService();
    private Map<String, HoaDon> mapHoaDon = new HashMap<>();

    public FormQuanLyDoiHang(Menu menu, DoiHangConfigs doiHangConfigs) {
        this.menu = menu;
        this.doiHangConfigs = doiHangConfigs;
        initComponents();
        Title.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        tblListHoaDon.setModel(tableModel);
        showTable(phieuDoiService.getAll3Day(txtSearch.getText(), cbxTrangThai.getSelectedIndex() == 0 ? 1 : 0));
        showCBX();
    }

    public void showCBX() {
        cbxTrangThai.removeAllItems();
        cbxTrangThai.addItem("Đã thanh toán");
        cbxTrangThai.addItem("Chưa thanh toán");
    }

    public void showTable(List<HoaDon> list) {
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new Object[]{"STT", "Mã hóa đơn", "tên khách hàng", "Sdt", "tổng tiền", "ngày tạo", "Trạng thái"});
        mapHoaDon = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            HoaDon hoaDon = list.get(i);
            mapHoaDon.put(hoaDon.getMaHoaDon(), hoaDon);
            tableModel.addRow(new Object[]{i + 1, hoaDon.getMaHoaDon(),
                hoaDon.getTenKhachHang(), hoaDon.getSdt(), hoaDon.getTongTienSauKhuyenMai(),
                hoaDon.getNgayTao(), hoaDon.getTrangThai().equalsIgnoreCase("1") ? "Đã thanh toán" : "Chưa thanh toán"});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        ctnBoLoc = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxTrangThai = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListHoaDon = new javax.swing.JTable();
        btnLichSu = new javax.swing.JButton();
        btnChinhSach = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        Title.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Quản Lý Đổi Hàng");

        lblTitle.setText("Hóa đơn trong thời gian đổi");

        ctnBoLoc.setBorder(javax.swing.BorderFactory.createTitledBorder("Bộ lọc hóa đơn"));

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel1.setText("Tìm kiếm");

        jLabel3.setText("Trạng thái");

        cbxTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ctnBoLocLayout = new javax.swing.GroupLayout(ctnBoLoc);
        ctnBoLoc.setLayout(ctnBoLocLayout);
        ctnBoLocLayout.setHorizontalGroup(
            ctnBoLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctnBoLocLayout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addGroup(ctnBoLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(47, 47, 47)
                .addGroup(ctnBoLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxTrangThai, 0, 336, Short.MAX_VALUE)
                    .addComponent(txtSearch))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ctnBoLocLayout.setVerticalGroup(
            ctnBoLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctnBoLocLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(ctnBoLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addGroup(ctnBoLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        tblListHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hd", "Tên nhân viên", "Hành động"
            }
        ));
        tblListHoaDon.setRowHeight(30);
        tblListHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListHoaDon);

        btnLichSu.setText("Hóa Đơn Đã Đổi");
        btnLichSu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichSuActionPerformed(evt);
            }
        });

        btnChinhSach.setText("Chính sách đổi");
        btnChinhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSachActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("<");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText(">");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("1/1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(356, Short.MAX_VALUE)
                .addComponent(Title)
                .addGap(203, 203, 203)
                .addComponent(btnLichSu)
                .addGap(18, 18, 18)
                .addComponent(btnChinhSach)
                .addGap(120, 120, 120))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
                            .addComponent(lblTitle)
                            .addComponent(ctnBoLoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(481, 481, 481)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnChinhSach)
                            .addComponent(btnLichSu)))
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(ctnBoLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitle)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel2))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void tblListHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListHoaDonMouseClicked
        int i = tblListHoaDon.getSelectedRow();
        for (Map.Entry<String, HoaDon> hoaDon : mapHoaDon.entrySet()) {
            String key = hoaDon.getKey();
            if (key.equalsIgnoreCase((String) tblListHoaDon.getValueAt(i, 1))) {
                doiHangConfigs.setIdHD(hoaDon.getValue().getId());
            }
        }
        doiHangConfigs.setMaHoaDon((String) tblListHoaDon.getValueAt(i, 1));
        menu.setSelectedMenu(3, 3);
    }//GEN-LAST:event_tblListHoaDonMouseClicked

    private void btnLichSuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichSuActionPerformed
        menu.setSelectedMenu(3, 4);
    }//GEN-LAST:event_btnLichSuActionPerformed

    private void btnChinhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSachActionPerformed
        menu.setSelectedMenu(3, 2);
    }//GEN-LAST:event_btnChinhSachActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        showTable(phieuDoiService.getAll3Day(txtSearch.getText(), cbxTrangThai.getSelectedIndex() == 0 ? 1 : 0));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cbxTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTrangThaiActionPerformed
        try {
            showTable(phieuDoiService.getAll3Day(txtSearch.getText(), cbxTrangThai.getSelectedIndex() == 0 ? 1 : 0));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbxTrangThaiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JButton btnChinhSach;
    private javax.swing.JButton btnLichSu;
    private javax.swing.JComboBox<String> cbxTrangThai;
    private javax.swing.JPanel ctnBoLoc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblListHoaDon;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
