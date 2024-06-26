import model.CalledModel;

import static java.lang.StringTemplate.STR;

public class StringTemplate {

    public static void main(String[] args) {
        String firstName = "Bill";
        String lastName  = "Duck";
        String fullName  = STR."\{firstName} \{lastName}";

        String sortName  = STR."\{lastName}, \{firstName}";

        System.out.println("StringTemplate fullName : "+fullName);

        System.out.println("StringTemplate lastName : "+sortName);

        int x = 10, y = 20;
        String arithmetic = STR."\{x} + \{y} = \{x + y}";

        System.out.println("StringTemplate arithmetic : "+arithmetic);

        CalledModel req = new CalledModel();

        String s = STR."You have a \{req.getOfferType()} waiting for you!";

        String t = STR."Access at \{req.date} \{req.time} from \{req.ipAddress}";


    }
}
