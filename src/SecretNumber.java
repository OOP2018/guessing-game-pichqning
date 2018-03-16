import java.util.Random;

public class SecretNumber extends java.util.Observable {
private int secret;

public Random ran = new Random(999+0);
public SecretNumber() {
        this.secret = 0;
        }

public void random() {
        secret = ran.nextInt();
        setChanged();
        notifyObservers();
        }

public int getSecretNumber() {
        return secret ;
        }

}
