package com.poly.form.doihang.view;

import com.poly.form.doihang.view.ConfirmDoiHang;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.poly.form.doihang.entity.DoiHangResponse.HoaDon;
import com.poly.form.doihang.entity.DoiHangResponse.LyDoDoi;
import com.poly.form.doihang.entity.DoiHangResponse.MauSacResponse;
import com.poly.form.doihang.entity.DoiHangResponse.ProductDetailResponse;
import com.poly.form.doihang.entity.DoiHangResponse.TheLoaiResponse;
import com.poly.form.doihang.service.DoiHangService.impl.LyDoDoiService;
import com.poly.form.doihang.service.DoiHangService.impl.PhieuDoiChiTietService;
import com.poly.form.doihang.service.DoiHangService.impl.PhieuDoiService;
import com.poly.form.doihang.service.DoiHangService.impl.ProductDetailService;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.print.resources.serviceui;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import com.poly.menu.Menu;
import com.poly.form.doihang.repository.DoiHangRepository.HoaDonRepository;
import com.poly.form.doihang.repository.DoiHangRepository.MauSacRepo;
import com.poly.form.doihang.repository.DoiHangRepository.TheLoaiRepo;
import raven.toast.Notifications;

/**
 *
 * @author Raven
 */
public class DoiHangChiTiet extends javax.swing.JPanel {

    private Menu menu;
    private DoiHangConfigs doiHangConfigs;
    private ProductDetailService detailService = new ProductDetailService();
    private PhieuDoiService phieuDoiService = new PhieuDoiService();
    private PhieuDoiChiTietService phieuDoiChiTietService = new PhieuDoiChiTietService();
    private LyDoDoiService lyDoService = new LyDoDoiService();
    private DefaultTableModel model = new DefaultTableModel();
    private HoaDonRepository hoaDonRepository = new HoaDonRepository();
    private List<Long> listIdSPCT = new ArrayList<>();
    private Boolean doiHang = false;

    public JComboBox<String> getCbxMauSac() {
        return cbxMauSac;
    }

    public void setCbxMauSac(JComboBox<String> cbxMauSac) {
        this.cbxMauSac = cbxMauSac;
    }

    public JComboBox<String> getCbxTheLoai() {
        return cbxTheLoai;
    }

    public void setCbxTheLoai(JComboBox<String> cbxTheLoai) {
        this.cbxTheLoai = cbxTheLoai;
    }

    public JTextField getTxtSearch() {
        return txtSearch;
    }

    public void setTxtSearch(JTextField txtSearch) {
        this.txtSearch = txtSearch;
    }

    public DoiHangChiTiet(DoiHangConfigs doiHangConfigs, Menu menu) {
        this.doiHangConfigs = doiHangConfigs;
        this.menu = menu;
        initComponents();
        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        lblHoaDon.setText(doiHangConfigs.getMaHoaDon());
        model = (DefaultTableModel) tblBuy.getModel();
        showDetail(doiHangConfigs);
        showCBX();
        showTable(detailService.findProductsById(doiHangConfigs.getId(), txtSearch.getText(),
                cbxTheLoai.getSelectedItem().toString(), cbxMauSac.getSelectedItem().toString()));

    }

    public ProductDetailService getDetailService() {
        return detailService;
    }

    public void setDetailService(ProductDetailService detailService) {
        this.detailService = detailService;
    }

    public void showCBX() {
        cbxMauSac.removeAllItems();
        cbxTheLoai.removeAllItems();
        for (TheLoaiResponse theLoaiResponse : new TheLoaiRepo().findAll()) {
            cbxTheLoai.addItem(theLoaiResponse.getTen());
        }
        for (MauSacResponse mau : new MauSacRepo().findAll()) {
            cbxMauSac.addItem(mau.getTen());
        }
    }

