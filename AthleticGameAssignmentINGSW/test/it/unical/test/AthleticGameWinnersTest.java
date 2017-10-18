package it.unical.test;

import java.time.Instant;
import java.time.temporal.TemporalAccessor;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.asde.AthleticGame;

public class AthleticGameWinnersTest {

	private static AthleticGame athleticGame;
	private static String sport;
	
	@BeforeClass
	public static void init(){
		sport = "Scii";
		athleticGame = new AthleticGame(sport);
	}
	
	@After
	public void dopoOgniTest(){
		athleticGame.reset();
	}
	
	@Before
	public void primaDiOgniTest(){
		athleticGame.start();
	}
	
	@Test
	public void getWinnerWorks(){
		athleticGame.addArrival("A", Instant.now().plusMillis(1000));
		athleticGame.addArrival("B", Instant.now().plusMillis(2000));
		athleticGame.addArrival("C", Instant.now());
		
		Assert.assertEquals("C", athleticGame.getWinner());
	}
	
	@Test
	public void getWinnerNullWorks(){
		Assert.assertEquals(null, athleticGame.getWinner());
	}
}
