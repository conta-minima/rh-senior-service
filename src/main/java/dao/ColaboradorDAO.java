package dao;

import config.PropertiesReader;
import dto.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ColaboradorDAO {

    public static final String TEMPLATE_REQUEST_XML = "template_request.xml";
    public static final String TEMPLATE_REQUEST_XML_INTERVALADA = "template_request_intervalada.xml";


    public List<ColaboradorDTO> getColaboradores() throws IOException {


        List<ColaboradorDTO> colaboradores = new ArrayList<>();
        ParserConsultas parser = new ParserConsultas();

        Properties properties = PropertiesReader.getInstance().getProperties();
        RequestDataProvider dataProvider = new RequestDataProvider();
        dataProvider.setUsuario(properties.getProperty("usuario"));
        dataProvider.setSenha(properties.getProperty("senha"));
        dataProvider.setEncriptacao(String.valueOf(0));
        String url = properties.getProperty("url");
        Integer intervalo = getIntervalo(properties);

        String response = consultar(url, dataProvider, Empresa.TABELA, Empresa.CAMPOS);
        List<Empresa> empresas = parser.parseEmpresas(response);
        response = consultar(url, dataProvider, Filial.TABELA, Filial.CAMPOS);
        List<Filial> filiais = parser.parseFiliais(response);
        response = consultar(url, dataProvider, Setor.TABELA, Setor.CAMPOS);
        List<Setor> setores = parser.parseSetores(response);

        List<Funcionario> funcionarios = new ArrayList<>();
        for (TipoColaborador tipoColaborador : TipoColaborador.values()) {
            for (Empresa empresa : empresas) {
                String mensagem = new String();
                Integer valorMin = 0;
                do {
                    Integer valorMax = valorMin + intervalo;
                    response = consultarPorIntervalo(url, dataProvider, Funcionario.TABELA, Funcionario.CAMPOS, valorMin, valorMax, tipoColaborador, empresa.getNumemp());
                    mensagem = parser.getErrorMsg(response);
                    funcionarios.addAll(parser.parseFuncionarios(response, empresa));
                    valorMin = valorMax;
                } while (mensagem.isEmpty());
            }
        }

        List<Complemento> complementos = new ArrayList<>();
        for (TipoColaborador tipoColaborador : TipoColaborador.values()) {
            for (Empresa empresa : empresas) {
                String mensagem = new String();
                Integer valorMin = 0;
                do {
                    Integer valorMax = valorMin + intervalo;
                    response = consultarPorIntervalo(url, dataProvider, Complemento.TABELA, Complemento.CAMPOS, valorMin, valorMax, tipoColaborador, empresa.getNumemp());
                    mensagem = parser.getErrorMsg(response);
                    complementos.addAll(parser.parseComplementos(response));
                    valorMin = valorMax;
                } while (mensagem.isEmpty());
            }
        }

        for (Funcionario funcionario : funcionarios) {
            ColaboradorDTO colaborador = new ColaboradorDTO();
            colaborador.setNome(funcionario.getNomfun());
            colaborador.setMatricula(funcionario.getNumcad());
            colaborador.setCpf(funcionario.getNumcpf());

            for (Empresa empresa : empresas) {
                if (funcionario.getNumemp().equals(empresa.getNumemp())) {
                    colaborador.setEmpresa(empresa.getNomemp());
                    break;
                }
            }

            for (Filial filial : filiais) {
                if (funcionario.getCodfil().equals(filial.getCodfil()) && funcionario.getNumemp().equals(filial.getNumemp())) {
                    colaborador.setUnidade(filial.getNomfil());
                    break;
                }
            }

            for (Setor setor : setores) {
                if (funcionario.getTaborg().equals(setor.getTaborg()) && funcionario.getNumloc().equals(setor.getNumloc())) {
                    colaborador.setSetor(setor.getNomloc());
                    break;
                }
            }

            for (Setor setor : setores) {
                if (funcionario.getTaborg().equals(setor.getTaborg()) && funcionario.getNumloc().equals(setor.getNumloc())) {
                    colaborador.setSetor(setor.getNomloc());
                    break;
                }
            }

            for (Complemento complemento : complementos) {
                if (funcionario.getTipcol().equals(complemento.getTipcol()) && funcionario.getNumcad().equals(complemento.getNumcad()) && funcionario.getNumemp().equals(complemento.getNumemp())) {
                    colaborador.setPabx(complemento.getNumram());
                    colaborador.setEmail(complemento.getEmapar() != null ? complemento.getEmapar() : complemento.getEmacom());
                    break;
                }
            }
            colaboradores.add(colaborador);
        }
        return colaboradores;
    }

    private String consultar(String url, RequestDataProvider dataProvider, String tabela, String campos) throws IOException {
        dataProvider.setTabela(tabela);
        dataProvider.setCampos(campos);
        TemplateGenerator generator = new TemplateGenerator();
        generator.setTemplate(TEMPLATE_REQUEST_XML);
        generator.setDataProvider(dataProvider);
        Connector conn = new Connector();
        return conn.doPost(generator.generate(), url);
    }

    private String consultarPorIntervalo(String url, RequestDataProvider dataProvider, String tabela, String campos, Integer valorMin, Integer valorMax, TipoColaborador tipoColaborador, String empresa) throws IOException {
        dataProvider.setTabela(tabela);
        dataProvider.setCampos(campos);
        dataProvider.setValorMin(valorMin.toString());
        dataProvider.setValorMax(valorMax.toString());
        dataProvider.setParam1(empresa);
        dataProvider.setParam2(tipoColaborador.getCodigo().toString());
        TemplateGenerator generator = new TemplateGenerator();
        generator.setTemplate(TEMPLATE_REQUEST_XML_INTERVALADA);
        generator.setDataProvider(dataProvider);
        Connector conn = new Connector();
        return conn.doPost(generator.generate(), url);
    }

    private Integer getIntervalo(Properties properties) {
        String intervaloConsulta = properties.getProperty("intervalo_consulta");
        return Integer.valueOf(intervaloConsulta);
    }
}
