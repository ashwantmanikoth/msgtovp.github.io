package com.pizza.online.model.stocks;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "pos_images")
@TableGenerator(name = "img_tab_gen", allocationSize = 1, initialValue = 100, catalog = "posdb", table = "pos_table_gen", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "image_id")
public class Images implements Serializable {

	private static final long serialVersionUID = 3269026929029709864L;

	private Integer id;
	private String url;

	@Column(name = "image_id")
	@Id
	@GeneratedValue(generator = "img_tab_gen", strategy = GenerationType.TABLE)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