    public void showTable(List<ProductDetailResponse> list) {
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            ProductDetailResponse response = list.get(i);
            listIdSPCT.add(response.getIdsanphamdetail());
            model.addRow(new Object[]{i + 1, response.getIdsanphamdetail(), response.getTenSanPham().trim(),
                response.getSoLuong(), response.getGiaTien(), response.getTenMau().trim(), response.getTenTheLoai().trim()});
        }
    }

    public void showDetail(DoiHangConfigs doiHangConfigs) {
        HoaDon hoaDon = hoaDonRepository.finById(doiHangConfigs.getId());
        txtMaHoaDon.setText(hoaDon.getMaHoaDon());
        txtNgayTao.setText(hoaDon.getNgayTao() + "");
        txtTenKhachHang.setText(hoaDon.getTenKhachHang());
        txtTenNhanVien.setText(hoaDon.getSdt());
        txtTongTien.setText(hoaDon.getTongTienHoaDon() + "");
        txtTrangThai.setText(hoaDon.getTrangThai().equals("1")?"Đã thanh toán":"Chưa thanh toán");
    }

    private List<ProductDetailResponse> GetSelected() {
        List<ProductDetailResponse> listselected = new ArrayList<>();
        List<ProductDetailResponse> listData = detailService.findProductsById(doiHangConfigs.getId());
        for (int i = 0; i < listData.size(); i++) {
            boolean check = Boolean.valueOf(tblBuy.getValueAt(i, 7) + "");
            if (check) {
                listselected.add(listData.get(i));
            }
        }
        return listselected;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuy = new javax.swing.JTable();
        btnQuayLai = new javax.swing.JButton();
        ctnBoLoc = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxMauSac = new javax.swing.JComboBox<>();
        cbxTheLoai = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        lblHoaDon = new javax.swing.JLabel();
        btnDoiTatCa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTrangThai = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JLabel();

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Hóa đơn: ");

        jLabel2.setText("Sản phẩm đã mua");

        tblBuy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá tiền", "Màu", "Thể loại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBuy.setRowHeight(30);
        tblBuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBuyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBuy);

        btnQuayLai.setText("Quay lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        ctnBoLoc.setBorder(javax.swing.BorderFactory.createTitledBorder("Bộ lọc"));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel1.setText("Tìm kiếm");

        jLabel5.setText("Màu Sắc");

        cbxMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMauSacActionPerformed(evt);
            }
        });

        cbxTheLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTheLoaiActionPerformed(evt);
            }
        });

        jLabel7.setText("Thể loại");

        javax.swing.GroupLayout ctnBoLocLayout = new javax.swing.GroupLayout(ctnBoLoc);
        ctnBoLoc.setLayout(ctnBoLocLayout);
        ctnBoLocLayout.setHorizontalGroup(
            ctnBoLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ctnBoLocLayout.createSequentialGroup()
                .addContainerGap(201, Short.MAX_VALUE)
                .addGroup(ctnBoLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(44, 44, 44)
                .addGroup(ctnBoLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxTheLoai, 0, 285, Short.MAX_VALUE)
                    .addComponent(txtSearch)
                    .addComponent(cbxMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(408, 408, 408))
        );
        ctnBoLocLayout.setVerticalGroup(
            ctnBoLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctnBoLocLayout.createSequentialGroup()
                .addGroup(ctnBoLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ctnBoLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ctnBoLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        lblHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblHoaDon.setText("-");

        btnDoiTatCa.setText("Đổi tất cả");
        btnDoiTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiTatCaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hóa đơn"));

        jLabel3.setText("Mã hóa đơn");

        txtMaHoaDon.setText("jLabel7");

        txtTenNhanVien.setText("jLabel7");

        jLabel9.setText("Số điện thoại");

        jLabel10.setText("Tên khách hàng");

        txtTenKhachHang.setText("jLabel7");

        jLabel12.setText("Trạng thái");

        txtTrangThai.setText("jLabel7");

        jLabel14.setText("Ngày tạo");

        txtNgayTao.setText("jLabel7");

        jLabel16.setText("Tổng tiền");

        txtTongTien.setText("jLabel7");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28)
                        .addComponent(txtMaHoaDon))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(28, 28, 28)
                        .addComponent(txtTongTien)))
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(28, 28, 28)
                        .addComponent(txtNgayTao))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(28, 28, 28)
                        .addComponent(txtTenKhachHang)))
                .addGap(175, 175, 175)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(28, 28, 28)
                        .addComponent(txtTrangThai))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(28, 28, 28)
                        .addComponent(txtTenNhanVien)))
                .addContainerGap(240, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtTenNhanVien))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtMaHoaDon)
                        .addComponent(jLabel10)
                        .addComponent(txtTenKhachHang)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txtTongTien))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(txtNgayTao))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txtTrangThai)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(554, 554, 554)
                                .addComponent(btnDoiTatCa)
                                .addGap(58, 58, 58)
                                .addComponent(btnQuayLai))
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1007, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ctnBoLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHoaDon)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoaDon))
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ctnBoLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuayLai)
                    .addComponent(btnDoiTatCa))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        menu.setSelectedMenu(3, 0);
    }//GEN-LAST:event_btnQuayLaiActionPerformed


    private void tblBuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBuyMouseClicked
        int index = tblBuy.getSelectedRow();
        ProductDetailResponse productDetail = new ProductDetailResponse();
        List<ProductDetailResponse> listData = detailService.findProductsById(doiHangConfigs.getId());
