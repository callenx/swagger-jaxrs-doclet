package fixtures.responsemodel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * The ResponseModelResource represents a jaxrs resource for testing custom response models
 * @version $Id$
 * @author conor.roche
 */
@Path("/responsemodel")
public class ResponseModelResource {

	@SuppressWarnings("javadoc")
	@GET
	public Response unspecifiedResponse() {
		return Response.ok().build();
	}

	@SuppressWarnings("javadoc")
	@GET
	public Response1 responseDefinedViaReturn() {
		return new Response1();
	}

	/**
	 * @responseType fixtures.responsemodel.Response2
	 */
	@SuppressWarnings("javadoc")
	@GET
	public Response responseDefinedViaTag() {
		return Response.ok().entity(new Response2()).build();
	}

	/**
	 * @responseMessage 200 if ok `fixtures.responsemodel.Response1
	 * @responseMessage 404 if no result found `fixtures.responsemodel.Response2
	 * @responseMessage 500 if an internal error occurred
	 */
	@SuppressWarnings("javadoc")
	@GET
	public Response responseDefinedViaResponseCode() {
		return Response.ok().entity(new Response2()).build();
	}

	/**
	 * @responseType fixtures.responsemodel.Response2
	 * @responseMessage 404 if no result found `fixtures.responsemodel.Response3
	 */
	@SuppressWarnings("javadoc")
	@GET
	public Response responseMix() {
		return Response.ok().entity(new Response3()).build();
	}

	@GET
	@SuppressWarnings("javadoc")
	public Response4 interfaceResponse() {
		return new Response4() {

			public String getValue() {
				return "test";
			}

		};
	}

	/**
	 * @responseType fixtures.responsemodel.Response4
	 */
	@SuppressWarnings("javadoc")
	@GET
	public Response interfaceResponseViaTag() {
		return Response.ok().entity(new Response4() {

			public String getValue() {
				return "test";
			}

		}).build();
	}

}
