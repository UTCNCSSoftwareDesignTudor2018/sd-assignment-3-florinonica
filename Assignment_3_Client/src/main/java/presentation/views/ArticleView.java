package presentation.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ArticleView extends JFrame{
	private JPanel content;
	private JTextField title;
	private JTextField summary;
	private JTextField contents;
	JButton update;
	JButton delete;
	JButton articleList;
	
	public ArticleView() {
		this.setTitle("Article View");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 1000);
		content = new JPanel();
		this.setContentPane(content);
		content.setLayout(null);
		
		title = new JTextField();
		title.setBounds(30, 27, 452, 25);
		content.add(title);
		title.setColumns(10);
		
		summary = new JTextField();
		summary.setBounds(30, 77, 452, 148);
		content.add(summary);
		summary.setColumns(10);
		
		contents = new JTextField();
		contents.setBounds(30, 255, 503, 448);
		content.add(contents);
		contents.setColumns(10);
		
		update = new JButton("Update");
		update.setBounds(110, 760, 89, 23);
		content.add(update);
		
		delete = new JButton("Delete");
		delete.setBounds(284, 760, 89, 23);
		content.add(delete);
		
		articleList = new JButton("Article List");
		articleList.setBounds(215, 833, 89, 23);
		content.add(articleList);
		
		update.setVisible(false);
		delete.setVisible(false);
		title.setEditable(false);
		summary.setEditable(false);
		contents.setEditable(false);
	}
	
	public void AuthorView() {
		update.setVisible(true);
		delete.setVisible(true);
		title.setEditable(true);
		summary.setEditable(true);
		contents.setEditable(true);
	}
	
	public void addUpdateListener(ActionListener al) {
		update.addActionListener(al);
	}
	
	public void addDeleteListener(ActionListener al) {
		delete.addActionListener(al);
	}
	
	public void addArticleListListener(ActionListener al) {
		articleList.addActionListener(al);
	}

	public String getTitle() {
		return title.getText();
	}

	public void setTitle(String title) {
		this.title.setText(title);
	}

	public String getSummary() {
		return summary.getText();
	}

	public void setSummary(String summary) {
		this.summary.setText(summary);
	}

	public String getContents() {
		return contents.getText();
	}

	public void setContents(String contents) {
		this.contents.setText(contents);
	}

}
