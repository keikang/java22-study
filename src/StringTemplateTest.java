import model.CalledModel;

import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.lang.StringTemplate.*;
import static java.util.FormatProcessor.FMT;

public class StringTemplateTest {



    record Rectangle(String name, double width, double height) {
        double area() {
            return width * height;
        }
    }
    static Rectangle[] zone = new Rectangle[] {
            new Rectangle("Alfa", 17.8, 31.4),
            new Rectangle("Bravo", 9.6, 12.4),
            new Rectangle("Charlie", 7.1, 11.23),
    };

    public static void main(String[] args) {
        String firstName = "Bill";
        String lastName  = "Duck";
        String fullName  = STR."\{firstName} \{lastName}";

        String sortName  = STR."\{lastName}, \{firstName}";

        //System.err.println("StringTemplate fullName : "+fullName);

        //System.err.println("StringTemplate lastName : "+sortName);

        int x = 10, y = 20;
        String arithmetic = STR."\{x} + \{y} = \{x + y}";

        //System.err.println("StringTemplate arithmetic : "+arithmetic);

        CalledModel req = new CalledModel();

        String method = STR."You have a \{req.getOfferType()} waiting for you!";

        String field = STR."Access at \{req.date} \{req.time} from \{req.ipAddress}";

        //System.err.println("StringTemplate call method : "+method);

        //System.err.println("StringTemplate call field : "+field);


        String filePath = "tmp.dat";
        File file = new File(filePath);
        String old = "The file " + filePath + " " + (file.exists() ? "does" : "does not") + " exist";
        String msg = STR."The file \{filePath} \{file.exists() ? "does" : "does not"} exist";

        //System.err.println("StringTemplate double qoute old : "+old);

        //System.err.println("StringTemplate double qoute msg : "+msg);

        String time = STR."The time is \{
                // The java.time.format package is very useful
                DateTimeFormatter
                        .ofPattern("HH:mm:ss")
                        .format(LocalTime.now())
                } right now";

        //System.err.println("StringTemplate multi line time : "+time);

        String table = FMT."""
                        Description     Width    Height     Area
                        %-12s\{zone[0].name}  %7.2f\{zone[0].width}  %7.2f\{zone[0].height}     %7.2f\{zone[0].area()}
                        %-12s\{zone[1].name}  %7.2f\{zone[1].width}  %7.2f\{zone[1].height}     %7.2f\{zone[1].area()}
                        %-12s\{zone[2].name}  %7.2f\{zone[2].width}  %7.2f\{zone[2].height}     %7.2f\{zone[2].area()}
                        \{" ".repeat(28)} Total %7.2f\{zone[0].area() + zone[1].area() + zone[2].area()}
                        """;

        //System.err.println("StringTemplate FMT table : "+table);

/*        int x1 = 10, y1 = 20;
        StringTemplate st = RAW."\{x1} plus \{y1} equals \{x1 + y1}";
        String s = st.toString();*/

        //System.err.println("StringTemplate s : "+s);

        var INTER = StringTemplate.Processor.of((StringTemplate st) -> {
            String placeHolder = "•";
            System.err.println("StringTemplate st.fragments : "+st.fragments());
            String stencil = String.join(placeHolder, st.fragments());
            System.err.println("StringTemplate stencil : "+stencil);
            for (Object value : st.values()) {
                String v = String.valueOf(value);
                stencil = stencil.replaceFirst(placeHolder, v);
            }
            return stencil;
        });

        int x2 = 10, y2 = 20;
        String s = INTER."\{x2} plus \{y2} equals \{x2 + y2}";

        System.err.println("StringTemplate s : "+s);
    }
}
