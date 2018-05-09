package presentation.views;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class BasicView extends JFrame{
	private JPanel content;
	private JTextField username;
	private JTextField password;
	private JButton viewArticles;
	private JButton login;
	
	public BasicView() {
		this.setTitle("Basic View");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		content = new JPanel();
		this.setContentPane(content);
		content.setLayout(null);
		
		viewArticles = new JButton("View Articles");
		viewArticles.setBounds(90, 40, 120, 25);
		content.add(viewArticles);
		
		login = new JButton("Login as author");
		login.setBounds(90, 200, 120, 25);
		content.add(login);
		
		username = new JTextField();
		username.setBounds(90, 100, 120, 20);
		content.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(90, 160, 120, 20);
		content.add(password);
		password.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(90, 80, 120, 20);
		content.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(90, 140, 120, 20);
		content.add(lblNewLabel);
	}
	
	public void addLoginListener(ActionListener al) {
		login.addActionListener(al);
	}
	
	public void addViewArticlesListener(ActionListener al) {
		viewArticles.addActionListener(al);
	}
	
	public String getUsername() {
		return username.getText();
	}
	
	public String getPassword() {
		return password.getText();
	}
}
