import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Parser {

    public static void main(String[] args) throws IOException {

        Connection conn = Jsoup.connect("https://www.meteoprog.ua/ru/weather/Kyiv/");
        Document doc = conn.get();

        Element elementTemperatureValueNow = doc.select("span.temperature_value").first();
        Element elementFeelsLikeValueNow = doc.select("span.tempStyle").first();
        Element elementFeelsLikeWordNow = doc.select("div.bgWheather4").first();
        Element elementSunriseToday = doc.select("span.colorNoBold").first();
        Element elementSunsetToday = doc.select("div.infoPrognosis:nth-child(3) > span.colorNoBold").first();
        Element elementDayLengthToday = doc.select("div.infoPrognosis:nth-child(4) > span.colorNoBold").first();
        Element elementMoonPhaseToday = doc.select("div.faza:nth-child(5) > div.infoPrognosis:nth-child(2) > span.colorNoBold").first();

        String temperatureValueNow = elementTemperatureValueNow.text();
        String feelsLikeValueNow = elementFeelsLikeValueNow.text();
        String feelsLikeWordNow = elementFeelsLikeWordNow.text();
        String sunriseToday = elementSunriseToday.text();
        String sunsetToday = elementSunsetToday.text();
        String dayLengthToday = elementDayLengthToday.text();
        String moonPhaseToday = elementMoonPhaseToday.text();

        System.out.println("Погода в Киеве на сегодня:" + "\n" + temperatureValueNow + "\n" + "По ощущениям:" + "\n" + feelsLikeValueNow + "\n" + feelsLikeWordNow + "\nВосход: " + sunriseToday + "\nЗакат: " + sunsetToday + "\nПродолж. дня: " + dayLengthToday + "\nФаза луны: " + moonPhaseToday);

    }

}
