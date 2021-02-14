package kr.or.connect.reservation.dto;

public class Category {
	private Long id;
	private Item item;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Item getItems() {
		return item;
	}
	public void setItems(Item item) {
		this.item = item;
	}
}