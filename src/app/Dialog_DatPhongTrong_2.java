package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.time.LocalDateTime;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.swing.UIManager;

import entity.ChiTietDichVu;
import entity.ChiTietHoaDon;
import entity.Enum_TrangThai;
import entity.HoaDonDatPhong;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;
import entity.SanPham;
import entity.TempDatPhong;
import entity.TempThemDV;

import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;

import dao.ChiTietDichVu_dao;
import dao.ChiTietHoaDon_dao;
import dao.HoaDonDatPhong_dao;
import dao.KhachHang_dao;
import dao.LoaiPhong_dao;
import dao.NhanVien_dao;
import dao.PhieuDatPhong_dao;
import dao.Phong_dao;
import dao.TempDatPhong_dao;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Component;

public class Dialog_DatPhongTrong_2 extends JDialog implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private GD_TrangChu trangChu;
	private static final long serialVersionUID = 1L;
	private JTextField txtSDT;
	private JButton btn_KiemTraSDT, btn_ThemDV, btn_Sua, btn_DatPhong;
	private JPanel panel_1, panel_2;
	private JCheckBox checkBox_KH;
	private JLabel lbl_GioiTinh_1, lbl_GiaTien_1, lbl_TenKH_1;
	private JTextField txtSoNguoi;
	private JButton btn_DatThemPhong;
	private NhanVien_dao nv_dao = new NhanVien_dao();
	private NhanVien nv;
	private HoaDonDatPhong_dao hddp_dao = new HoaDonDatPhong_dao();
	private ChiTietHoaDon_dao cthd_dao = new ChiTietHoaDon_dao();
	private ChiTietDichVu_dao ctdv_dao = new ChiTietDichVu_dao();

	private JTable tblThemPhongMoi, tblDV;
	private DefaultTableModel model, modelDV;
	private String col[] = { "STT", "Mã Phòng", "Loại Phòng", "Số người", "Đơn Giá" };
	private String colDV[] = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Tổng tiền" };

	private Dialog_ThemDichVu dialog_ThemDichVu;
	private JLabel lbl_TenKH;

	private LocalDateTime now;
	private DateTimePicker dateTimePicker;
	private TimePickerSettings timeSettings;
	private DatePickerSettings dateSettings;
	private JButton btn_XoaPhongDat, btnXoaDV;
	private JRadioButton radGioMacDinh, radGioTuDo;
	private ButtonGroup grpGio = new ButtonGroup();

	private KhachHang_dao khachHang_dao;
	private JLabel lblTieuDe;
	private TempDatPhong_dao tmpDatPhong_dao = new TempDatPhong_dao();
	private Phong_dao p_dao = new Phong_dao();
	private LoaiPhong_dao lp_dao = new LoaiPhong_dao();
	private JLabel lbl_Loai;
	private JLabel lblMaPhong;
	private PhieuDatPhong_dao pdp_dao = new PhieuDatPhong_dao();
	private Date ngayHienTai;
	private Date date;
	private KhachHang_dao kh_dao = new KhachHang_dao();
	private DecimalFormat df;

	public Dialog_DatPhongTrong_2(String maPhong, Phong p, LoaiPhong lp, int soNguoi, GD_TrangChu trangChu) {
		df = new DecimalFormat("#,###,### VNĐ");
		// màn
		// hình******************************************************************************
		this.trangChu = trangChu;
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setSize(800, 629);
		setLocationRelativeTo(null);

		// panel chứa tiêu đề--------------------------------------
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 35);
		panel.setBackground(new Color(181, 230, 251));
		getContentPane().add(panel);
		panel.setLayout(null);

		lblTieuDe = new JLabel("Đặt phòng");

		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(Color.BLACK);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
		lblTieuDe.setBounds(0, 0, 790, 35);
		panel.add(lblTieuDe);

		// pane; chứa các phần còn lại---------------------------------
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 35, 784, 557);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lblMaPhong = new JLabel("Mã phòng:");
		lblMaPhong.setFont(new Font("Arial", Font.BOLD, 16));
		lblMaPhong.setBounds(10, 5, 200, 25);
		panel_1.add(lblMaPhong);

		lbl_Loai = new JLabel("Loại:");
		lbl_Loai.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_Loai.setBounds(10, 40, 200, 25);
		panel_1.add(lbl_Loai);

		JLabel lbl_LoaiKhachHang = new JLabel("Khách hàng mặc định:");
		lbl_LoaiKhachHang.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_LoaiKhachHang.setBounds(10, 70, 180, 25);
		panel_1.add(lbl_LoaiKhachHang);

		checkBox_KH = new JCheckBox();
		checkBox_KH.setBackground(Color.WHITE);
		checkBox_KH.setHorizontalAlignment(SwingConstants.LEFT);
		checkBox_KH.setFont(new Font("Arial", Font.BOLD, 15));
		checkBox_KH.setBounds(210, 70, 30, 25);
		panel_1.add(checkBox_KH);

		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(10, 155, 760, 40);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lbl_sdtKH = new JLabel("SDT khách:");
		lbl_sdtKH.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sdtKH.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_sdtKH.setBounds(5, 5, 130, 30);
		panel_2.add(lbl_sdtKH);

		txtSDT = new JTextField();
		txtSDT.setHorizontalAlignment(SwingConstants.LEFT);
		txtSDT.setFont(new Font("Arial", Font.BOLD, 16));
		txtSDT.setText("0788343289");
		txtSDT.setBounds(140, 5, 300, 30);
		panel_2.add(txtSDT);
		txtSDT.setColumns(10);

		lbl_TenKH = new JLabel("Tên khách hàng:");
		lbl_TenKH.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_TenKH.setBounds(10, 200, 135, 30);
		panel_1.add(lbl_TenKH);

		JLabel lbl_GioiTinh = new JLabel("Giới tính:");
		lbl_GioiTinh.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GioiTinh.setBounds(450, 200, 77, 30);
		panel_1.add(lbl_GioiTinh);

		lbl_GioiTinh_1 = new JLabel("Nam");
		lbl_GioiTinh_1.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GioiTinh_1.setBounds(550, 200, 100, 30);
		panel_1.add(lbl_GioiTinh_1);

		JLabel lbl_GiaTien = new JLabel("Giá tiền:");
		lbl_GiaTien.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GiaTien.setBounds(440, 40, 80, 25);
		panel_1.add(lbl_GiaTien);

		JLabel lbl_SoNguoi = new JLabel("Số người:");
		lbl_SoNguoi.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_SoNguoi.setBounds(440, 5, 80, 25);
		panel_1.add(lbl_SoNguoi);

		txtSoNguoi = new JTextField();
		txtSoNguoi.setText(soNguoi + "");
		txtSoNguoi.setFont(new Font("Arial", Font.BOLD, 16));
		txtSoNguoi.setBounds(550, 5, 100, 25);
		panel_1.add(txtSoNguoi);

		lbl_GiaTien_1 = new JLabel("");
		lbl_GiaTien_1.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GiaTien_1.setBounds(550, 40, 200, 25);
		panel_1.add(lbl_GiaTien_1);

		lbl_TenKH_1 = new JLabel();
		lbl_TenKH_1.setFont(new Font("Arial", Font.ITALIC, 17));
		lbl_TenKH_1.setBounds(165, 200, 180, 30);
		panel_1.add(lbl_TenKH_1);

		// các nút
		// jbutton-------------------------------------------------------------------
		btn_DatPhong = new JButton("Đặt Phòng");
		btn_DatPhong.setBackground(Color.GREEN);
		btn_DatPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_DatPhong.setBackground(new Color(33, 167, 38, 255));
		btn_DatPhong.setBounds(10, 507, 160, 40);
		panel_1.add(btn_DatPhong);

		btn_Sua = new JButton("Sửa");
		btn_Sua.setFont(new Font("Arial", Font.BOLD, 18));
		btn_Sua.setBackground(new Color(255, 83, 83, 255));
		btn_Sua.setBounds(600, 507, 170, 40);
		panel_1.add(btn_Sua);

		btn_ThemDV = new JButton("Thêm dịch vụ");
		btn_ThemDV.setBackground(Color.LIGHT_GRAY);
		btn_ThemDV.setFont(new Font("Arial", Font.BOLD, 15));
		btn_ThemDV.setBounds(225, 350, 135, 30);
		panel_1.add(btn_ThemDV);

		btn_KiemTraSDT = new JButton("Kiểm Tra");
		btn_KiemTraSDT.setBackground(UIManager.getColor("Button.background"));
		btn_KiemTraSDT.setFont(new Font("Arial", Font.BOLD, 17));
		btn_KiemTraSDT.setBounds(480, 5, 200, 32);
		panel_2.add(btn_KiemTraSDT);

		JLabel lbl_SoNguoi_1_1 = new JLabel();
		lbl_SoNguoi_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_SoNguoi_1_1.setBounds(140, 5, 250, 25);
		panel_1.add(lbl_SoNguoi_1_1);

		JLabel lbl_SoNguoi_1_2 = new JLabel("");
		lbl_SoNguoi_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_SoNguoi_1_2.setBounds(140, 40, 200, 25);
		panel_1.add(lbl_SoNguoi_1_2);

		btn_DatThemPhong = new JButton("Đặt Thêm Phòng");
		btn_DatThemPhong.setFont(new Font("Arial", Font.BOLD, 18));
		btn_DatThemPhong.setBackground(new Color(109, 197, 112));
		btn_DatThemPhong.setBounds(193, 507, 200, 40);
		panel_1.add(btn_DatThemPhong);

		// bảng thêm phòng mới
		model = new DefaultTableModel(col, 0);
		tblThemPhongMoi = new JTable(model);
		tblThemPhongMoi.setFont(new Font("Arial", Font.PLAIN, 12));
		tblThemPhongMoi.setBackground(Color.WHITE);
		JScrollPane sp = new JScrollPane(tblThemPhongMoi);
		sp.setBounds(10, 235, 765, 100);
		panel_1.add(sp);
		panel_1.setPreferredSize(new Dimension(800, 300));

		JLabel lbl_GioTraPhong = new JLabel("Giờ trả phòng mặc định:");
		lbl_GioTraPhong.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GioTraPhong.setBounds(10, 110, 190, 25);
		panel_1.add(lbl_GioTraPhong);

		now = LocalDateTime.now();

		dateSettings = new DatePickerSettings();
		dateSettings.setLocale(new Locale("vi", "VN")); // Set the locale to English
		dateSettings.setFormatForDatesCommonEra("yyyy-MM-dd"); // Set the date format

		timeSettings = new TimePickerSettings();
		timeSettings.setDisplaySpinnerButtons(true);

		dateTimePicker = new DateTimePicker(dateSettings, timeSettings);
		dateTimePicker.getDatePicker().getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateTimePicker.getTimePicker().getComponentTimeTextField().setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateTimePicker.getTimePicker().getComponentSpinnerPanel().setBounds(80, 0, 0, 25);
		dateTimePicker.getTimePicker().getComponentToggleTimeMenuButton().setBounds(75, 0, 26, 25);
		dateTimePicker.getTimePicker().getComponentTimeTextField().setBounds(0, 0, 70, 25);
		dateTimePicker.getTimePicker().getComponentToggleTimeMenuButton().setFont(new Font("Tahoma", Font.BOLD, 12));
		dateTimePicker.getDatePicker().getComponentToggleCalendarButton().setFont(new Font("Tahoma", Font.BOLD, 12));
		dateTimePicker.timePicker.setBounds(141, 0, 80, 25);
		dateTimePicker.datePicker.setBounds(0, 0, 136, 25);
		dateTimePicker.getTimePicker().setBounds(150, 0, 110, 25);
		dateTimePicker.getTimePicker().setLayout(null);
		dateTimePicker.getTimePicker().setBackground(Color.white);
		dateTimePicker.getDatePicker().setBounds(0, 0, 136, 25);
		dateTimePicker.setDateTimePermissive(now);
		dateTimePicker.setBackground(Color.white);
		dateTimePicker.setBackground(Color.white);

		// Add the DateTimePicker to your user interface, e.g. to a JPanel
		// panel.add(dateTimePicker);
		dateTimePicker.setBounds(250, 110, 260, 25);
		panel_1.add(dateTimePicker);
		dateTimePicker.setLayout(null);

		JLabel lbl_GioTraPhongTuDo = new JLabel("Giờ trả phòng tự do:");
		lbl_GioTraPhongTuDo.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_GioTraPhongTuDo.setBounds(440, 70, 160, 25);
		panel_1.add(lbl_GioTraPhongTuDo);

		radGioTuDo = new JRadioButton();
		radGioTuDo.setBackground(Color.WHITE);
		radGioTuDo.setFont(new Font("Tahoma", Font.BOLD, 13));
		radGioTuDo.setBounds(606, 70, 37, 25);
		grpGio.add(radGioTuDo);
		panel_1.add(radGioTuDo);

		radGioMacDinh = new JRadioButton();
		radGioMacDinh.setSelected(true);
		radGioMacDinh.setBackground(Color.WHITE);
		radGioMacDinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		radGioMacDinh.setBounds(210, 110, 30, 25);
		grpGio.add(radGioMacDinh);
		panel_1.add(radGioMacDinh);

		btn_XoaPhongDat = new JButton("Xóa Phòng Đặt");
		btn_XoaPhongDat.setFont(new Font("Arial", Font.BOLD, 18));
		btn_XoaPhongDat.setBackground(new Color(234, 234, 114, 255));
		btn_XoaPhongDat.setBounds(413, 507, 170, 40);
		panel_1.add(btn_XoaPhongDat);

		modelDV = new DefaultTableModel(colDV, 0);
		tblDV = new JTable(modelDV);
		tblDV.setFont(new Font("Arial", Font.PLAIN, 12));
		tblDV.setBackground(Color.WHITE);
		JScrollPane sp_ListDV = new JScrollPane(tblDV);
		sp_ListDV.setBounds(10, 397, 765, 100);
		panel_1.add(sp_ListDV);

		btnXoaDV = new JButton("Xóa dịch vụ");
		btnXoaDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaDV.setFont(new Font("Arial", Font.BOLD, 15));
		btnXoaDV.setBackground(Color.LIGHT_GRAY);
		btnXoaDV.setBounds(393, 350, 134, 30);
		panel_1.add(btnXoaDV);

		Timer timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (DataManager.isLoadDV()) {
					clearTableDV();
					if (tmpDatPhong_dao.getAllTemp().size() == 2) {
						loadDataDV(model.getValueAt(0, 1).toString());
						DataManager.setLoadDV(false);
					} else {
						DataManager.setLoadDV(false);
						clearTableDV();
						clearTable();
						loadDataPhong();
					}
				}
			}
		});

		// thêm sự kiện button
		btn_DatPhong.addActionListener(this);
		btn_KiemTraSDT.addActionListener(this);
		btn_Sua.addActionListener(this);
		btn_ThemDV.addActionListener(this);
		btn_DatThemPhong.addActionListener(this);
		btn_XoaPhongDat.addActionListener(this);
		btnXoaDV.addActionListener(this);
		radGioMacDinh.addActionListener(this);
		radGioTuDo.addActionListener(this);
		tblThemPhongMoi.addMouseListener(this);
		checkBox_KH.addActionListener(this);
		loadDataPhong();
		checkDefaultCustomer();
		timer.start();
	}

	private void checkDefaultCustomer() {
		if (DataManager.getSoDienThoaiKHDat().equals("0000000000")) {
			checkBox_KH.setSelected(true);
			lbl_TenKH_1.setText("Nguyễn Văn A");
			lbl_GioiTinh_1.setText("Nam");
			txtSDT.setEnabled(false);
			btn_KiemTraSDT.setEnabled(false);
		}
	}

	private void loadDataPhong() {
		int i = 0;
		for (TempDatPhong tmp : tmpDatPhong_dao.getAllTemp()) {
			if (!tmp.getMaPhong().equals("000")) {
				i++;
				Phong p = p_dao.getPhongTheoMaPhong(tmp.getMaPhong());
				LoaiPhong lp = lp_dao.getLoaiPhongTheoMaLoaiPhong(p.getLoaiPhong().getMaLoaiPhong());
				Object[] row = { i, tmp.getMaPhong(), lp.getTenLoaiPhong(), tmp.getSoNguoiHat(),
						lp.getDonGiaTheoGio() };
				model.addRow(row);
			}
		}
		if (!DataManager.getSoDienThoaiKHDat().equals("")) {
			txtSDT.setText(DataManager.getSoDienThoaiKHDat());
			khachHang_dao = new KhachHang_dao();
			String sdt = txtSDT.getText();
			KhachHang khachHang = khachHang_dao.TimkiemSDT_KHachHang(sdt);
			String hoTen = khachHang.getHoTen();
			boolean gioiTinh = khachHang.isGioiTinh();
			String gioiTinhStr = gioiTinh ? "Nam" : "Nữ";
			lbl_GioiTinh_1.setText(gioiTinhStr);
			lbl_TenKH_1.setText(hoTen);
		}
	}

	private void loadDataDV(String maPhong) {
		if (DataManager.getCtdvTempList() != null) {
			int i = 0;
			for (TempThemDV tmp : DataManager.getCtdvTempList()) {
				if (tmp.getMaPhong().equals(maPhong)) {
					i++;
					Object[] row = { i, tmp.getMaSP(), tmp.getTenSP(), tmp.getSoLuong(), tmp.getDonGia(),
							df.format(tmp.getDonGia() * tmp.getSoLuong()) };
					modelDV.addRow(row);
				}
			}
		}
	}

	private void clearTable() {
		while (tblThemPhongMoi.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	private void clearTableDV() {
		while (tblDV.getRowCount() > 0) {
			modelDV.removeRow(0);
		}
	}

	private void xoa() {
		if (tblThemPhongMoi.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để xóa!!");
		} else if (tblThemPhongMoi.getSelectedRowCount() > 1) {
			int[] selectedRows = tblThemPhongMoi.getSelectedRows();
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa các phòng đã chọn không?", "Thông báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				for (int i = selectedRows.length - 1; i >= 0; i--) {
					int row = selectedRows[i];
					String maPhong = model.getValueAt(row, 1).toString();
					tmpDatPhong_dao.deleteTempDP(maPhong);
					model.removeRow(row);
					if (DataManager.getCtdvTempList() != null) {
						Iterator<TempThemDV> iterator = DataManager.getCtdvTempList().iterator();
						while (iterator.hasNext()) {
							TempThemDV tmp = iterator.next();
							if (tmp.getMaPhong().equals(maPhong)) {
								iterator.remove();
							}
						}
					}
				}
				clearTable();
				loadDataPhong();
				JOptionPane.showMessageDialog(this, "Xóa thành công!!");
			}
		} else {
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa phòng này không?", "Thông báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				int row = tblThemPhongMoi.getSelectedRow();
				String maPhong = model.getValueAt(row, 1).toString();
				tmpDatPhong_dao.deleteTempDP(maPhong);
				model.removeRow(row);
				if (DataManager.getCtdvTempList() != null) {
					Iterator<TempThemDV> iterator = DataManager.getCtdvTempList().iterator();
					while (iterator.hasNext()) {
						TempThemDV tmp = iterator.next();
						if (tmp.getMaPhong().equals(maPhong)) {
							iterator.remove();
						}
					}
				}
				clearTable();
				loadDataPhong();
				JOptionPane.showMessageDialog(this, "Xóa thành công!!");
			}
		}
		if (tmpDatPhong_dao.getAllTemp().size() == 1) {
			DataManager.setSoDienThoaiKHDat("");
			setVisible(false);
		}
	}

	private void sua() {
		if (tblThemPhongMoi.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để sửa!!");
		} else if (tblThemPhongMoi.getSelectedRowCount() > 1) {
			JOptionPane.showMessageDialog(null, "Chỉ được chọn 1 phòng để sửa!!");
		} else {
			tmpDatPhong_dao.updateTempDP(lblMaPhong.getText(), Integer.parseInt(txtSoNguoi.getText()));
			clearTable();
			loadDataPhong();
			JOptionPane.showMessageDialog(this, "Sửa thành công!");
		}
	}

	private void themDV() {
		if (tblThemPhongMoi.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn phòng để thêm dịch vụ!");
		} else if (tblThemPhongMoi.getSelectedRowCount() > 1) {
			JOptionPane.showMessageDialog(null, "Chỉ thêm dịch vụ được 1 phòng!");
		} else {
			if(!lbl_TenKH_1.getText().equals("")) {				
				String customer = lbl_TenKH_1.getText();
				String employee = DataManager.getUserName();
				nv = nv_dao.TimkiemMaNhanVien(employee);
				String maPhong = lblMaPhong.getText();
				String ma = maPhong.substring(maPhong.indexOf(":") + 1).trim();
				dialog_ThemDichVu = new Dialog_ThemDichVu(customer, nv.getHoTen(), ma);
				dialog_ThemDichVu.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Bạn chưa thêm khách hàng!");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btn_Sua)) {
			sua();
		}
		if (o.equals(btn_ThemDV)) {
			themDV();
		}
		if (o.equals(btn_DatPhong)) {
			int check = 0;
			String maHoaDon = TaoMaHDDP();
			if(!lbl_TenKH_1.getText().equals("")) {
				for (TempDatPhong tmpDatPhong : tmpDatPhong_dao.getAllTemp()) {
					// Sửa trống -> Đang sử dụng
					if (!tmpDatPhong.getMaPhong().equals("000")) {
						Phong p = p_dao.getPhongTheoMaPhong(tmpDatPhong.getMaPhong());
						
						// Thêm phiếu đặt phòng
						NhanVien nv = new NhanVien(DataManager.getUserName());
						KhachHang kh = new KhachHang();
						if (checkBox_KH.isSelected())
							kh = kh_dao.getKhachHangTheoSDT("0000000000");
						else
							kh = kh_dao.getKhachHangTheoSDT(txtSDT.getText());
						LocalDateTime NgayDatPhong = LocalDateTime.now();
						
						PhieuDatPhong pdb = new PhieuDatPhong(TaoMaPDP(), p, nv, kh, NgayDatPhong, LocalDateTime.now(),
								tmpDatPhong.getSoNguoiHat());
						if (p.getTrangThai() != Enum_TrangThai.Chờ) {
							pdp_dao.addPhieuDatPhong(pdb);
							// Nếu là chờ thì sửa lại.
						}
						
						p.setTrangThai(Enum_TrangThai.Đang_sử_dụng);
						p_dao.updatePhong(p, p.getMaPhong());
						
						// Thêm vào HoaDonDatPhong
						KhuyenMai km = new KhuyenMai(null);
						java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
						HoaDonDatPhong hddp = new HoaDonDatPhong(maHoaDon, kh, nv, sqlDate, false, km, 0.0);
						if(check == 0) {						
							hddp_dao.addHoaDonDatPhong(hddp);
							check = 1;
						}
						
						// Thêm chi tiết hóa đơn
						ChiTietHoaDon cthd;
						if (radGioTuDo.isSelected()) {
							cthd = new ChiTietHoaDon(hddp, p, Timestamp.valueOf(LocalDateTime.now()),
									Timestamp.valueOf(LocalDateTime.now()), 0);
						} else {
							cthd = new ChiTietHoaDon(hddp, p, Timestamp.valueOf(LocalDateTime.now()),
									Timestamp.valueOf(dateTimePicker.getDateTimeStrict()), 0);
						}
						cthd_dao.addChiTietHD(cthd);
						
						// Thêm chi tiết dịch vụ
						if (DataManager.getCtdvTempList() != null) {
							for (TempThemDV tmp : DataManager.getCtdvTempList()) {
								ChiTietDichVu ctdv = new ChiTietDichVu(hddp, new Phong(tmp.getMaPhong()),
										new SanPham(tmp.getMaSP()), tmp.getSoLuong(), tmp.getDonGia());
								if (ctdv.getPhong().getMaPhong().equals(tmpDatPhong.getMaPhong())) {
									ctdv_dao.addChiTietDV(ctdv);
								}
							}
						}
					}
				}
				tmpDatPhong_dao.deleteALLTempDatPhong();
				DataManager.setDatPhong(true);
				JOptionPane.showMessageDialog(this, "Đặt phòng thành công, thời gian bắt đầu được tính!");
				setVisible(false);
			} else {
				JOptionPane.showMessageDialog(this, "Bạn chưa thêm khách hàng!");
			}
		}
		if (o.equals(btn_DatThemPhong)) {
			if (checkBox_KH.isSelected()) {
				DataManager.setSoDienThoaiKHDat("0000000000");
			}
			setVisible(false);
		}
		if (o.equals(btn_XoaPhongDat)) {
			xoa();
		}
		// chọn nút checkbox mặc định giờ
		if (radGioMacDinh.isSelected()) {
			dateTimePicker.setEnabled(true);
		} else {
			dateTimePicker.setEnabled(false);
		}
		// kiem tra khach hang
		if (o.equals(btn_KiemTraSDT)) {
			khachHang_dao = new KhachHang_dao();
			String sdt = txtSDT.getText();
			KhachHang khachHang = khachHang_dao.TimkiemSDT_KHachHang(sdt);
			if (khachHang != null) {
				String hoTen = khachHang.getHoTen();
				boolean gioiTinh = khachHang.isGioiTinh();
				String gioiTinhStr = gioiTinh ? "Nam" : "Nữ";
				lbl_GioiTinh_1.setText(gioiTinhStr);
				lbl_TenKH_1.setText(hoTen);
				DataManager.setSoDienThoaiKHDat(txtSDT.getText());
			} else {
				int checkCustomer = JOptionPane.showConfirmDialog(this,
						"Khách hàng chưa có trên hệ thống! Bạn có muốn thêm khách hàng không?");
				DataManager.setSoDienThoaiKHDat(txtSDT.getText());
				DataManager.setLoadSDT(true);
				if (checkCustomer == JOptionPane.YES_OPTION) {
					trangChu.showKhachHangCard();
					setVisible(false);
				}
			}
		}
		if (o.equals(checkBox_KH)) {
			if (checkBox_KH.isSelected()) {
				lbl_TenKH_1.setText("Nguyễn Văn A");
				lbl_GioiTinh_1.setText("Nam");
				txtSDT.setEnabled(false);
				btn_KiemTraSDT.setEnabled(false);
			} else {
				txtSDT.setEnabled(true);
				btn_KiemTraSDT.setEnabled(true);
			}
		}
		if (o.equals(btnXoaDV)) {
			xoaDV();
		}

	}

	public void xoaDV() {
		if (tblDV.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để xóa!");
		} else {
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa Sản phẩm này không?", "Thông báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				int row = tblDV.getSelectedRow();
				ArrayList<TempThemDV> ds = DataManager.getCtdvTempList();
				for(TempThemDV temp : ds) {
					if(temp.getMaPhong().equals(model.getValueAt(tblThemPhongMoi.getSelectedRow(), 1).toString()) 
							&& temp.getMaSP().equals(modelDV.getValueAt(row, 1).toString())) {
						ds.remove(temp);
						JOptionPane.showMessageDialog(this, "Xóa thành công!");
						modelDV.removeRow(row);
					}
				}
				DataManager.setCtdvTempList(ds);
			}
		}
	}

	private int ThuTuPhieuDatPhongTrongNgay() {
		int sl = 1;
		String maPDP = "";
		for (PhieuDatPhong pdp : pdp_dao.getAllsPhieuDatPhong()) {
			maPDP = pdp.getMaPhieu(); // Chạy hết vòng for sẽ lấy được mã Phiếu đặt phòng cuối danh sách
		}
		int ngayTrenMaPDPCuoiDS = Integer.parseInt(maPDP.substring(3, 9));
		DateFormat dateFormat = new SimpleDateFormat("yyMMdd"); // Format yyMMdd sẽ so sánh ngày được
		ngayHienTai = new Date();
		int ngayHT = Integer.parseInt(dateFormat.format(ngayHienTai));
		if (ngayHT != ngayTrenMaPDPCuoiDS) {
			sl = 1;
		} else if (ngayHT == ngayTrenMaPDPCuoiDS) {
			sl = Integer.parseInt(maPDP.substring(9, 13)) + 1;
		}
		return sl;
	}

	private String TaoMaPDP() {
		String prefix = "PDP";
		DateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		date = new Date();
		String suffix = String.format("%04d", ThuTuPhieuDatPhongTrongNgay());
		return prefix + dateFormat.format(date) + suffix;
	}

	private int ThuTuHoaDonDatPhongTrongNgay() {
		int sl = 1;
		String maHDDP = "";
		for (HoaDonDatPhong hddp : hddp_dao.getAllHoaDonDatPhong()) {
			maHDDP = hddp.getMaHoaDon(); // Chạy hết vòng for sẽ lấy được mã Phiếu đặt phòng cuối danh sách
		}
		int ngayTrenMaHDDPCuoiDS = Integer.parseInt(maHDDP.substring(2, 8));
		DateFormat dateFormat = new SimpleDateFormat("yyMMdd"); // Format yyMMdd sẽ so sánh ngày được
		ngayHienTai = new Date();
		int ngayHT = Integer.parseInt(dateFormat.format(ngayHienTai));
		if (ngayHT != ngayTrenMaHDDPCuoiDS) {
			sl = 1;
		} else if (ngayHT == ngayTrenMaHDDPCuoiDS) {
			sl = Integer.parseInt(maHDDP.substring(8, 12)) + 1;
		}
		return sl;
	}

	private String TaoMaHDDP() {
		String prefix = "HD";
		DateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		date = new Date();
		String suffix = String.format("%04d", ThuTuHoaDonDatPhongTrongNgay());
		return prefix + dateFormat.format(date) + suffix;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tblThemPhongMoi.getSelectedRow();
		lblMaPhong.setText("Mã phòng: " + model.getValueAt(row, 1));
		lbl_Loai.setText("Loại: " + model.getValueAt(row, 2));
		txtSoNguoi.setText(model.getValueAt(row, 3).toString());
		lbl_GiaTien_1.setText(model.getValueAt(row, 4) + "VNĐ");
//		if(model.getValueAt(row, 1).equals(DataManager.getMaPhong())) {
//			clearTableDV();
//			loadDataDV(DataManager.getMaPhong());
//		}
		clearTableDV();
		loadDataDV(model.getValueAt(row, 1).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
