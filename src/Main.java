import java.util.Arrays;
import java.util.List;

/**
 *
 * @author MrVhek, IQbrod, Skullhack
 */
public class Main {
    static public void main(String argv[]) {
        List idx = Arrays.asList("Paul","Léa","Jack");
        List lbl = Arrays.asList("Age","Sexe");
        List age = Arrays.asList(24,37,29);
        List name = Arrays.asList('H','F','H');
        
        Dataframe d = new Dataframe(idx,lbl,age,name);
        d.fullDisplay();
    }
}
