package presentation.views;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AuthorView extends JFrame{
	private JPanel content;
	private JButton viewArticles;
	private JButton createArticle;
	private JButton logout;
	
	public AuthorView() {
		this.setTitle("Author View");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 200);
		content = new JPanel();
		this.setContentPane(content);
		content.setLayout(null);
		
		viewArticles = new JButton("View Articles");
		viewArticles.setBounds(90, 40, 120, 25);
		content.add(viewArticles);
		
		createArticle = new JButton("Create Article");
		createArticle.setBounds(90, 70, 120, 25);
		content.add(createArticle);
		
		logout = new JButton("Logout");
		logout.setBounds(90, 100, 120, 25);
		content.add(logout);
	}
	
	public void addLogoutListener(ActionListener al) {
		logout.addActionListener(al);
	}
	
	public void addViewArticlesListener(ActionListener al) {
		viewArticles.addActionListener(al);
	}
	
	public void addCreateArticleListener(ActionListener al) {
		createArticle.addActionListener(al);
	}
	
}
