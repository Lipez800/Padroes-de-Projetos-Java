package me.dio.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_feature")
public class Feature extends BaseItem {

  private String category;

  public Feature() {
    // Construtor padrão vazio
  }

  public Feature(String icon, String description, String category) {
    super(icon, description);
    this.category = category;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  // Adicione métodos específicos da classe Feature, se necessário.

  @Override
  public String toString() {
    return "Feature{" +
        "id=" + getId() +
        ", icon='" + getIcon() + '\'' +
        ", description='" + getDescription() + '\'' +
        ", category='" + category + '\'' +
        '}';
  }
}
