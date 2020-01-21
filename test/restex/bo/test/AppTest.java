package restex.bo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

	@BeforeEach
	private void init() {
	}

	@Test
	void invalidPathTest() {
		Client client = ClientBuilder.newBuilder().build();
		Response returnState = client.target("http://localhost:8080/restex/123123123")
				.request(MediaType.APPLICATION_JSON).get(Response.class);
		assertEquals(404, returnState.getStatus());
	}

	@Test
	void getRootPath() {
		Client client = ClientBuilder.newBuilder().build();
		Response returnState = client.target("http://localhost:8080/restex/").request(MediaType.APPLICATION_JSON)
				.get(Response.class);
		assertEquals(200, returnState.getStatus());
	}

	@Test
	void getuserWithContent() {
		Client client = ClientBuilder.newBuilder().build();
		Response returnState = client.target("http://localhost:8080/restex/repos/twbs")
				.request(MediaType.APPLICATION_JSON).get(Response.class);

		assertEquals(200, returnState.getStatus());
		assertEquals(true, returnState.hasEntity());
		assertTrue(returnState.getLength() > 0);

	}

	@Test
	void getBadRequestForInvalidUser() {
		Client client = ClientBuilder.newBuilder().build();
		Response returnState = client.target("http://localhost:8080/restex/repos/asdasdasdasdqerqeqweqwe")
				.request(MediaType.APPLICATION_JSON).get(Response.class);

		assertEquals(400, returnState.getStatus());
	}

	@Test
	void getBadRequestForEmptyUser() {
		Client client = ClientBuilder.newBuilder().build();
		Response returnState = client.target("http://localhost:8080/restex/repos/").request(MediaType.APPLICATION_JSON)
				.get(Response.class);

		assertEquals(400, returnState.getStatus());

	}

}
