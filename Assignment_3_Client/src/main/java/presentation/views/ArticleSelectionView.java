package presentation.views;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ArticleSelectionView extends JFrame{
	private JPanel content;
	JComboBox<String> articleList;
	JButton select;
	
	public ArticleSelectionView() {
		this.setTitle("Article Selection");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		content = new JPanel();
		this.setContentPane(content);
		content.setLayout(null);
		
		articleList = new JComboBox<String>();
		articleList.setBounds(50, 100, 200, 20);
		content.add(articleList);
		
		select = new JButton("Select");
		select.setBounds(90, 150, 120, 25);
		content.add(select);
	}
	
	public void addSelectListener(ActionListener al) {
		select.addActionListener(al);
	}
	
	public String getArticle() {
		return (String) articleList.getSelectedItem();
	}
	
	public void setArticles(List<String> articles) {
		for(String s: articles) {
			articleList.addItem(s);
		}
	}
}
