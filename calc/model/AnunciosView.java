package model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AnunciosView {

	private JFrame frame;

	
	public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
		public void run() {
		try {
                    AnunciosView window = new AnunciosView();
                    window.frame.setVisible(true);
		} catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
    }

	
	public AnunciosView() {
            initialize();
	}

	
	private void initialize() {
            frame = new JFrame();
            frame.setBounds(100, 100, 862, 510);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);
    }

}