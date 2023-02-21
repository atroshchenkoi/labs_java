
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@Data
@XmlRootElement(name = "DailyExRates")
@XmlAccessorType(XmlAccessType.FIELD)
public class DailyExRate {
    @XmlAttribute(name = "Date")
    private String date;
    @XmlElementWrapper(name = "Currencies")
    @XmlElement(name="Currency")
    private ArrayList<Currency> currencies;

    @Override
    public String toString() {
        String str = "";
        for (Currency currency : currencies) {
            str += currency.toString();
        }
        return "Курсы на " + date + ":" + str;
    }
}
