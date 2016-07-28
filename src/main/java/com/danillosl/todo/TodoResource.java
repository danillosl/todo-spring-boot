package com.danillosl.todo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import org.springframework.beans.factory.annotation.Autowired;

@Path("/todos")
@Produces("application/json")
@Consumes("application/json")
public class TodoResource {

	@Autowired
	private TodoService todoService;

	@POST
	public Response create(final TodoModel todomodel) {

		this.todoService.save(todomodel);

		return Response
				.created(UriBuilder.fromResource(TodoResource.class).path(String.valueOf(todomodel.getId())).build())
				.build();
	}

	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") final String id) {
		TodoModel todomodel = todoService.findById(id);
		if (todomodel == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(todomodel).build();
	}

	@GET
	public List<TodoModel> listAll() {
		final List<TodoModel> todomodels = todoService.list();
		return todomodels;
	}

	@DELETE
	@Path("/{id}")
	public Response deleteById(@PathParam("id") final String id) {
		todoService.delete(id);
		return Response.ok().build();
	}

}
