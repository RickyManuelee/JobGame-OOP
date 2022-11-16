import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	Vector<Worker> workerVector = new Vector<>();
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	int money = 300, miner = 0, fisher = 0, ore = 0, fish = 0;

	public void View() {
		if (workerVector.isEmpty()) {
			System.out.println("There is no worker!");
			System.out.println("Press enter to continue");
			scan.nextLine();
		} else {
			System.out.println("List of Worker : ");
			System.out.println("==================================================");
			System.out.println("|| Worker Id || Worker name       || Worker Job ||");
			System.out.println("==================================================");
			for (int i = 0; i < workerVector.size(); i++) {
				Worker worker = workerVector.get(i);
				System.out.printf("|| %-9s || %-17s || %-10s ||\n", 
						worker.getID(), worker.getName(), worker.getJob());
			}
			System.out.println("==================================================");
			System.out.println("Press enter to continue");
			scan.nextLine();
		}
	}
	
	public void Hire() {
		
		String id, name, job;
		
		do {
			System.out.print("Input worker name [ 3..15 ] >> ");
			name = scan.nextLine();
		} while (name.length() < 3 || name.length() > 15);
		
		do {
			System.out.print("Input worker job [ Miner | Fisher ] (case sensitive) >> ");
			job = scan.nextLine();
		} while (!job.equals("Miner") && !job.equals("Fisher"));
		
		id = "EP" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		
		if (job.equals("Miner")) {
			workerVector.add(new Miner(id, name, job));
		} else {
			workerVector.add(new Fisher(id, name, job));
		}
		
		System.out.println("Successfully hired worker!");
		System.out.println("Press enter to continue");
		scan.nextLine();
	}
	
	public void Fire() {
		String input;
		
		if (workerVector.isEmpty()) {
			System.out.println("There is no worker!");
			System.out.println("Press enter to continue");
			scan.nextLine();
		} else {
			System.out.println("List of Worker : ");
			System.out.println("==================================================");
			System.out.println("|| Worker Id || Worker name       || Worker Job ||");
			System.out.println("==================================================");
			for (int i = 0; i < workerVector.size(); i++) {
				Worker worker = workerVector.get(i);
				System.out.printf("|| %-9s || %-17s || %-10s ||\n", 
						worker.getID(), worker.getName(), worker.getJob());
			}
			System.out.println("==================================================");
			
			System.out.print("Input Worker id [ type '0' to back to Main Menu] >> ");
			input = scan.nextLine();
			
			int found = -1;
			
			for (int i = 0; i < workerVector.size(); i++) {
				Worker worker = workerVector.get(i);
				if (worker.getID().equals(input)) {
					found = i;
				} else if (input.equals("0")) {
					return;
				}
			}
			
			if (found != -1) {
				workerVector.remove(found);
				
				System.out.println("Successfully fired worker");
				System.out.println("Press enter to continue");
				scan.nextLine();
			} else {
				System.out.println("Worker Id not found!");
				System.out.println("Press enter to continue");
				scan.nextLine();
			}
		}
	}
	
	public void Order() {
		int chooseOrder;
		
		if (workerVector.isEmpty()) {
			System.out.println("There is no worker!");
			System.out.println("Press enter to continue");
			scan.nextLine();
		} else {
			System.out.println("Status : ");
			System.out.println("=======================");
			System.out.printf("Your Money : $%d\n", money);
			System.out.printf("Miner : $%d\n", miner);
			System.out.printf("Fisher : $%d\n", fisher);
			System.out.printf("Ore : $%d\n", ore);
			System.out.printf("Fish : $%d\n", fish);
			System.out.println("=======================");
			System.out.println("1. Order Miner ( cost : $75 )");
			System.out.println("2. Order Fisher ( cost : $50 )");
			System.out.println("3. Exit");
			System.out.print("Choose [1 - 3] >> ");
			chooseOrder = scan.nextInt();
			scan.nextLine();
			
			if (chooseOrder == 1) {
				if (workerVector.isEmpty()) {
					System.out.println("You dont have any Miner.");
					System.out.println("Press enter to continue");
					scan.nextLine();
				} else {
					System.out.println("Every Miner got 2 ore(s)");
					System.out.println("Press enter to continue");
					scan.nextLine();
				}
			} else if (chooseOrder == 2) {
				if (workerVector.isEmpty()) {
					System.out.println("You dont have any Fisher.");
					System.out.println("Press enter to continue");
					scan.nextLine();
				} else {
					System.out.println("Every Fisher got 2 fish(es)");
					System.out.println("Press enter to continue");
					scan.nextLine();
				}
			}
		}
	}
	
	public void Sell() {
		
		int chooseSell;
		
		System.out.println("Status : ");
		System.out.println("=======================");
		System.out.printf("Your Money : $%d\n", money);
		System.out.printf("Ore : $%d\n", ore);
		System.out.printf("Fish : $%d\n", fish);
		System.out.println("=======================");
		System.out.println("1. Sell All Ore ($50 for each ore)");
		System.out.println("2. Sell All Fish ($25 for each fish)");
		System.out.println("3. Back to the Main Menu");
		System.out.print("Choose [1 - 3] >> ");
		chooseSell = scan.nextInt();
		scan.nextLine();
		
		if (chooseSell == 1) {
			if (ore == 0) {
				System.out.println("You dont have any ore");
				System.out.println("Press enter to continue");
				scan.nextLine();
			} else {
				System.out.println("Successfully sold ore");
				System.out.println("Press enter to continue");
				scan.nextLine();
			}
		} else if (chooseSell == 2) { 
			if (fish == 0) {
				System.out.println("You dont have any fish");
				System.out.println("Press enter to continue");
				scan.nextLine();
			} else {
				System.out.println("Successfully sold fish ");
				System.out.println("Press enter to continue");
				scan.nextLine();
			}
		}
	}
	
	public Main() {
		int choose;
		
		do {
			System.out.println("Welcome to JobGame");
			System.out.println("1. View worker");
			System.out.println("2. Order worker");
			System.out.println("3. Hire worker");
			System.out.println("4. Fire worker");
			System.out.println("5. Sell Item");
			System.out.println("6. Exit");
			System.out.print("Choose [1 - 6] >> ");
			choose = scan.nextInt();
			scan.nextLine();
			
			switch (choose) {
			case 1:
				View();
				break;
			case 2:
				Order();
				break;
			case 3:
				Hire();
				break;
			case 4:
				Fire();
				break;
			case 5:
				Sell();
				break;
			default:
				break;
			}
			
		} while (choose != 6);
	}

	public static void main(String[] args) {
		new Main();
	}

}
