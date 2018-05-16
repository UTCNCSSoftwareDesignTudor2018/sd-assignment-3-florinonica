package presentation.views;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.Article;

@SuppressWarnings("serial")
public class ArticleView extends JFrame{
	private Article article;
	private JPanel content;
	private JTextField articleTitle;
	private JTextField summary;
	private JTextField contents;
	JButton update;
	JButton delete;
	JButton articleList;
	private JTextField author;
	
	public ArticleView() {
		this.setTitle("Article View");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 1000);
		content = new JPanel();
		this.setContentPane(content);
		content.setLayout(null);
		
		articleTitle = new JTextField();
		articleTitle.setBounds(30, 20, 450, 25);
		content.add(articleTitle);
		articleTitle.setColumns(10);
		
		summary = new JTextField();
		summary.setBounds(30, 120, 450, 150);
		content.add(summary);
		summary.setColumns(10);
		
		contents = new JTextField();
		contents.setBounds(30, 300, 500, 450);
		content.add(contents);
		contents.setColumns(10);
		
		update = new JButton("Update");
		update.setBounds(110, 800, 100, 25);
		content.add(update);
		
		delete = new JButton("Delete");
		delete.setBounds(284, 800, 100, 25);
		content.add(delete);
		
		articleList = new JButton("Article List");
		articleList.setBounds(215, 875, 100, 25);
		content.add(articleList);
		
		update.setVisible(false);
		delete.setVisible(false);
		
		articleTitle.setEditable(false);
		summary.setEditable(false);
		contents.setEditable(false);
		
		author = new JTextField();
		author.setBounds(30, 70, 450, 25);
		content.add(author);
		author.setColumns(10);
		author.setEditable(false);
	}
	
	public void authorView() {
		update.setVisible(true);
		delete.setVisible(true);
		author.setEditable(true);
		articleTitle.setEditable(true);
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
		return articleTitle.getText();
	}

	public void setArticleTitles(String title) {
		this.articleTitle.setText(title);
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

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	public String getAuthor() {
		return author.getText();
	}

	public void setAuthor(String author) {
		this.author.setText(author);
	}
}
