import java.util.Scanner;

public class Miracle extends Traps {
	public Miracle(String description, String choice1, String choice2, String answer1, String answer2, int healthLoss,
			boolean answer) {
		super(description, choice1, choice2, answer1, answer2, healthLoss, answer);
	}

	public void caughtTrap(Player a, PlayerManager b){
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println("Oh no, " + a.getName() + ", " + description + "\nDo you?:\n1. " + choice1 + "\n2. " + choice2 + "\n(Type 1 or 2)");
		int n = reader.nextInt();
		if(n == 1){
			System.out.println(answer1);
			if(answer){
				System.out.println("You gain " + healthLoss + " points of health!");
				a.setHealth(a.getHealth() - healthLoss);
			}
		}
		if(n == 2){
			System.out.println(answer2);
			if(!(answer)){
				System.out.println("You gain " + healthLoss + " points of health!");
				a.setHealth(a.getHealth() - healthLoss);
			}
		}
		if(a.getHealth() <= 0){
			System.out.println("---------------------------");
			System.out.println(a.getName() + " has died!");
			System.out.println("---------------------------");
			b.removePlayer(a.getName());
		}
		else{
			System.out.println(a.getName() + " has " + a.getHealth() + " health left!");
		}
		x = -1;
		y = -1;
	}

	@Override
	public boolean caughtTrap(Player a){
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println("Oh no, " + a.getName() + ", " + description + "\nDo you?:\n1. " + choice1 + "\n2. " + choice2 + "\n(Type 1 or 2)");
		int n = reader.nextInt();
		if(n == 1){
			System.out.println(answer1);
			if(answer){
				if(a.getHealth() + healthLoss >= 100){
					System.out.print("Your health is fully restored!");
					a.setHealth(100);
				}
				else{
					System.out.println("You gain " + healthLoss + " points of health!");
					a.setHealth(a.getHealth() + healthLoss);
				}
			}
		}
		if(n == 2){
			System.out.println(answer2);
			if(!(answer)){
				if(a.getHealth() + healthLoss >= 100){
					System.out.print("Your health is fully restored!");
					a.setHealth(100);
				}
				else{
					System.out.println("You gain " + healthLoss + " points of health!");
					a.setHealth(a.getHealth() + healthLoss);
				}
			}
		}
		System.out.println(a.getName() + " has " + a.getHealth() + " health left!");
		x = -1;
		y = -1;
		return false;
	}

}
