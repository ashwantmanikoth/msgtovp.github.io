package com.pizza.online.model.stocks;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "pos_items")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@TableGenerator(name = "items_tab_gen", allocationSize = 1, initialValue = 100, catalog = "posdb", table = "pos_table_gen", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "pid")
public class Item implements Serializable {

	private static final long serialVersionUID = 8418046265037642536L;

	private Integer id;
	private String name;
	private String toppings;
	private Integer quantity;
	private Category category;
	private Double price;
	private Collection<Images> images = new HashSet<Images>();

	@Id
	@Column(name = "pid")
	@GeneratedValue(generator = "items_tab_gen", strategy = GenerationType.TABLE)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "toppings")
	public String getToppings() {
		return toppings;
	}

	public void setToppings(String toppings) {
		this.toppings = toppings;
	}

	@Column(name = "quantity")
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "category", length = 10)
	@Enumerated(EnumType.STRING)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "price", length = 10, precision = 2)
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pos_items_images", joinColumns = @JoinColumn(name = "pid"), inverseJoinColumns = @JoinColumn(name = "image_id"))
	public Collection<Images> getImages() {
		return images;
	}

	public void setImages(Collection<Images> images) {
		this.images = images;
	}

	public Item() {
		super();
		this.quantity = 0;
		this.price = 0.0;
		this.category = Category.NON_VEG;
	}

}
