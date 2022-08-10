import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		ArrayList<Ingredients> ingredientList = new ArrayList<Ingredients>();


		ingredientList.add(new Ingredients("Noodles",5));
		ingredientList.add(new Ingredients("Rice",5));
		ingredientList.add(new Ingredients("Tomatoes",5));

		int option = 0;

		while (option != 4) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				C206_CaseStudy.viewAllingredients(ingredientList);

			} else if (option == 2) {
				C206_CaseStudy.setHeader("ADD");			
				C206_CaseStudy.setHeader("ORDERS");
				
				Ingredients ingredient = inputIngredients();

				if(ingredient!= null) {
					C206_CaseStudy.addIngredients(ingredientList, ingredient);
					System.out.println("Order added");

				} else {
					System.out.println("Please try again");
				}

			} else if (option == 3) {
				// Loan item
				C206_CaseStudy.setHeader("DELETE");			
				C206_CaseStudy.setHeader("ORDERS");

				
					C206_CaseStudy.deleteIngredients(ingredientList);


			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		C206_CaseStudy.setHeader("CANTEEN APP");
		System.out.println("1. Display Inventory");
		System.out.println("2. Add order");
		System.out.println("3. Delete order");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}



	//================================= Option 1 View Ingredient (CRUD- Read) =================================
	public static String retrieveAllingredients(ArrayList<Ingredients> ingredientList) {
		String output = "";

		for (int i = 0; i < ingredientList.size(); i++) {

			output += String.format("%-10s %-30d \n", ingredientList.get(i).getIngredient(),
					ingredientList.get(i).getAmount() );
		}
		return output;
	}
	public static void viewAllingredients(ArrayList<Ingredients> ingredientList) {
		C206_CaseStudy.setHeader("ORDER LIST");
		String output = String.format("%-10s %-30s \n", "INGREDIENT", "AMOUNT");
		 output += retrieveAllingredients(ingredientList);	
		System.out.println(output);
	}


	//================================= Option 2 Add Ingredient (CRUD - Create) =================================
	public static Ingredients inputIngredients() {
		String ingredient = Helper.readString("Enter ingredient > ");
		int amount = Helper.readInt("Enter amount > ");

		Ingredients ingredients= new Ingredients(ingredient, amount);
		return ingredients;
		
	}
	public static void addIngredients(ArrayList<Ingredients> ingredientList, Ingredients ingredients) {
		
		ingredientList.add(ingredients);
		
	} //
	
	//================================= Option 3 Delete Ingredient (CRUD - Update) =================================
	
	public static boolean doDeleteIngredients(ArrayList<Ingredients> ingredientList, String ingredient, int amount) {
		
		boolean isDeleted = false;

		for (int i = 0; i < ingredientList.size(); i++) {
			if (ingredient.equalsIgnoreCase(ingredientList.get(i).getIngredient())
					&& ingredientList.get(i).getAmount() == amount) {
				
				ingredientList.remove(i);
			}
		}
		return isDeleted;
	}
	
	public static void deleteIngredients(ArrayList<Ingredients> ingredientList) {
		C206_CaseStudy.viewAllingredients(ingredientList);
		String ingredient = Helper.readString("Enter ingredient > ");
	    int amount = Helper.readInt("Enter amount > ");
		Boolean isDeleted = doDeleteIngredients(ingredientList, ingredient, amount);
		if (isDeleted == false) {
			System.out.println("Invalid Ingredient");
		} else {
			System.out.println("Successfully deleted");
		}
	}
	



}
