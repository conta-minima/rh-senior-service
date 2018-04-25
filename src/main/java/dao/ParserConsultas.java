package dao;

import dto.*;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class ParserConsultas {

    private static final int TAMANHO_PADRAO_CPF = 11;

    public List<Funcionario> parseFuncionarios(String response, Empresa empresa) {
        Document document = Jsoup.parse(response);
        List<Funcionario> funcionarios = new ArrayList<>();
        for (Element resultado : document.select("resultado")) {
            Funcionario funcionario = new Funcionario();
            for (Element nome : resultado.select("nome")) {
                if (Funcionario.CAMPO_NUMEMP.equals(nome.text())) {
                    funcionario.setNumemp(nome.nextElementSibling().text());
                }
                if (Funcionario.CAMPO_CODFIL.equals(nome.text())) {
                    funcionario.setCodfil(nome.nextElementSibling().text());
                }
                if (Funcionario.CAMPO_TABORG.equals(nome.text())) {
                    funcionario.setTaborg(nome.nextElementSibling().text());
                }
                if (Funcionario.CAMPO_NUMLOC.equals(nome.text())) {
                    funcionario.setNumloc(nome.nextElementSibling().text());
                }
                if (Funcionario.CAMPO_TIPCOL.equals(nome.text())) {
                    funcionario.setTipcol(nome.nextElementSibling().text());
                }
                if (Funcionario.CAMPO_NUMCAD.equals(nome.text())) {
                    funcionario.setNumcad(nome.nextElementSibling().text());
                }
                if (Funcionario.CAMPO_NOMFUN.equals(nome.text())) {
                    funcionario.setNomfun(nome.nextElementSibling().text());
                }
                if (Funcionario.CAMPO_NUMCPF.equals(nome.text())) {
                    String cpf = nome.nextElementSibling().text();
                    if(StringUtils.isNotBlank(cpf)){
                        if(cpf.trim().length() < TAMANHO_PADRAO_CPF){
                            cpf = StringUtils.leftPad(cpf.trim(), TAMANHO_PADRAO_CPF, "0");
                        }
                    }
                    funcionario.setNumcpf(cpf);
                }
                if (Funcionario.CAMPO_CODCAR.equals(nome.text())) {
                    funcionario.setCodcar(nome.nextElementSibling().text());
                }
                if (Funcionario.CAMPO_ESTCAR.equals(nome.text())) {
                    funcionario.setEstcar(nome.nextElementSibling().text());
                }
            }
            if (funcionario.getNumemp() == null) {
                funcionario.setNumemp(empresa.getNumemp());
            }
            funcionarios.add(funcionario);
        }
        return funcionarios;
    }

    public String getErrorMsg(String response) {
        Document document = Jsoup.parse(response);
        String msg = new String();
        for (Element mensagem : document.select("mensagem")) {
            msg = mensagem.text();
        }
        return msg;
    }

    public List<Empresa> parseEmpresas(String response) {
        Document document = Jsoup.parse(response);
        List<Empresa> empresas = new ArrayList<>();
        for (Element resultado : document.select("resultado")) {
            Empresa empresa = new Empresa();
            for (Element nome : resultado.select("nome")) {
                if (Empresa.CAMPO_NOMEMP.equals(nome.text())) {
                    empresa.setNomemp(nome.nextElementSibling().text());
                }
                if (Empresa.CAMPO_NUMEMP.equals(nome.text())) {
                    empresa.setNumemp(nome.nextElementSibling().text());
                }
            }
            empresas.add(empresa);
        }
        return empresas;
    }

    public List<Filial> parseFiliais(String response) {
        Document document = Jsoup.parse(response);
        List<Filial> filiais = new ArrayList<>();
        for (Element resultado : document.select("resultado")) {
            Filial filial = new Filial();
            for (Element nome : resultado.select("nome")) {
                if (Filial.CAMPO_NOMFIL.equals(nome.text())) {
                    filial.setNomfil(nome.nextElementSibling().text());
                }
                if (Filial.CAMPO_CODFIL.equals(nome.text())) {
                    filial.setCodfil(nome.nextElementSibling().text());
                }
                if (Filial.CAMPO_NUMEMP.equals(nome.text())) {
                    filial.setNumemp(nome.nextElementSibling().text());
                }
            }
            filiais.add(filial);
        }
        return filiais;
    }

    public List<Setor> parseSetores(String response) {
        Document document = Jsoup.parse(response);
        List<Setor> setores = new ArrayList<>();
        for (Element resultado : document.select("resultado")) {
            Setor setor = new Setor();
            for (Element nome : resultado.select("nome")) {
                if (Setor.CAMPO_NOMLOC.equals(nome.text())) {
                    setor.setNomloc(nome.nextElementSibling().text());
                }
                if (Setor.CAMPO_NUMLOC.equals(nome.text())) {
                    setor.setNumloc(nome.nextElementSibling().text());
                }
                if (Setor.CAMPO_TABORG.equals(nome.text())) {
                    setor.setTaborg(nome.nextElementSibling().text());
                }
            }
            setores.add(setor);
        }
        return setores;
    }

    public List<Complemento> parseComplementos(String response) {
        Document document = Jsoup.parse(response);
        List<Complemento> complementos = new ArrayList<>();
        for (Element resultado : document.select("resultado")) {
            Complemento complemento = new Complemento();
            for (Element nome : resultado.select("nome")) {
                if (Complemento.CAMPO_EMAPAR.equals(nome.text())) {
                    complemento.setEmapar(nome.nextElementSibling().text());
                }
                if (Complemento.CAMPO_EMACOM.equals(nome.text())) {
                    complemento.setEmacom(nome.nextElementSibling().text());
                }
                if (Complemento.CAMPO_NUMEMP.equals(nome.text())) {
                    complemento.setNumemp(nome.nextElementSibling().text());
                }
                if (Complemento.CAMPO_NUMEMP.equals(nome.text())) {
                    complemento.setNumemp(nome.nextElementSibling().text());
                }
                if (Complemento.CAMPO_NUMEMP.equals(nome.text())) {
                    complemento.setNumemp(nome.nextElementSibling().text());
                }
                if (Complemento.CAMPO_NUMRAM.equals(nome.text())) {
                    complemento.setNumram(nome.nextElementSibling().text());
                }
            }
            complementos.add(complemento);
        }
        return complementos;
    }

    public List<Cargo> parseCargos(String response) {
        Document document = Jsoup.parse(response);
        List<Cargo> cargos = new ArrayList<>();
        for (Element resultado : document.select("resultado")) {
            Cargo cargo = new Cargo();
            for (Element nome : resultado.select("nome")) {
                if (Cargo.CAMPO_CODCAR.equals(nome.text())) {
                    cargo.setCodcar(nome.nextElementSibling().text());
                }
                if (Cargo.CAMPO_ESTCAR.equals(nome.text())) {
                    cargo.setEstcar(nome.nextElementSibling().text());
                }
                if (Cargo.CAMPO_TITCAR.equals(nome.text())) {
                    cargo.setTitcar(nome.nextElementSibling().text());
                }
            }
            cargos.add(cargo);
        }
        return cargos;
    }

}