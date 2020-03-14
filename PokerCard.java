package zqq_pokergame;

public class PokerCard {

	public String number;
	public String color;

	public PokerCard(String number, String color) {
		this.color = color;
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
