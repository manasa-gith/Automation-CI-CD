package testdata.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsontoHashmap() throws IOException
	{
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+ "src/test/java/testdata/data/purchaseOrder.json"),"UTF-8");
	
		//String to Hashmap-jackson binder
		ObjectMapper mapper = new ObjectMapper();
		// Define TypeReference for List<HashMap<String, Object>>
		TypeReference<List<HashMap<String, String>>> typeReference = new TypeReference<List<HashMap<String, String>>>() {};
		// Deserialize JSON into List<HashMap<String, Object>>
		List<HashMap<String, String>> list = mapper.readValue(jsonContent, typeReference);
		return list;
		
	}
	
	
}
