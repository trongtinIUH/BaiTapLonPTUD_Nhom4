package app;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;

import entity.Temp;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;



public class GD_TrangChu extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel cardPanel;
	private CardLayout cardLayout;
	private final JPanel panel_1 = new JPanel();
	private JButton btnDatPhong;
	private JButton btnDanhSachPhong;
	private JButton btnNhanVien;
	private JButton btnKhachHang;
	private JButton btnSanPham;
	private JButton btnHoaDon;
	private JButton btnThongKe;
	private JButton btnTroGiup;
	private JLabel lblKaraoke;
	private JLabel lblCurrentTime;
	private  GD_DatPhong datPhong = new GD_DatPhong();
	GD_DanhSachPhong danhSachPhong = new GD_DanhSachPhong();
	GD_NhanVien nhanVien = new GD_NhanVien();
	GD_KhachHang khachHang = new GD_KhachHang();
	GD_HoaDon hoaDon = new GD_HoaDon();
	GD_SanPham sanPham = new GD_SanPham();
	GD_ThongKe thongKe = new GD_ThongKe();
	GD_TroGiup troGiup = new GD_TroGiup();
	private JPanel panel_chuaTime;
	public GD_TrangChu() {
		super("Karaoke 4T");
		ImageIcon icon = new ImageIcon("icon\\icon_Karaoke3.jpg");
	    this.setIconImage(icon.getImage());
		initialize();
	}

	public static void main(String[] args) {
		GD_TrangChu home = new GD_TrangChu();
		home.setVisible(true);
	}
	
	private void initialize() {
		
		// hiển thị full màn hình
		setBounds(0, 0, 1366, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel_1.setBorder(new CompoundBorder());
		panel_1.setBackground(Color.CYAN);
		
		this.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 1, 8, 1));
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(217, 226, 231));
		panel_1.add(panel_2);
		

		
		 btnDatPhong = new JButton("ĐẶT PHÒNG");
		 btnDatPhong.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnDatPhong.setForeground(Color.BLACK);
		 btnDatPhong.setBackground(Color.white);
		 btnDatPhong.setHorizontalAlignment(SwingConstants.LEFT); //căn lề trái button
		 btnDatPhong.setIconTextGap(25); //Tạo Khoảng cách giữa icon và Nội dung(text)
		 btnDatPhong.setIcon(new ImageIcon("icon\\icon_DatPhong.png"));
		 btnDatPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		 btnDatPhong.setBorderPainted(false);
		 btnDatPhong.setBackground(new Color(217, 226, 231));
		
		 btnDanhSachPhong = new JButton("DANH SÁCH PHÒNG");
		 btnDanhSachPhong.setHorizontalAlignment(SwingConstants.LEFT); //căn lề trái button
		 btnDanhSachPhong.setIconTextGap(10); //Tạo Khoảng cách giữa icon và Nội dung(text)
		 btnDanhSachPhong.setIcon(new ImageIcon("icon\\icon_DSPhong.png"));
		 btnDanhSachPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		 btnDanhSachPhong.setBorderPainted(false);
		 btnDanhSachPhong.setForeground(Color.BLACK);
		 btnDanhSachPhong.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnDanhSachPhong.setBackground(new Color(217, 226, 231));
		
		btnNhanVien = new JButton("NHÂN VIÊN");
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT); //căn lề trái button
		btnNhanVien.setIconTextGap(35); //Tạo Khoảng cách giữa icon và Nội dung(text)
		btnNhanVien.setIcon(new ImageIcon("icon\\icon_NhanVien.png"));
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNhanVien.setBorderPainted(false);
		btnNhanVien.setForeground(Color.BLACK);
		btnNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNhanVien.setBackground(new Color(217, 226, 231));
		
		btnKhachHang = new JButton("KHÁCH HÀNG");
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKhachHang.setBorderPainted(false);
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT); //căn lề trái button
		btnKhachHang.setIconTextGap(20); //Tạo Khoảng cách giữa icon và Nội dung(text)
		btnKhachHang.setIcon(new ImageIcon("icon\\icon_KhachHang.png"));
		btnKhachHang.setForeground(Color.BLACK);
		btnKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnKhachHang.setBackground(new Color(217, 226, 231));
		
		btnSanPham = new JButton("SẢN PHẨM");
		btnSanPham.setHorizontalAlignment(SwingConstants.LEFT); //căn lề trái button
		btnSanPham.setIconTextGap(27); //Tạo Khoảng cách giữa icon và Nội dung(text)
		btnSanPham.setIcon(new ImageIcon("icon\\icon_SanPham.png"));
		btnSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSanPham.setBorderPainted(false);
		btnSanPham.setForeground(Color.BLACK);
		btnSanPham.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSanPham.setBackground(new Color(217, 226, 231));
		
		/// Hóa đơn
		 btnHoaDon = new JButton("HÓA ĐƠN");
		 btnHoaDon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		 btnHoaDon.setBorderPainted(false);
		 btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT); //căn lề trái button
		 btnHoaDon.setIconTextGap(30); //Tạo Khoảng cách giữa icon và Nội dung(text)
		 btnHoaDon.setIcon(new ImageIcon("icon\\icon_HoaDon.png"));
		 btnHoaDon.setForeground(Color.BLACK);
		 btnHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnHoaDon.setBackground(new Color(217, 226, 231));
		 
		//thống kê 
		 btnThongKe = new JButton("THỐNG KÊ");
		 btnThongKe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		 btnThongKe.setBorderPainted(false);
		 btnThongKe.setHorizontalAlignment(SwingConstants.LEFT); //căn lề trái button
		 btnThongKe.setIconTextGap(20); //Tạo Khoảng cách giữa icon và Nội dung(text)
		 btnThongKe.setIcon(new ImageIcon("icon\\icon_ThongKe.png"));
		 btnThongKe.setForeground(Color.BLACK);
		 btnThongKe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnThongKe.setBackground(new Color(217, 226, 231));
		
		//Trợ giúp
		 btnTroGiup = new JButton("TRỢ GIÚP");
		 btnTroGiup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		 btnTroGiup.setBorderPainted(false);
		 btnTroGiup.setHorizontalAlignment(SwingConstants.LEFT); //căn lề trái button
		 btnTroGiup.setIconTextGap(35); //Tạo Khoảng cách giữa icon và Nội dung(text)
		 btnTroGiup.setIcon(new ImageIcon("icon\\icon_TroGiup.png"));
		 btnTroGiup.setForeground(Color.BLACK);
		 btnTroGiup.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnTroGiup.setBackground(new Color(217, 226, 231));
		 
		 //user
