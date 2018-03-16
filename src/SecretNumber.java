import java.util.Random;
/**
* For random the secret number.
* @author Pichaaun Popukdee
*/

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
