import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	Vector<Book> bookVector = new Vector<>();
	Scanner scan = new Scanner(System.in);
	int input;
	int choose;
	Random rand =  new Random();
	
	String Lname;
	String ID;
	String Bname;
	Integer price;
	String desc = null;
	String country = null;
	
	String newLname;
	String newID;
	String newBname;
	Integer newPrice;
	String newDesc = null;
	String newCountry = null;
	
	public void view() {
		if (bookVector.isEmpty()) {
			System.out.println("There is no book.");
			System.out.println("Press enter to continue...");
			scan.nextLine();
		} else {
			System.out.println("List of Book : ");
			System.out.println("=======================================================================================================================================");
			System.out.println("|| Library Name    || Book Id  || Book name                 || Book Price      || Book Description               || Library Countrty ||");
			System.out.println("=======================================================================================================================================");
			for (int i=0; i<bookVector.size(); i++) {
				Book book = bookVector.get(i);
				System.out.printf("|| %-15s || %s || %-25s || Rp. %-11d || %-30s || %-16s ||\n", 
						book.getLname(), book.getID(), book.getBname(), 
						book.getPrice(), book.getDesc(), book.getCountry());
			}
			System.out.println("=======================================================================================================================================");
			System.out.println("Press enter to continue...");
			scan.nextLine();
		}
	}
	
	public void add() {
		
		System.out.print("Input book name >> ");
		Bname = scan.nextLine();
		
		do {
			System.out.print("Input book price [ more than 20000 ] >> ");
			price = scan.nextInt();
			scan.nextLine();
		} while (price < 20001);
		
		do {
			System.out.print("Input book description [ 5..20 ] >> ");
			desc = scan.nextLine();
		} while (desc.length() < 5 || desc.length() > 20);
		
		do {
			System.out.print("Input library name [ EchLib | JustGoLib | XLib ] >> ");
			Lname = scan.nextLine();
		} while (!Lname.equals("EchLib") && !Lname.equals("JustGoLib") &&
				!Lname.equals("XLib"));
		
		if (Lname.equals("EchLib")) {
			country = "Singapore";
		} else if (Lname.equals("JustGoLib")) {
			country = "Indonesia";
		} else if (Lname.equals("XLib")) {
			country = "Malaysia";
		}
		
		ID = "BOOK" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		
		bookVector.add(new Book(Lname, ID, Bname, price, desc, country));
		System.out.println("Successfully added new book!");
		System.out.println("Press enter to continue");
		scan.nextLine();
	}
	
	public void updateName() {
		System.out.print("Input book name >> ");
		newBname= scan.nextLine();
		bookVector.add(new Book(Lname, ID, newBname, price, desc, country));
		System.out.println("Successfully chaged book name!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
	
	public void updatePrice() {
		do {
			System.out.print("Input book price [ more than 20000 ] >> ");
			newPrice = scan.nextInt();
			scan.nextLine();
		} while (newPrice < 20001);
		bookVector.add(new Book(Lname, ID, Bname, newPrice, desc, country));
		System.out.println("Successfully chaged book price!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		
	}
	
	public void updateDesc() {
		do {
			System.out.print("Input book description [ 5..20 ] >> ");
			newDesc = scan.nextLine();
		} while (newDesc.length() < 5 || newDesc.length() > 20);
		bookVector.add(new Book(Lname, ID, Bname, price, newDesc, country));
		System.out.println("Successfully chaged book description!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
	
	public void updateMenu(){
		System.out.println("Update : ");
		System.out.println("1. Update book name");
		System.out.println("2. Update book price");
		System.out.println("3. Update book description");
		System.out.print("Choose [ 1 - 3 ] >> ");
		choose = scan.nextInt();
		scan.nextLine();
		
		switch (choose) {
		case 1:
			updateName();
			break;
		case 2:
			updatePrice();
			break;
		case 3:
			updateDesc();
			break;
		default:
			break;
		}
	}
	
	public void update() {
		String search;
		
		System.out.print("Input Book Id [ e.g. BOOK1234 ] >> ");
		search = scan.nextLine();
		
		int found = -1;
		for (int i=0; i<bookVector.size(); i++) {
			Book book = bookVector.get(i);
			if (book.getID().equals(search)) {
				found = i;
			}
		}
		
		if (found != -1) {
			updateMenu();
			
			bookVector.remove(found);
		} else {
			System.out.println("Book Id not found!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
		}
		
		
	}
	
	public Main() {
		do {
			System.out.println("Welcome to JuGlib");
			System.out.println("1. View Book");
			System.out.println("2. Add Book");
			System.out.println("3. Update Book");
			System.out.println("4. Exit");
			System.out.print("Choose [1 - 4] >> ");
			input = scan.nextInt();
			scan.nextLine();
			
			switch (input) {
			case 1:
				view();
				break;
			case 2:
				add();
				break;
			case 3:
				update();
				break;
			default:
				break;
			}
		} while (input != 4);
	}

	public static void main(String[] args) {
		new Main();
	}

}
