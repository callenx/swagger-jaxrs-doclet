package fixtures.crossclassresourcelisting;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@SuppressWarnings("javadoc")
@Path("/v1")
public class Res1 {

	/**
	 * @resourcePath a
	 * @priority 2
	 * @resourceDescription A
	 */
	@GET
	@Path("/x")
	public void getX() {
		// noop
	}

	/**
	 * @resource b
	 * @resourcePriority 1
	 */
	@GET
	@Path("/y")
	public void getY() {
		// noop
	}

}
