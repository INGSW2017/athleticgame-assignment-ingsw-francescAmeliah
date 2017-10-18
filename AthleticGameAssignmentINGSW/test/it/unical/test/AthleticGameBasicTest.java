package it.unical.test;

import java.time.Instant;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.asde.AthleticGame;


public class AthleticGameBasicTest {

	private static AthleticGame athleticGame;
	private static String sport;
	
	@BeforeClass
	public static void init(){
		sport = "Maratona";
		athleticGame = new AthleticGame(sport);
	}
	
	@Test
	public void addArrivalWorks(){
		
		athleticGame.addArrival("Participant1", Instant.now());
		Assert.assertEquals(1, athleticGame.getArrivals().size());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getParecipiantTimeWorks(){
		
		athleticGame.addArrival("Partecipante2", Instant.now());
		athleticGame.getParecipiantTime("Partecipante3");
	}
}