//        productDetail= listData.get(index);
        for (ProductDetailResponse productDetailResponse : listData) {
            if (productDetailResponse.getIdsanphamdetail().equals(listIdSPCT.get(index))) {
                productDetail = productDetailResponse;
            }
        }
        new ConfirmDoiHang(productDetail, doiHangConfigs.getId(), this, doiHang).setVisible(true);
    }//GEN-LAST:event_tblBuyMouseClicked

    private void btnDoiTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiTatCaActionPerformed
        List<LyDoDoi> listLyDo = lyDoService.findAll();
        List<String> lyDo = new ArrayList<>();
        for (LyDoDoi lyDoDoi : listLyDo) {
            lyDo.add(lyDoDoi.getLyDo());
        }
        Object[] possibilities = lyDo.toArray();
        String s = (String) JOptionPane.showInputDialog(
                this, "Chọn lý do đổi",
                "Xác nhận đổi?",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "ham");
        if ((s != null) && (s.length() > 0)) {
            //lấy id lý do đổi
            Long idLyDo = null;
            for (LyDoDoi lyDoDoi : listLyDo) {
                if (lyDoDoi.getLyDo().equalsIgnoreCase(s)) {
                    idLyDo = lyDoDoi.getId();
                }
            }
            Long idPhieuDoi = phieuDoiService.getIdPhieuDoibyIdHoaDon(doiHangConfigs.getId());
            if (idPhieuDoi == null) {
                phieuDoiService.createPhieuDoi(doiHangConfigs.getId());
                idPhieuDoi = phieuDoiService.getIdPhieuDoibyIdHoaDon(doiHangConfigs.getId());
            }
            List<ProductDetailResponse> listData = detailService.findProductsById(doiHangConfigs.getId());
            for (ProductDetailResponse productDetailResponse : listData) {
                if (phieuDoiChiTietService.checkDoiHang(productDetailResponse.getIdsanphamdetail(), idPhieuDoi, idLyDo)) {
                    phieuDoiChiTietService.addLyDoChiTiet(productDetailResponse.getSoLuong(), productDetailResponse.getIdsanphamdetail(), idPhieuDoi, idLyDo);
                } else {
                    phieuDoiChiTietService.createPhieuDoiChiTiet(productDetailResponse, idPhieuDoi, idLyDo, "-", productDetailResponse.getSoLuong());
                }
                hoaDonRepository.deleteHoaDonSanPham(productDetailResponse.getIdHoaDonSanPham());
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Đổi thành công");
                menu.setSelectedMenu(3, 0);
                return;
            }
        }
    }//GEN-LAST:event_btnDoiTatCaActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        showTable(detailService.findProductsById(doiHangConfigs.getId(), txtSearch.getText(),
                cbxTheLoai.getSelectedItem().toString(), cbxMauSac.getSelectedItem().toString()));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cbxMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMauSacActionPerformed
        try {
            showTable(detailService.findProductsById(doiHangConfigs.getId(), txtSearch.getText(),
                    cbxTheLoai.getSelectedItem().toString(), cbxMauSac.getSelectedItem().toString()));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbxMauSacActionPerformed

    private void cbxTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTheLoaiActionPerformed
        try {
            showTable(detailService.findProductsById(doiHangConfigs.getId(), txtSearch.getText(),
                    cbxTheLoai.getSelectedItem().toString(), cbxMauSac.getSelectedItem().toString()));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbxTheLoaiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiTatCa;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JComboBox<String> cbxMauSac;
    private javax.swing.JComboBox<String> cbxTheLoai;
    private javax.swing.JPanel ctnBoLoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JTable tblBuy;
    private javax.swing.JLabel txtMaHoaDon;
    private javax.swing.JLabel txtNgayTao;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JLabel txtTenKhachHang;
    private javax.swing.JLabel txtTenNhanVien;
    private javax.swing.JLabel txtTongTien;
    private javax.swing.JLabel txtTrangThai;
    // End of variables declaration//GEN-END:variables

}

enum Actions {
    PRINT, EDIT;
}

class ButtonsPanel extends JPanel {

    public final List<JButton> buttons = new ArrayList<>();

    public ButtonsPanel() {
        super(new FlowLayout(FlowLayout.LEFT));
        setOpaque(true);
        for (Actions a : Actions.values()) {
            JButton b = new JButton(a.toString());
            b.setFocusable(false);
            b.setRolloverEnabled(false);
            add(b);
            buttons.add(b);
        }
    }

    protected void updateButtons(Object value) {
        if (value instanceof EnumSet) {
            EnumSet ea = (EnumSet) value;
            removeAll();
            if (ea.contains(Actions.PRINT)) {
                add(buttons.get(0));
            }
            if (ea.contains(Actions.EDIT)) {
                add(buttons.get(1));
            }
        }
    }
}

class ButtonsRenderer implements TableCellRenderer {

    private final ButtonsPanel panel = new ButtonsPanel();

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        panel.updateButtons(value);
        return panel;
    }
}

