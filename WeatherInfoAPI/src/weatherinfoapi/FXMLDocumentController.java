/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherinfoapi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 
import javafx.scene.control.ChoiceBox;
import org.json.JSONObject;

/**
 *
 * @author main
 */
public class FXMLDocumentController implements Initializable {
    String[] contry={ "Afghanistan", "Ã…land Islands", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia, Plurinational State of", "Bonaire, Sint Eustatius and Saba", "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "CÃ´te d'Ivoire", "Croatia", "Cuba", "CuraÃ§ao", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guernsey", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard Island and McDonald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran, Islamic Republic of", "Iraq", "Ireland", "Isle of Man", "Israel", "Italy", "Jamaica", "Japan", "Jersey", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macao", "Macedonia, the Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montenegro", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Palestine, State of", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "RÃ©union", "Romania", "Russian Federation", "Rwanda", "Saint BarthÃ©lemy", "Saint Helena, Ascension and Tristan da Cunha", "Saint Kitts and Nevis", "Saint Lucia", "Saint Martin (French part)", "Saint Pierre and Miquelon", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Sint Maarten (Dutch part)", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Svalbard and Jan Mayen", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Timor-Leste", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela, Bolivarian Republic of", "Viet Nam", "Virgin Islands, British", "Virgin Islands, U.S.", "Wallis and Futuna", "Western Sahara", "Yemen", "Zambia", "Zimbabwe", } ;
    String[] contryCode={"AF", "AX", "AL", "DZ", "AS", "AD", "AO", "AI", "AQ", "AG", "AR", "AM", "AW", "AU", "AT", "AZ", "BS", "BH", "BD", "BB", "BY", "BE", "BZ", "BJ", "BM", "BT", "BO", "BQ", "BA", "BW", "BV", "BR", "IO", "BN", "BG", "BF", "BI", "KH", "CM", "CA", "CV", "KY", "CF", "TD", "CL", "CN", "CX", "CC", "CO", "KM", "CG", "CD", "CK", "CR", "CI", "HR", "CU", "CW", "CY", "CZ", "DK", "DJ", "DM", "DO", "EC", "EG", "SV", "GQ", "ER", "EE", "ET", "FK", "FO", "FJ", "FI", "FR", "GF", "PF", "TF", "GA", "GM", "GE", "DE", "GH", "GI", "GR", "GL", "GD", "GP", "GU", "GT", "GG", "GN", "GW", "GY", "HT", "HM", "VA", "HN", "HK", "HU", "IS", "IN", "ID", "IR", "IQ", "IE", "IM", "IL", "IT", "JM", "JP", "JE", "JO", "KZ", "KE", "KI", "KP", "KR", "KW", "KG", "LA", "LV", "LB", "LS", "LR", "LY", "LI", "LT", "LU", "MO", "MK", "MG", "MW", "MY", "MV", "ML", "MT", "MH", "MQ", "MR", "MU", "YT", "MX", "FM", "MD", "MC", "MN", "ME", "MS", "MA", "MZ", "MM", "NA", "NR", "NP", "NL", "NC", "NZ", "NI", "NE", "NG", "NU", "NF", "MP", "NO", "OM", "PK", "PW", "PS", "PA", "PG", "PY", "PE", "PH", "PN", "PL", "PT", "PR", "QA", "RE", "RO", "RU", "RW", "BL", "SH", "KN", "LC", "MF", "PM", "VC", "WS", "SM", "ST", "SA", "SN", "RS", "SC", "SL", "SG", "SX", "SK", "SI", "SB", "SO", "ZA", "GS", "SS", "ES", "LK", "SD", "SR", "SJ", "SZ", "SE", "CH", "SY", "TW", "TJ", "TZ", "TH", "TL", "TG", "TK", "TO", "TT", "TN", "TR", "TM", "TC", "TV", "UG", "UA", "AE", "GB", "US", "UM", "UY", "UZ", "VU", "VE", "VN", "VG", "VI", "WF", "EH", "YE", "ZM", "ZW"};
    String selectContryCode;
    int indexNum;
    
    
    
    @FXML
    private Label cityout;
    
    @FXML
    private TextField city;
    
    @FXML
    private TextField country;
    
    
    @FXML
    private Label tempout;
    
    @FXML
    private Label humidityout;
    
    @FXML
    private Label templayer;
    
