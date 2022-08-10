import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Ingredients ingredient1;
	private Ingredients ingredient3;
	private Ingredients ingredient2;
	
	private ArrayList<Ingredients> ingredientList;
	
	@Before
	public void setUp() throws Exception {
		ingredient1 = new Ingredients("Bread", 5);
		ingredient2 = new Ingredients("Eggs", 1);
		ingredient3 = new Ingredients("Milk", 5);
		
		ingredientList= new ArrayList<Ingredients>();
	}
	

	@Test
	public void testAddIngredients() {
		assertNotNull(ingredientList);
		
		C206_CaseStudy.addIngredients(ingredientList, ingredient1);		
		assertEquals(1,ingredientList.size());
		
		assertSame(ingredient1, ingredientList.get(0));

		C206_CaseStudy.addIngredients(ingredientList, ingredient2);
		C206_CaseStudy.addIngredients(ingredientList, ingredient3);
		assertEquals(3, ingredientList.size());
		assertSame(ingredient3, ingredientList.get(2));
	}
	
	
	@Test
	public void testRetrieveIngredients() {
	 assertNotNull("Test if there is valid Chromebook arraylist to add to", ingredientList);
				
				
				String allIngredient=  C206_CaseStudy.retrieveAllingredients(ingredientList);
				String testOutput = "";
						
				 C206_CaseStudy.addIngredients(ingredientList, ingredient1);
				 C206_CaseStudy.addIngredients(ingredientList, ingredient2);
				assertEquals("Test if that Camcorder arraylist size is 2?", 2, ingredientList.size());
				

				allIngredient =  C206_CaseStudy.retrieveAllingredients(ingredientList);

				testOutput = String.format("%-10s %-30d \n","Bread", 5);
				testOutput += String.format("%-10s %-30d \n","Eggs", 1);
			
				assertEquals(testOutput, allIngredient);
	} //
	
	@Test
	public void testDeleteIngredients() {
		assertNotNull(ingredientList);
		

		assertEquals(0, ingredientList.size());
		

		C206_CaseStudy.addIngredients(ingredientList, ingredient2);
		C206_CaseStudy.addIngredients(ingredientList, ingredient3);
		assertEquals(2, ingredientList.size());
		
		C206_CaseStudy.doDeleteIngredients(ingredientList,"Eggs", 1);	
		assertEquals(ingredient3, ingredientList.get(0));
		
		
	}

	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
