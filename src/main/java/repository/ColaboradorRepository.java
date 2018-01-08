package repository;

import java.util.ArrayList;
import java.util.List;

import dto.ColaboradorDTO;

public class ColaboradorRepository {

	public List<ColaboradorDTO> mock(){
		
		List<ColaboradorDTO> list = new ArrayList<>();
		
		ColaboradorDTO c1 = new ColaboradorDTO();
		c1.setNome("Colaborador 1");
		c1.setMatricula("1234");
		c1.setEmpresa("Conta Mínima");
		c1.setUnidade("Florianópolis");
		c1.setSetor("Desenvolvimento");
		c1.setEmail("colaborador@contaminima.com.br");
		c1.setAtivo(true);
		c1.setSenha("1234");
		c1.setPabx("9876");
		c1.setCargo("Analista de Sistemas");
		c1.setCpf("12345678911");
		
		ColaboradorDTO c2 = new ColaboradorDTO();
		c2.setNome("Colaborador 2");
		c2.setMatricula("98765");
		
		list.add(c1);
		list.add(c2);
		
		return list;
	}
	
}