     // @FXML 
    //  private ChoiceBox EmpType;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        
       
        
        try{
        
       String entered_city = city.getText().toString();
       //String contryCode = country.getText().toString();
        
       String selectCuntry = country.getText().toString();
        for(int i=0;i<contry.length;i++){
        if(selectCuntry.equals(contry[i])){
        indexNum=i;
        
      
        }
        }
            //System.out.println("********************************"); 
           // System.out.println(selectCuntry);
           // System.out.println(contry[indexNum]);
         selectContryCode=contryCode[indexNum];
            //System.out.println(indexNum);
          // System.out.println(contryCode[indexNum]);
           // System.out.println(contry.length);
       // System.out.println(contryCode.length);
        
   String url = "https://api.openweathermap.org/data/2.5/weather?q="+entered_city+","+selectContryCode+"&units=metric&appid=XXXXX";
        
        
        //cityout.setText(url);
    
           
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET'  request to URL " + url);
        System.out.println("Respons Code "  + responseCode);
        BufferedReader in = new BufferedReader ( new InputStreamReader(con.getInputStream()));
        
        String inputLine;
        StringBuffer response = new StringBuffer();
        while((inputLine = in.readLine()) != null)
        {
        response.append(inputLine);
        }
        
      
        JSONObject myresponse = new JSONObject(response.toString());
        
                System.out.println(myresponse);

        JSONObject main = new JSONObject(myresponse.getJSONObject("main").toString());
                System.out.println("We are printing main data " + main);
                
                System.out.println("Temperature: " + main.getInt("temp"));
                System.out.println("Minimum Temperature: " + main.getInt("temp_min"));
                System.out.println("Humidity: " + main.getInt("humidity"));
                System.out.println("Pressure: " + main.getInt("pressure"));

                int temperature = main.getInt("temp");
                
                int humidity = main.getInt("humidity");
             // templayer.setText(String.valueOf(temperature));
                System.out.println("***************");
                System.out.println(String.valueOf(temperature));
            tempout.setText(String.valueOf(temperature));
            humidityout.setText(String.valueOf(humidity));

        }
        
