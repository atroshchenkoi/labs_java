import by.gsu.pm.WeatherMap;
import com.google.gson.*;
import org.apache.commons.io.IOUtils;
import org.thymeleaf.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.*;

import java.io.FileReader;
import java.io.IOException;


import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Runner {
    ServerSocket serverSocket;
    Socket socket;
    FileReader fr;
    OutputStreamWriter osw;
    Runner() throws IOException
    {
        serverSocket = new ServerSocket(8080);
        socket = serverSocket.accept();
        osw = new OutputStreamWriter(socket.getOutputStream());
        String str = takeJson("https://openweathermap.org/data/2.5/weather?id=5128638&appid=439d4b804bc8187953eb36d2a8c26a02");
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        WeatherMap weatherMap = gson.fromJson(str, WeatherMap.class);
        System.out.println(weatherMap);
        osw.write("HTTP/1.1 10000 OK\nContent-Type: text/html; charset=UTF-8\n\n");
        osw.write(String.valueOf(createHtml(weatherMap)));
        try {
            osw.close();
            Thread.sleep(10000);
            socket.close();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        try {
            new Runner();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String takeJson(String url) {
        try {
            String str = IOUtils.toString(new URL(url), StandardCharsets.UTF_8);
            return str;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static StringWriter createHtml(WeatherMap weatherMap) {
        TemplateEngine templateEngine = new TemplateEngine();
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode("HTML");
        templateEngine.setTemplateResolver(templateResolver);
        Context context = new Context();
        context.setVariable("countryName", weatherMap.getName());
        context.setVariable("countryCode", weatherMap.getCod());
        context.setVariable("mainWeather", weatherMap.getWeather()[0].getMain());
        context.setVariable("descriptionWeather", weatherMap.getWeather()[0].getDescription());
        context.setVariable("currentlyTemperature", weatherMap.getMain().getTemp());
        context.setVariable("maxTemperature", weatherMap.getMain().getTemp_max());
        context.setVariable("minTemperature", weatherMap.getMain().getTemp_min());
        context.setVariable("pressure", weatherMap.getMain().getPressure());
        context.setVariable("humidity", weatherMap.getMain().getHumidity());
        context.setVariable("windSpeed", weatherMap.getWind().getSpeed());
        StringWriter stringWriter = new StringWriter();
        templateEngine.process("Weather.html", context, stringWriter);
        return stringWriter;

    }
}