class PrintAction extends AbstractAction {

    private final JTable table;

    public PrintAction(JTable table) {
        super(Actions.PRINT.toString());
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(table, "Printing");
    }
}

class EditAction extends AbstractAction {

    private final JTable table;

    public EditAction(JTable table) {
        super(Actions.EDIT.toString());
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int row = table.convertRowIndexToModel(table.getEditingRow());
        Object o = table.getModel().getValueAt(row, 0);
        JOptionPane.showMessageDialog(table, "Editing: " + o);
    }
}

class ButtonsEditor extends AbstractCellEditor implements TableCellEditor {

    private final ButtonsPanel panel = new ButtonsPanel();
    private final JTable table;
    private Object o;

    private class EditingStopHandler extends MouseAdapter implements ActionListener {

        @Override
        public void mousePressed(MouseEvent e) {
            Object o = e.getSource();
            if (o instanceof TableCellEditor) {
                actionPerformed(null);
            } else if (o instanceof JButton) {
                ButtonModel m = ((JButton) e.getComponent()).getModel();
                if (m.isPressed() && table.isRowSelected(table.getEditingRow()) && e.isControlDown()) {
                    panel.setBackground(table.getBackground());
                }
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    fireEditingStopped();
                }
            });
        }
    }

    public ButtonsEditor(JTable table) {
        super();
        this.table = table;
        panel.buttons.get(0).setAction(new PrintAction(table));
        panel.buttons.get(1).setAction(new EditAction(table));

        EditingStopHandler handler = new EditingStopHandler();
        for (JButton b : panel.buttons) {
            b.addMouseListener(handler);
            b.addActionListener(handler);
        }
        panel.addMouseListener(handler);
    }

    @Override
    public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column) {
        panel.setBackground(table.getSelectionBackground());
        panel.updateButtons(value);
        o = value;
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return o;
    }
}