//		 btnUser.setIcon(new ImageIcon("icon\\icon_User.png"));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(217, 226, 231));
		
		JPanel pnMargin = new JPanel();
		pnMargin.setPreferredSize(new Dimension(300, 20));
		pnMargin.setBackground(new Color(217, 226, 231));
		panel_3.add(pnMargin);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 165, 0));
		lblNewLabel_1.setIcon(new ImageIcon("image\\hinh_trangdangnhap.jpg"));
		lblNewLabel_1.setBounds(0, 100, 100, 100);
		ImageIcon hinhgt1= new ImageIcon("image\\hinh_trangdangnhap.jpg");
		Image image1 = hinhgt1.getImage();
		Image newImage1 = image1.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		hinhgt1 = new ImageIcon(newImage1);
		lblNewLabel_1.setIcon(hinhgt1);
		panel_3.add(lblNewLabel_1);
		
		lblKaraoke= new JLabel("KARAOKE 4T");
		lblKaraoke.setHorizontalAlignment(SwingConstants.CENTER);
		lblKaraoke.setBounds(0, 100, 100, 30);
		lblKaraoke.setFont(new Font("Arial", Font.BOLD, 14));
		lblKaraoke.setForeground(Color.black);
		panel_3.add(lblKaraoke);
		
		panel_chuaTime = new JPanel();
		panel_chuaTime.setBackground(Color.WHITE);
		 
		 
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_2.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnDatPhong, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
							.addComponent(btnDanhSachPhong, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
							.addComponent(btnNhanVien, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
							.addComponent(btnKhachHang, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
							.addComponent(btnSanPham, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
							.addComponent(btnHoaDon, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
							.addComponent(btnThongKe, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
							.addComponent(btnTroGiup, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))))
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_chuaTime, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(btnDatPhong, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(btnDanhSachPhong, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(btnNhanVien, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(btnKhachHang, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(btnSanPham, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(btnHoaDon, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(btnThongKe, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(btnTroGiup, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(panel_chuaTime, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
		);
		
		// CurrentTime
		 lblCurrentTime = new JLabel();
		 lblCurrentTime.setHorizontalAlignment(SwingConstants.CENTER);
		 lblCurrentTime.setFont(new Font("Times New Roman", Font.BOLD, 22));
		 lblCurrentTime.setForeground(Color.BLACK);
		 lblCurrentTime.setBackground(Color.WHITE);
		 new Thread(new Runnable() {
			  public void run() {
			    while (true) {
			      Calendar cal = Calendar.getInstance();
			      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			      lblCurrentTime.setText(sdf.format(cal.getTime()));
			      try {
			        Thread.sleep(1000); 
			      } catch (InterruptedException e) {}
			    }
			  }
			}).start();
		 panel_chuaTime.add(lblCurrentTime);
		 
		panel_2.setLayout(gl_panel_2);
		
		new JPanel();
		cardPanel = new JPanel();
	    cardLayout = new CardLayout();
	    cardPanel.setLayout(cardLayout);
	    JPanel trangChu = new JPanel();
	    trangChu.setBackground(Color.black);
	    JLabel lblNewLabel_2 = new JLabel("");
	    lblNewLabel_2.setIcon(new ImageIcon("image\\TrangChu.jpg"));
	    lblNewLabel_2.setBounds(0, 100, 1080, 730);
		ImageIcon hinhgt= new ImageIcon("image\\TrangChu.jpg");
		Image image = hinhgt.getImage();
		Image newImage = image.getScaledInstance(1080, 730, java.awt.Image.SCALE_SMOOTH);
		hinhgt = new ImageIcon(newImage);
		lblNewLabel_2.setIcon(hinhgt);
		trangChu.add(lblNewLabel_2);
	    cardPanel.add(trangChu, "TrangChu");
	    cardPanel.add(datPhong, "DatPhong");
	    cardPanel.add(danhSachPhong, "DanhSachPhong");  
	    cardPanel.add(nhanVien, "NhanVien");  
	    cardPanel.add(khachHang, "KhachHang");  
	    cardPanel.add(hoaDon, "HoaDon");  
	    cardPanel.add(sanPham, "SanPham");  
	    cardPanel.add(thongKe, "ThongKe");  
	    cardPanel.add(troGiup, "TroGiup");  
		getContentPane().add(cardPanel, BorderLayout.CENTER);
		
		btnDatPhong.addActionListener(this);
		btnDanhSachPhong.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnSanPham.addActionListener(this);
		btnHoaDon.addActionListener(this);
		btnThongKe.addActionListener(this);
		btnTroGiup.addActionListener(this);
//		btnUser.addActionListener(this);
	}
	
	private void resetActiveTab() {
		btnDatPhong.setBackground(new Color(217, 226, 231));
		btnDanhSachPhong.setBackground(new Color(217, 226, 231));
		btnNhanVien.setBackground(new Color(217, 226, 231));
		btnKhachHang.setBackground(new Color(217, 226, 231));
		btnHoaDon.setBackground(new Color(217, 226, 231));
		btnSanPham.setBackground(new Color(217, 226, 231));
		btnThongKe.setBackground(new Color(217, 226, 231));
		btnTroGiup.setBackground(new Color(217, 226, 231));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		Object o = e.getSource();
		if(o.equals(btnDatPhong)) {
			resetActiveTab();
			btnDatPhong.setBackground(Color.decode("#F2F0FF"));
			cardLayout.show(cardPanel, "DatPhong");
		} else if(o.equals(btnDanhSachPhong)) {
			resetActiveTab();
			btnDanhSachPhong.setBackground(Color.decode("#F2F0FF"));
			cardLayout.show(cardPanel, "DanhSachPhong");
		} else if(o.equals(btnNhanVien)) {
			resetActiveTab();
			btnNhanVien.setBackground(Color.decode("#F2F0FF"));
			cardLayout.show(cardPanel, "NhanVien");
		}else if(o.equals(btnKhachHang)) {
			resetActiveTab();
			btnKhachHang.setBackground(Color.decode("#F2F0FF"));
			cardLayout.show(cardPanel, "KhachHang");
		}else if(o.equals(btnHoaDon)) {
			resetActiveTab();
			btnHoaDon.setBackground(Color.decode("#F2F0FF"));
			cardLayout.show(cardPanel, "HoaDon");
		}else if(o.equals(btnSanPham)) {
			resetActiveTab();
			btnSanPham.setBackground(Color.decode("#F2F0FF"));
			cardLayout.show(cardPanel, "SanPham");
		}else if(o.equals(btnThongKe)) {
			resetActiveTab();
			btnThongKe.setBackground(Color.decode("#F2F0FF"));
			cardLayout.show(cardPanel, "ThongKe");
		} else if(o.equals(btnTroGiup)) {
			resetActiveTab();
			btnTroGiup.setBackground(Color.decode("#F2F0FF"));
			cardLayout.show(cardPanel, "TroGiup");
		}
	}
}