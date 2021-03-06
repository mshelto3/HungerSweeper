import java.util.Random;
import java.util.Scanner;

/* 
 * Mark Caldropoli & Marc Shelton
 */

public class Player {
	private int x;
	private int y;
	private String name;
	private int health = 100;
	private int boundary = 4;
	private boolean isPlayer = true;
	
	public Player(String name) {
		this.name = name;
		Random random = new Random();
		this.x = random.nextInt(4);
		this.y = random.nextInt(4);
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getBoundary() {
		return boundary;
	}

	public void setBoundary(int boundary) {
		this.boundary = boundary;
	}

	public void print(){
		System.out.println("---------------------------");
		System.out.println(name + " you've started at the same place as another player!");
	}
	
	public void move() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------------");
		System.out.println(name + ", please input a direction: ");
		System.out.println("(up,down,right,left)");
		
		while(true) {
			String mov = sc.nextLine();
			if(mov.equalsIgnoreCase("up")) {
				if(this.getX() >= 0 && this.getX() < boundary && this.getY()-1 >= 0 && this.getY()-1 < boundary) {
					y--;
					break;
				} else {
					System.out.println("Invalid move, please pick a different direction.");
				}
			} else if(mov.equalsIgnoreCase("down")) {
				if(this.getX() >= 0 && this.getX() < boundary && this.getY()+1 >= 0 && this.getY()+1 < boundary) {
					y++;
					break;
				} else {
					System.out.println("Invalid move, please pick a different direction.");
				}
			} else if(mov.equalsIgnoreCase("right")) {
				if(this.getX()+1 >= 0 && this.getX()+1 < boundary && this.getY() >= 0 && this.getY() < boundary) {
					x++;
					break;
				} else {
					System.out.println("Invalid move, please pick a different direction.");
				}
			} else if(mov.equalsIgnoreCase("left")) {
				if(this.getX()-1 >= 0 && this.getX()-1 < boundary && this.getY() >= 0 && this.getY() < boundary) {
					x--;
					break;
				} else {
					System.out.println("Invalid move, please pick a different direction.");
				}
			} else {
				System.out.println("Please enter a valid direction. (up,down,right,left)");
			}
		}
	}
	
	public boolean fight(Player a) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println(name + ", do you want to fight or run?");
		System.out.println("(fight,run)");
		
		while(true) {
			String decision = sc.nextLine();
			if(decision.equalsIgnoreCase("fight")) return true;
			else if(decision.equalsIgnoreCase("run")) return false;
			else System.out.println("Quick! Pick one of the two decisions! (fight,run)");
		}
	}
	
	public boolean caughtTrap(Traps a){
		return a.caughtTrap(this, isPlayer);
	}

	public boolean isPlayer() {
		return isPlayer;
	}

	public void setPlayer(boolean isPlayer) {
		this.isPlayer = isPlayer;
	}
}
