import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.validator.PublicClassValidator;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Practice {
	
	public static void main(String[] args) {
	 String	jsonString="{\"service\":{\"service\":\"\",\"oeration\":\"\",\"param\":{\"productId\":123},\"checkresult\":{},\"saveresult\":[\"orderid\",\"param\"]},\"lala\":{\"operationName\":{},\"param\":{\"oderid\":\"CommonParamData.orderid\"},\"checkresult\":{},\"severesult\":{}},\"wula\":{\"service\":\"\",\"oeration\":\"\",\"param\":{\"productId\":123},\"checkresult\":{},\"saveresult\":[\"orderid\",\"param\"]}}";
	 ObjectMapper mapper =new ObjectMapper();
	 try {
		Map<String,String> param =mapper.readValue(jsonString,LinkedHashMap.class);
		 for(String keyString: param.keySet()) {
			 System.out.println(keyString);
		 }
		 
	} catch (JsonParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	
		
	
		
	}
	
	
}
