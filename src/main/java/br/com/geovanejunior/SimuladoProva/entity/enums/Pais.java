package br.com.geovanejunior.SimuladoProva.entity.enums;

public enum Pais {

    BRASIL(1, "Brasil"),
    ESTADOSUNIDOS(2, "Estados Unidos da América"),
    INGLATERRA(3, "Inglaterra"),
    IRLANDA(4, "Irlanda"),
    ITALIA(5, "Italia"),
    PORTUGAL(6, "Portugal");

    private Integer codPais;
    private String nomePais;

    Pais(Integer codPais, String nomePais) {
        this.codPais = codPais;
        this.nomePais = nomePais;
    }

    public Integer getCodPais() {
        return codPais;
    }

    public String getNomePais() {
        return nomePais;
    }

    public static Pais toEnum(Integer codPais) {

        if (codPais == null) {
            return null;
        }

        for (Pais cdPais : Pais.values()) {

            if (codPais.equals(cdPais.getCodPais())) {
                return cdPais;
            }
        }

        throw new IllegalArgumentException("País Inválido: " + codPais);

    }
}
