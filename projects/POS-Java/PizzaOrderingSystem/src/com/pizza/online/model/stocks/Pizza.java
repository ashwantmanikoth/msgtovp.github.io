package com.pizza.online.model.stocks;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pos_pizza", catalog = "posdb")
public class Pizza extends Item {

	private static final long serialVersionUID = 5249543221713172904L;

	private Crust crust;
	private Size size;
	private Menu menu;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "crust")
	public Crust getCrust() {
		return crust;
	}

	public void setCrust(Crust crust) {
		this.crust = crust;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
