package service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.ColaboradorDTO;
import repository.ColaboradorRepository;

@Path("/colaborador")
public class ColaboradorService {

	@GET
	@Path("/mock")
    @Produces(MediaType.APPLICATION_JSON)
	public List<ColaboradorDTO> mock(){
		return new ColaboradorRepository().mock();
	}
}