        catch (Exception e)
        {
        System.out.println(e);
        }
        
    
    }
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // String[] asd={"lk","in","CA"};
        
      //  "Afghanistan","AF", "Ã…land Islands","AX", "Albania","AL", "Algeria","DZ", "American Samoa","AS", "Andorra","AD", "Angola","AO", "Anguilla","AI", "Antarctica","AQ", "Antigua and Barbuda","AG", "Argentina","AR", "Armenia","AM", "Aruba","AW", "Australia","AU", "Austria","AT", "Azerbaijan","AZ", "Bahamas","BS", "Bahrain","BH", "Bangladesh","BD", "Barbados","BB", "Belarus","BY", "Belgium","BE", "Belize","BZ", "Benin","BJ", "Bermuda","BM", "Bhutan","BT", "Bolivia, Plurinational State of","BO", "Bonaire, Sint Eustatius and Saba","BQ", "Bosnia and Herzegovina","BA", "Botswana","BW", "Bouvet Island","BV", "Brazil","BR", "British Indian Ocean Territory","IO", "Brunei Darussalam","BN", "Bulgaria","BG", "Burkina Faso","BF", "Burundi","BI", "Cambodia","KH", "Cameroon","CM", "Canada","CA", "Cape Verde","CV", "Cayman Islands","KY", "Central African Republic","CF", "Chad","TD", "Chile","CL", "China","CN", "Christmas Island","CX", "Cocos (Keeling) Islands","CC", "Colombia","CO", "Comoros","KM", "Congo","CG", "Congo, the Democratic Republic of the","CD", "Cook Islands","CK", "Costa Rica","CR", "CÃ´te d'Ivoire","CI", "Croatia","HR", "Cuba","CU", "CuraÃ§ao","CW", "Cyprus","CY", "Czech Republic","CZ", "Denmark","DK", "Djibouti","DJ", "Dominica","DM", "Dominican Republic","DO", "Ecuador","EC", "Egypt","EG", "El Salvador","SV", "Equatorial Guinea","GQ", "Eritrea","ER", "Estonia","EE", "Ethiopia","ET", "Falkland Islands (Malvinas)","FK", "Faroe Islands","FO", "Fiji","FJ", "Finland","FI", "France","FR", "French Guiana","GF", "French Polynesia","PF", "French Southern Territories","TF", "Gabon","GA", "Gambia","GM", "Georgia","GE", "Germany","DE", "Ghana","GH", "Gibraltar","GI", "Greece","GR", "Greenland","GL", "Grenada","GD", "Guadeloupe","GP", "Guam","GU", "Guatemala","GT", "Guernsey","GG", "Guinea","GN", "Guinea-Bissau","GW", "Guyana","GY", "Haiti","HT", "Heard Island and McDonald Islands","HM", "Holy See (Vatican City State)","VA", "Honduras","HN", "Hong Kong","HK", "Hungary","HU", "Iceland","IS", "India","IN", "Indonesia","ID", "Iran, Islamic Republic of","IR", "Iraq","IQ", "Ireland","IE", "Isle of Man","IM", "Israel","IL", "Italy","IT", "Jamaica","JM", "Japan","JP", "Jersey","JE", "Jordan","JO", "Kazakhstan","KZ", "Kenya","KE", "Kiribati","KI", "Korea, Democratic People's Republic of","KP", "Korea, Republic of","KR", "Kuwait","KW", "Kyrgyzstan","KG", "Lao People's Democratic Republic","LA", "Latvia","LV", "Lebanon","LB", "Lesotho","LS", "Liberia","LR", "Libya","LY", "Liechtenstein","LI", "Lithuania","LT", "Luxembourg","LU", "Macao","MO", "Macedonia, the Former Yugoslav Republic of","MK", "Madagascar","MG", "Malawi","MW", "Malaysia","MY", "Maldives","MV", "Mali","ML", "Malta","MT", "Marshall Islands","MH", "Martinique","MQ", "Mauritania","MR", "Mauritius","MU", "Mayotte","YT", "Mexico","MX", "Micronesia, Federated States of","FM", "Moldova, Republic of","MD", "Monaco","MC", "Mongolia","MN", "Montenegro","ME", "Montserrat","MS", "Morocco","MA", "Mozambique","MZ", "Myanmar","MM", "Namibia","NA", "Nauru","NR", "Nepal","NP", "Netherlands","NL", "New Caledonia","NC", "New Zealand","NZ", "Nicaragua","NI", "Niger","NE", "Nigeria","NG", "Niue","NU", "Norfolk Island","NF", "Northern Mariana Islands","MP", "Norway","NO", "Oman","OM", "Pakistan","PK", "Palau","PW", "Palestine, State of","PS", "Panama","PA", "Papua New Guinea","PG", "Paraguay","PY", "Peru","PE", "Philippines","PH", "Pitcairn","PN", "Poland","PL", "Portugal","PT", "Puerto Rico","PR", "Qatar","QA", "RÃ©union","RE", "Romania","RO", "Russian Federation","RU", "Rwanda","RW", "Saint BarthÃ©lemy","BL", "Saint Helena, Ascension and Tristan da Cunha","SH", "Saint Kitts and Nevis","KN", "Saint Lucia","LC", "Saint Martin (French part)","MF", "Saint Pierre and Miquelon","PM", "Saint Vincent and the Grenadines","VC", "Samoa","WS", "San Marino","SM", "Sao Tome and Principe","ST", "Saudi Arabia","SA", "Senegal","SN", "Serbia","RS", "Seychelles","SC", "Sierra Leone","SL", "Singapore","SG", "Sint Maarten (Dutch part)","SX", "Slovakia","SK", "Slovenia","SI", "Solomon Islands","SB", "Somalia","SO", "South Africa","ZA", "South Georgia and the South Sandwich Islands","GS", "South Sudan","SS", "Spain","ES", "Sri Lanka","LK", "Sudan","SD", "Suriname","SR", "Svalbard and Jan Mayen","SJ", "Swaziland","SZ", "Sweden","SE", "Switzerland","CH", "Syrian Arab Republic","SY", "Taiwan, Province of China","TW", "Tajikistan","TJ", "Tanzania, United Republic of","TZ", "Thailand","TH", "Timor-Leste","TL", "Togo","TG", "Tokelau","TK", "Tonga","TO", "Trinidad and Tobago","TT", "Tunisia","TN", "Turkey","TR", "Turkmenistan","TM", "Turks and Caicos Islands","TC", "Tuvalu","TV", "Uganda","UG", "Ukraine","UA", "United Arab Emirates","AE", "United Kingdom","GB", "United States","US", "United States Minor Outlying Islands","UM", "Uruguay","UY", "Uzbekistan","UZ", "Vanuatu","VU", "Venezuela, Bolivarian Republic of","VE", "Viet Nam","VN", "Virgin Islands, British","VG", "Virgin Islands, U.S.","VI", "Wallis and Futuna","WF", "Western Sahara","EH", "Yemen","YE", "Zambia","ZM", "Zimbabwe","ZW", 
        
      TextFields.bindAutoCompletion(country, contry);
        // TODO
       // EmpType.getItems().addAll("Permanent", "Contract", "Part Time", "Contract", "Part Time", "Contract", "Part Time", "Contract", "Part Time", "Contract", "Part Time", "Contract", "Part Time", "Contract", "Part Time", "Contract", "Part Time", "Contract", "Part Time", "Contract", "Part Time", "Contract", "Part Time", "Contract", "Part Time", "Contract", "Part Time", "Contract", "Part Time", "Contract", "Part Time", "Contract", "Part Time", "Contract", "Part Time" );
        
    }    
    
}
