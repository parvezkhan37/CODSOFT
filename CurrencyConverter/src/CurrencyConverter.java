import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) throws IOException {
        HashMap<Integer,String> currencyCodes = new HashMap<Integer,String>();
        currencyCodes.put(1,"USD");
        currencyCodes.put(2,"CAD");
        currencyCodes.put(3,"EUR");
        currencyCodes.put(4,"HKD");
        currencyCodes.put(5,"INR");

        String fromCode, toCode;
        double amount;

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the currency converter!");
        System.out.println("Currency converting from?");
        System.out.println("1:USD(US Dollar)\t2:CAD(Canadian Dollar)\t3:EUR (Euro)" +
                "4:HKD (Hongkong Dollar)\t5:INR (Indian Rupee)");
        fromCode = currencyCodes.get(sc.nextInt());

        System.out.println("Currency converting to?");
        System.out.println("1:USD(US Dollar)\t2:CAD(Canadian Dollar)\t3:EUR (Euro)" +
                "4:HKD (Hongkong Dollar)\t5:INR (Indian Rupee)");
        toCode = currencyCodes.get(sc.nextInt());

        System.out.println("Amount you wish to convert: ");
        amount = sc.nextFloat();

        sendHttpGETRequest(fromCode, toCode, amount);

        System.out.println("Thank you for using the currency converter!");
    }

    private static void sendHttpGETRequest(String fromCode, String toCode, double amount) throws IOException {
        String GET_URL="https://api.exchangeratesapi.io/latest?base="+fromCode+"&symbols="+fromCode;
        URL url = new URL(GET_URL);
        HttpURLConnection HttpURLConnection = (java.net.HttpURLConnection) url.openConnection();
        HttpURLConnection.setRequestMethod("GET");
        int responseCode = HttpURLConnection.getResponseCode();

        if(responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(HttpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }in.close();

            JSONObject obj = new JSONObject(response.toString());
            Double exchangeRate = obj.getJSONObject("rates").getDouble(fromCode);
            System.out.println(obj.getJSONObject("rates"));
            System.out.println(exchangeRate);
            System.out.println();
            System.out.println(amount+fromCode+ " = "+amount/exchangeRate+toCode);
        }
        else {
            System.out.println("GET request failed!");
        }
    }
}

