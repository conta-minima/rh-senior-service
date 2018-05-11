package dto;

public enum TipoColaborador {

    EMPREGADO(1),
    TERCEIRO(2),
    PARCEIRO(3);


    int codigo;

    TipoColaborador(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

}
