import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ConvertJsonObject {

	public static void main(String[] args) {
		try {
			Gson gson = new Gson();
			Client client = Client.create();

			WebResource webResource = client.resource("http://viacep.com.br/ws/01001000/json/");

			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			Endereco end = gson.fromJson(response.getEntity(String.class), Endereco.class);
			
			System.out.println(end.toString());

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
