package zqq_pokergame;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerTest {

	@Test
	public void test1() {
		List<PokerCard> Black = new ArrayList<>();
		List<PokerCard> White = new ArrayList<>();
		Collections.addAll(Black, new PokerCard("2", "H"), new PokerCard("3", "D"), new PokerCard("5", "S"),
				new PokerCard("9", "C"), new PokerCard("K", "D"));
		Collections.addAll(White, new PokerCard("2", "C"), new PokerCard("3", "H"), new PokerCard("4", "S"),
				new PokerCard("8", "C"), new PokerCard("A", "H"));
		Assert.assertEquals(PokerRegular.of(Black, White), "White wins");
	}
	
	@Test
	public void test2() {
		List<PokerCard> Black = new ArrayList<>();
		List<PokerCard> White = new ArrayList<>();
		Collections.addAll(Black, new PokerCard("2", "H"), new PokerCard("4", "S"), new PokerCard("4", "C"),
				new PokerCard("2", "D"), new PokerCard("4", "H"));
		Collections.addAll(White, new PokerCard("2", "S"), new PokerCard("8", "S"), new PokerCard("A", "S"),
				new PokerCard("Q", "S"), new PokerCard("3", "S"));
		Assert.assertEquals(PokerRegular.of(White, Black), "Black wins");
	}
	
	
}
