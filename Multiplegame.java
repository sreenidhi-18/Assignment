class Wallet {
    private double balance;
    public Wallet(double initialAmount) {
        this.balance = initialAmount;
    }
    public boolean deduct(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
    public double getBalance() {
        return balance;
    }
}

class MembershipCard {
    private String memberName;
    public MembershipCard(String memberName) {
        this.memberName = memberName;
    }
    public String getMemberName() {
        return memberName;
    }
}
// Common Game Interface
interface Game {
    void start();
    void stop();
}
// Abstract Game class (common behavior)
abstract class BaseGame implements Game {
    protected String gameName;
    protected double charge;
    protected Wallet wallet;
    public BaseGame(String gameName, double charge, Wallet wallet) {
        this.gameName = gameName;
        this.charge = charge;
        this.wallet = wallet;
    }
    public void start() {
        if (wallet.deduct(charge)) {
            System.out.println(gameName + " started. Charge: " + charge);
        } else {     System.out.println("Insufficient balance for " + gameName);
        }
    }
    public void stop() {
        System.out.println(gameName + " stopped.");
    }
}
// Different Games
class RacingGame extends BaseGame {
    public RacingGame(Wallet wallet) {
        super("Racing Game", 50, wallet);
    }
}
class ShootingGame extends BaseGame {
    public ShootingGame(Wallet wallet) {
        super("Shooting Game", 70, wallet);
    }
}
class AdventureGame extends BaseGame {
    public AdventureGame(Wallet wallet) {
        super("Adventure Game", 60, wallet);
    }
}
// Main Class
   class GameCenter {
    public static void main(String[] args) {
        MembershipCard card = new MembershipCard("Player1");
        Wallet wallet = new Wallet(200);
        System.out.println("Welcome " + card.getMemberName());
        System.out.println("Initial Balance: " + wallet.getBalance());
// Same reference for different games
        Game game;
        game = new RacingGame(wallet);
        game.start();
        game.stop();
        game = new ShootingGame(wallet);
        game.start();
        game.stop();
        game = new AdventureGame(wallet);
        game.start();
        game.stop();
        System.out.println("Remaining Balance: " + wallet.getBalance());
    }
}
