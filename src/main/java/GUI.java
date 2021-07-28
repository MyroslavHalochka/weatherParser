import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

public class GUI extends JFrame {

    private String temperatureValueNow = "";
    private String feelsLikeValueNow = "";
    private String feelsLikeWordNow = "";
    private String sunriseToday = "";
    private String sunsetToday = "";
    private String dayLengthToday = "";
    private String moonPhaseToday = "";

    Connection conn = Jsoup.connect("https://www.meteoprog.ua/ru/weather/Kyiv/");
    Document doc = conn.get();

    Element elementTemperatureValueNow = doc.select("span.temperature_value").first();
    Element elementFeelsLikeValueNow = doc.select("span.tempStyle").first();
    Element elementFeelsLikeWordNow = doc.select("div.bgWheather4").first();
    Element elementSunriseToday = doc.select("span.colorNoBold").first();
    Element elementSunsetToday = doc.select("div.infoPrognosis:nth-child(3) > span.colorNoBold").first();
    Element elementDayLengthToday = doc.select("div.infoPrognosis:nth-child(4) > span.colorNoBold").first();
    Element elementMoonPhaseToday = doc.select("div.faza:nth-child(5) > div.infoPrognosis:nth-child(2) > span.colorNoBold").first();

    private final JLabel label = new JLabel("Погода в Киеве на сегодня:");
    private final JLabel label2 = new JLabel(getTemperatureValueNow());
    private final JLabel label3 = new JLabel("По ощущениям:");
    private final JLabel label4 = new JLabel(getFeelsLikeValueNow() + "\n" + getFeelsLikeWordNow());
    private final JLabel label5 = new JLabel("Восход:");
    private final JLabel label6 = new JLabel(getSunriseToday());
    private final JLabel label7 = new JLabel("Закат:");
    private final JLabel label8 = new JLabel(getSunsetToday());
    private final JLabel label9 = new JLabel("Продолж. дня:");
    private final JLabel label10 = new JLabel(getDayLengthToday());
    private final JLabel label11 = new JLabel("Фаза луны:");
    private final JLabel label12 = new JLabel(getMoonPhaseToday());
    private final JLabel close = new JLabel();

    ImageIcon newImage = new ImageIcon("src/ui/background.jpg");
    ImageIcon closeImageIcon = new ImageIcon("src/ui/close.png");
    Image scaleImage = newImage.getImage().getScaledInstance(750, 450, Image.SCALE_DEFAULT);
    Image closeImage = closeImageIcon.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT);

    public GUI() throws IOException {

        super("Weather Parser");

        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label2.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label3.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label4.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label5.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label6.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label7.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label8.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label9.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label10.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label11.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label12.setFont(new Font("Segoe UI", Font.BOLD, 12));

        label.setForeground(Color.WHITE);
        label2.setForeground(Color.WHITE);
        label3.setForeground(Color.WHITE);
        label4.setForeground(Color.WHITE);
        label5.setForeground(Color.WHITE);
        label6.setForeground(Color.WHITE);
        label7.setForeground(Color.WHITE);
        label8.setForeground(Color.WHITE);
        label9.setForeground(Color.WHITE);
        label10.setForeground(Color.WHITE);
        label11.setForeground(Color.WHITE);
        label12.setForeground(Color.WHITE);

        closeImageIcon.setImage(closeImage);
        close.setIcon(closeImageIcon);

        this.setContentPane(new JLabel(new ImageIcon(scaleImage)));
        this.setBounds(100, 100, 750, 450); //размеры окна
        this.setResizable(false); //отключение изменения размера окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //снятие процесса после нажатия крестика
//        this.setUndecorated(true); //отключает рамку

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(label2);
        container.add(label3);
        container.add(label4);
        container.add(label5);
        container.add(label6);
        container.add(label7);
        container.add(label8);
        container.add(label9);
        container.add(label10);
        container.add(label11);
        container.add(label12);
//        container.add(close);

    }

    public String getTemperatureValueNow() {

        return elementTemperatureValueNow.text();

    }

    public String getFeelsLikeValueNow() {

        return elementFeelsLikeValueNow.text();

    }

    public String getFeelsLikeWordNow() {

        return elementFeelsLikeWordNow.text();

    }

    public String getSunriseToday() {

        return elementSunriseToday.text();

    }

    public String getSunsetToday() {

        return elementSunsetToday.text();

    }

    public String getDayLengthToday() {

        return elementDayLengthToday.text();

    }

    public String getMoonPhaseToday() {

        return elementMoonPhaseToday.text();

    }

    public void setTemperatureValueNow(String temperatureValueNow) {

        this.temperatureValueNow = temperatureValueNow;

    }

    public void setFeelsLikeValueNow(String feelsLikeValueNow) {

        this.feelsLikeValueNow = feelsLikeValueNow;

    }

    public void setFeelsLikeWordNow(String feelsLikeWordNow) {

        this.feelsLikeWordNow = feelsLikeWordNow;

    }

    public void setSunriseToday(String sunriseToday) {

        this.sunriseToday = sunriseToday;

    }

    public void setSunsetToday(String sunsetToday) {

        this.sunsetToday = sunsetToday;

    }

    public void setDayLengthToday(String dayLengthToday) {

        this.dayLengthToday = dayLengthToday;

    }

    public void setMoonPhaseToday(String moonPhaseToday) {

        this.moonPhaseToday = moonPhaseToday;

    }

}
