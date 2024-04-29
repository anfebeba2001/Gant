package src.Vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ActionPanel extends JPanel {

	private JButton btnInit;
	private JButton btnPoll;
	private JButton btnAdd;

	private JButton btnRestart;
	private JButton btnExit;
	private JButton btnStopAuto;
	private JButton btnAddAuto;
	private JButton btnServeAuto;
	private JButton btnStopServe;

	public ActionPanel(JFrame window) {

		this.setBackground(new Color(117, 171, 224));
		btnInit = new JButton("Iniciar");

		add(btnInit);

		btnPoll = new JButton("Atender");
		add(btnPoll);

		btnAdd = new JButton("Agregar");
		add(btnAdd);

		btnAddAuto = new JButton("Agregar auto");
		add(btnAddAuto);

		btnStopAuto = new JButton("DetenerAuto");
		btnStopAuto.setBackground(new Color(252, 42, 57));
		add(btnStopAuto);

		btnServeAuto = new JButton("Atender auto");
		add(btnServeAuto);

		btnStopServe = new JButton("Detener Atender");
		btnStopServe.setBackground(new Color(252, 42, 57));
		add(btnStopServe);

		btnRestart = new JButton("Reiniciar");
		add(btnRestart);

		btnExit = new JButton("Salir");
		add(btnExit);

		setVisible(true);
	}

	public JButton getBtnInit() {
		return btnInit;
	}

	public void setBtnInit(JButton btnInit) {
		this.btnInit = btnInit;
	}

	public JButton getBtnPoll() {
		return btnPoll;
	}

	public void setBtnPoll(JButton btnPoll) {
		this.btnPoll = btnPoll;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JButton getBtnStopAuto(){return btnStopAuto;}

	public void setBtnStopAuto(JButton btnStopAuto){this.btnStopAuto = btnStopAuto;}

	public JButton getBtnAddAuto(){return btnAddAuto;}

	public JButton getBtnServeAuto() {return btnServeAuto;}

	public JButton getBtnStopServe() {return btnStopServe;}

	public void setBtnAddAuto(JButton btnAddAuto){this.btnAddAuto = btnAddAuto;}
	
	public JButton getBtnRestart() {
		return btnRestart;
	}

	public void setBtnRestart(JButton btnRestart) {
		this.btnRestart = btnRestart;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}
}
