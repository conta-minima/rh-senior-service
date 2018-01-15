package service;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ColaboradorDAO;
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

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ColaboradorDTO> getColaboradores() throws IOException {
		ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
		return colaboradorDAO.getColaboradores();
	}
}