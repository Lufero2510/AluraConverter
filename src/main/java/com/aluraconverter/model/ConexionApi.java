package com.aluraconverter.model;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * @version 1.0
 *
 * @author Luis Fernando Garcia
 */

public class ConexionApi {
    private URL url;
    private HttpURLConnection connection;
    private int responseCode;


    public ConexionApi(){

    }
    public ConexionApi(String url) throws IOException {
        this.url = new URL(url);
    }

    public void conexion() throws IOException {
        //solicitar una peticion
            this.connection = (HttpURLConnection) url.openConnection();
            this.connection.setRequestMethod("GET");
            this.connection.connect();
            this.responseCode = this.connection.getResponseCode();
           // System.out.println(this.responseCode);


    }

    public JSONObject getJson() throws IOException {
            StringBuilder informationString = new StringBuilder();
            Scanner scanner = new Scanner(this.url.openStream());
            while (scanner.hasNext()){
                informationString.append(scanner.nextLine());
            }
            scanner.close();
            JSONObject jsonObject = new JSONObject(informationString.toString());
            return  jsonObject;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public HttpURLConnection getConnection() {
        return connection;
    }

    public void setConnection(HttpURLConnection connection) {
        this.connection = connection;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

}
