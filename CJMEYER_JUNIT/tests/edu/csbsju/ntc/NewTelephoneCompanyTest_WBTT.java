package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Test;

public class NewTelephoneCompanyTest_WBTT {

	private NewTelephoneCompany ntc;
	
	@Test
	public void testComputeCharge() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStartTime() {
	    int expResult = 0;
	    int result = ntc.getStartTime();
	    assertEquals("Hours is " + expResult,expResult, result);
	}

	@Test
	public void testSetStartTime() {
        int expResult = 40;
        ntc.setStartTime(expResult);
        int result = ntc.getStartTime();
        assertEquals("Hours is now " + expResult,expResult, result);
	}

	@Test
	public void testGetDuration() {
        int expResult = 0;
        int result = ntc.getDuration();
        assertEquals("Length is" + expResult,expResult, result);
	}

	@Test
	public void testSetDuration() {
        int expResult = 40;
        ntc.setDuration(expResult);
        int result = ntc.getDuration();
        assertEquals("Length is now " + expResult,expResult, result);
	}
	
	
	
	/**
	Description							Input st		Input length	Expected output
	Invalid st								-5				10				invalid st
											-1				10				invalid st
											2544			10				invalid st
											2400			10				invalid st
											2401			10				invalid st
											1578			10				invalid st
											1160			10				invalid st
											1161			10				invalid st
	invalid length							799				-5				invalid length
											
	*/						
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case1() {
		ntc.setStartTime(-5);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case2() {
		ntc.setStartTime(-1);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case3() {
		ntc.setStartTime(2544);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case4() {
		ntc.setStartTime(2400);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case5() {
		ntc.setStartTime(2401);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case6() {
		ntc.setStartTime(1578);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case7() {
		ntc.setStartTime(1160);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case8() {
		ntc.setStartTime(1161);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime_Case9() {
		ntc.setStartTime(799);
		ntc.setDuration(-5);
		ntc.computeCharge();
	}
	/**
	 * Description						input st			input length		expected output
	 * invalid duration					1800					0				invalidLengthException
	 * 									1801					-1				invalidLengthException				
	 */
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidDuration_Case1() {
		ntc.setStartTime(1800);
		ntc.setDuration(0);
		ntc.computeCharge();
	}	

	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidDuration_Case2() {
		ntc.setStartTime(1801);
		ntc.setDuration(-1);
		ntc.computeCharge();
	}
	/**
	 * Description			input st		input length		expected output
	 * both discounts		500				100					1768.0
	 * 						759				61					1078.48
	 * 						1959			61					1078.48
	 * 						2359			65					1149.20
	 */
	@Test
	public void testComputeCharge_BothDiscounts() {
		ntc.setStartTime(500);
		ntc.setDuration(100);
		double expResult = 1768.0 ;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
		ntc.setStartTime(759);
		ntc.setDuration(61);
		expResult = 1078.48 ;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
		ntc.setStartTime(1959);
		ntc.setDuration(61);
		expResult = 1078.48 ;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
		ntc.setStartTime(2359);
		ntc.setDuration(65);
		expResult = 1149.20;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());	
	}
	/**
	 * Description				input st		input length		expected output
	 * start time discount		0				60					1248.00
	 * 							400				59					1227.20
	 * 							759				1					20.80
	 * 							1800			10					208.80
	 * 							1801			10					208.80
	 * 							2359			10					208.80
	 */
	@Test
	public void testComputeCharge_StartTimeDiscount() {
		ntc.setStartTime(0);
		ntc.setDuration(60);
		double expResult = 1248.00;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
		ntc.setStartTime(400);
		ntc.setDuration(59);
		expResult = 1227.20;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
		ntc.setStartTime(759);
		ntc.setDuration(1);
		expResult = 20.80;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
		ntc.setStartTime(1800);
		ntc.setDuration(10);
		expResult = 208.80;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
		ntc.setStartTime(1801);
		ntc.setDuration(10);
		expResult = 208.80;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
		ntc.setStartTime(2359);
		ntc.setDuration(10);
		expResult = 208.80;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());	
	}
	/**
	 * Description				input st		input length		expected output
	 * duration discount		800				65					2298.40
	 * 							900				61					2156.96
	 */
	@Test
	public void testComputeCharge_DurationDiscount() {
		ntc.setStartTime(800);
		ntc.setDuration(65);
		double expResult = 2298.40;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
		ntc.setStartTime(900);
		ntc.setDuration(61);
		expResult = 2156.96;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	}	
	/**
	 * Description				input st		input length		expected output
	 * no discounts				1000			40					1664.00
	 * 							800				1					41.60
	 * 							801				59					2454.40
	 * 							1759			60					2496.00
	 */
	@Test
	public void testComputeCharge_NoDiscounts() {
		ntc.setStartTime(1000);
		ntc.setDuration(40);
		double expResult = 1664.00  ;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
		ntc.setStartTime(800);
		ntc.setDuration(1);
		expResult = 41.60 ;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());	
		ntc.setStartTime(801);
		ntc.setDuration(59);
		expResult = 2454.40 ;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());	
		ntc.setStartTime(1759);
		ntc.setDuration(60);
		expResult = 2496.00 ;
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());			
	}

}


