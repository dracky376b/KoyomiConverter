package com.yuuki.local;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @brief Convert between the Western and Japanese calendars.
 * @author　Yuuki Tatsuya
 * @version　1.0
 * @history Created by Yuuki on October 27th, 2024.
 */
public class KoyomiConverter implements ActionListener {

	/**
	 * @summary Action messages for pushing button and selecting radio buttons.
	 */
	public static final String BTN_CONVERT = "btn_convert";
	public static final String RD_SEIREKI = "rd_seireki";
	public static final String RD_MEIJI = "rd_meiji";
	public static final String RD_TAISHO = "rd_taisho";
	public static final String RD_SHOWA = "rd_showa";
	public static final String RD_HEISEI = "rd_heisei";
	public static final String RD_REIWA = "rd_reiwa";

	/**
	 * @summary Constant strings.
	 */
	public static final String S_TITLE = "西暦⇔和暦 変換";
	public static final String S_YEAR = "年";
	public static final String S_CONVERT = "変換";
	public static final String S_CV_ERROR = "変換エラー";

	/**
	 * @summary GUI parts.
	 */
	private JFrame frame;
	private JTextField tfYear;

	/**
	 * @summary The value of which radio button is selected.
	 */
	private int rd_selected;

	/**
	 * @brief Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KoyomiConverter window = new KoyomiConverter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @brief Create the application.
	 */
	public KoyomiConverter() {
		initialize();
		rd_selected = ConvertYear.SEIREKI;
	}

	/**
	 * @brief Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(S_TITLE);
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		ImageIcon icon = new ImageIcon("./icon.png");
//		frame.setIconImage(icon.getImage());
		
		JPanel pnl1 = new JPanel();

	    JLabel label = new JLabel(S_YEAR);
	    tfYear = new JTextField(4);
	    JButton btn = new JButton(S_CONVERT);
	    btn.addActionListener(this);
	    btn.setActionCommand(BTN_CONVERT);
	    
	    pnl1.add(label);
	    pnl1.add(tfYear);
	    pnl1.add(btn);

	    frame.add(pnl1, BorderLayout.NORTH);
	    
	    JRadioButton rdSeireki = new JRadioButton(ConvertYear.S_SEIREKI, true);
	    rdSeireki.addActionListener(this);
	    rdSeireki.setActionCommand(RD_SEIREKI);
	    
	    JRadioButton rdMeiji = new JRadioButton(ConvertYear.S_MEIJI);
	    rdMeiji.addActionListener(this);
	    rdMeiji.setActionCommand(RD_MEIJI);
	    
	    JRadioButton rdTaisho = new JRadioButton(ConvertYear.S_TAISHO);
	    rdTaisho.addActionListener(this);
	    rdTaisho.setActionCommand(RD_TAISHO);
	    
	    JRadioButton rdShowa = new JRadioButton(ConvertYear.S_SHOWA);
	    rdShowa.addActionListener(this);
	    rdShowa.setActionCommand(RD_SHOWA);
	    
	    JRadioButton rdHeisei = new JRadioButton(ConvertYear.S_HEISEI);
	    rdHeisei.addActionListener(this);
	    rdHeisei.setActionCommand(RD_HEISEI);

	    JRadioButton rdReiwa = new JRadioButton(ConvertYear.S_REIWA);
	    rdReiwa.addActionListener(this);
	    rdReiwa.setActionCommand(RD_REIWA);

	    ButtonGroup bgrp = new ButtonGroup();
	    bgrp.add(rdSeireki);
	    bgrp.add(rdMeiji);
	    bgrp.add(rdTaisho);
	    bgrp.add(rdShowa);
	    bgrp.add(rdHeisei);
	    bgrp.add(rdReiwa);
	    
	    JPanel pnl2 = new JPanel();
	    pnl2.add(rdSeireki);
	    pnl2.add(rdMeiji);
	    pnl2.add(rdTaisho);
	    pnl2.add(rdShowa);
	    pnl2.add(rdHeisei);
	    pnl2.add(rdReiwa);
	    
	    frame.add(pnl2, BorderLayout.CENTER);
	}

	/**
	 * @brief This method calls when pushing button or selecting radio-button.
	 * @param e  ActionEvent includes ActionCommand.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		switch (str) {
		case BTN_CONVERT:
			int year;
			String msg = "";
			try {
				year = Integer.parseInt(tfYear.getText());
				ConvertYear cy = new ConvertYear();
				msg = cy.convert(year, rd_selected);
			} catch (NumberFormatException ex) {
				msg = S_CV_ERROR;
			} finally {
				JOptionPane.showMessageDialog(null, msg);
			}
			break;
		case RD_SEIREKI:
			rd_selected = ConvertYear.SEIREKI;
			break;
		case RD_MEIJI:
			rd_selected = ConvertYear.MEIJI;
			break;
		case RD_TAISHO:
			rd_selected = ConvertYear.TAISHO;
			break;
		case RD_SHOWA:
			rd_selected = ConvertYear.SHOWA;
			break;
		case RD_HEISEI:
			rd_selected = ConvertYear.HEISEI;
			break;
		case RD_REIWA:
			rd_selected = ConvertYear.REIWA;
			break;
		default:
			break;	
		}
	}
	
}
