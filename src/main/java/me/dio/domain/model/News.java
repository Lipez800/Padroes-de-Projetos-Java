package me.dio.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_news")
public class News extends BaseItem {

  @Column(name = "news_title")
  private String title;

  @Column(name = "news_content")
  private String content;

  public News() {
    // Construtor padrão vazio
  }

  public News(String icon, String description, String title, String content) {
    super(icon, description);
    this.title = title;
    this.content = content;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  // Adicione métodos específicos da classe News, se necessário.

  @Override
  public String toString() {
    return "News{" +
        "id=" + getId() +
        ", icon='" + getIcon() + '\'' +
        ", description='" + getDescription() + '\'' +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        '}';
  }
}
