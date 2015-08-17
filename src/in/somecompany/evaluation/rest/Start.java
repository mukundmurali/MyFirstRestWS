package in.somecompany.evaluation.rest;

import in.somecompany.evaluation.data.DataList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello/{key}")
public class Start {
	  @GET
	  @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
	  public String sayPlainTextHello(@PathParam("key") String key) {
	    return DataList.getData(key);
	  }
}
