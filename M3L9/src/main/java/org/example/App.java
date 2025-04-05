package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import lombok.extern.java.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * Hello world!
 *
 */
@Log
public class App 
{
    public static void main( String[] args )
    {
        try{
            InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 1234);
            HttpServer httpServer = HttpServer.create( inetSocketAddress, 0); // backlog очередь запросов

            // http://localhost:1234/

            httpServer.createContext("/", new HttpHandler() { // если кто-то придет в корневой католог, то он будет делать
                @Override
                public void handle(HttpExchange exchange) throws IOException {
                    log.info("Запрос получен");
                    //request
                    //response
                    // Устанавливаем атрибут
                    exchange.setAttribute("Hello","I'm Server");
                    // Получаем значения атрибута
                    String attributeValue = (String)exchange.getAttribute("Hello");
                    // Формируем ответ, используя значение атрибута
                    String responseValue = "I'm Server "+ attributeValue;
                    byte[] response = responseValue.getBytes();
                    // Отправляем заголовки ответа
                    exchange.sendResponseHeaders(200, response.length);


                    log.info("Готовим ответ");
                    OutputStream os = exchange.getResponseBody();
                    os.write(response);


                    os.close();
                    log.info("ответ отправлен");

                }
            });
            httpServer.start();

        }
        catch(Exception e){
            throw new RuntimeException();
        }

    }
}
