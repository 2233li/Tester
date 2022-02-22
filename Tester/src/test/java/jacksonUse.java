import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ligungun.TestSystem.entity.meituanticket.CreateOrder;

public class jacksonUse {
	public static String jsonString="{\"body\":{\"orderId\":8985652356562370000,\"partnerDealId\":\"758219_1724326\"}}";
	public static void  main(String[] args ) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			CreateOrder createOrder=mapper.readValue(jsonString, CreateOrder.class);
			String aString=mapper.writeValueAsString(createOrder);
			System.out.println(aString);
			
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
