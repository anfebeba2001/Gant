package src.Controlador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import src.Vista.Window;
import src.Modelo.Model;

import java.util.Timer;
import java.util.TimerTask;


public class Controller {

	private Model model;
	private Window view;

	public Controller(Model model, Window view) {
		this.model = model;
		this.view = view;
	}

	public void initController(String[] columnName) {
		setTableColumName(columnName);
		view.getPanelAction().getBtnInit().addActionListener(e -> initAction());
		view.getPanelAction().getBtnPoll().addActionListener(e -> pollAction());
		view.getPanelAction().getBtnAdd().addActionListener(e -> addAction());
		view.getPanelAction().getBtnAddAuto().addActionListener(e -> {
            try {
                addAutoAction();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
		view.getPanelAction().getBtnServeAuto().addActionListener(e -> serveAuto());
		view.getPanelAction().getBtnStopServe().addActionListener(e -> stopServeAuto());
		view.getPanelAction().getBtnStopAuto().addActionListener(e-> stopAuto());
		view.getPanelAction().getBtnRestart().addActionListener(e -> restartAction());
		view.getPanelAction().getBtnExit().addActionListener(e -> exitAction());
		view.setVisible(true);
	}



	private void setTableColumName(String[] columnName) {
		if (this.view.getPanelTable().getTableModel() == null)
			this.view.getPanelTable().setTableModel(new DefaultTableModel(columnName, 0));
	}


	Timer timer2 ;


   private void addAutoAction() throws InterruptedException {

	   TimerTask task = new TimerTask()
	   {
			public void run()
		   {
			   addAction();
		   }
	   };
		timer2 = new Timer();
	   	timer2.schedule(task, 1000,2000);


   }
	private void stopAuto()
	{
		timer2.cancel();
	}

		Timer timer3;

	private void stopServeAuto() {
		timer3.cancel();
	}

	private void serveAuto() {

		TimerTask task = new TimerTask()
		{
			public void run()
			{
				pollAction();
			}
		};
		timer3 = new Timer();
		timer3.schedule(task, 1000,2500);
	}

	private void addAction() {
		view.getPanelTableReadyQueue().getTableModel().addRow(model.getQueueReady().addProcess());
	}

	private void initAction() {
		if (model.getQueueReady().getSerialId() == 0) {
			for (int i = 1; i <= 5; i++)
				view.getPanelTableReadyQueue().getTableModel().addRow(model.getQueueReady().addProcess());
		} else {
			JOptionPane.showMessageDialog(null, "¡No se puede inciar más de una vez!", "Iniciar",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void pollAction() {
		if (!model.getQueueReady().isQueueEmpty()) {
			view.getPanelTableReadyQueue().getTableModel().removeRow(0);
			Object[] data = model.getQueueReady().getDataProcess(model.getQueueReady().pollProcess());
			view.getPanelTable().getTableModel().addRow(data);
			view.getPanelTableGantt().paintProcess(data);
		} else {
	
			timer3.cancel();

			timer3.cancel();
			JOptionPane.showMessageDialog(null, "¡No hay ningún procesos por atender!", "Atender",
					JOptionPane.WARNING_MESSAGE);
		}
	}





	private void restartAction() {
		int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que quiere reiniciar del programa?", "Reiniciar",
				JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_OPTION) {
			try {
				model.finalizeQueues();
				model = new Model();
				view.getPanelTable().getTableModel().setNumRows(0);
				view.getPanelTableReadyQueue().getTableModel().setNumRows(0);

				view.getPanelTableGantt().getTableModel().setNumRows(0);
				view.getPanelTableGantt().getTableModel().setColumnCount(1);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	private void exitAction() {
		int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que quiere salir del programa?", "Salir",
				JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_OPTION)
			try {
				model.finalizeQueues();
				System.exit(0);
			} catch (Throwable e) {
				e.printStackTrace();
			}
	}
}
