package br.com.geovanejunior.SimuladoProva.entity.enums;

public enum TipoTelefone {

    COMERCIAL('C', "Comercial"),
    RESIDENCIAL('R', "Residencial"),
    CELULAR('L', "Celular"),
    OUTRO('O', "Outros");

    private Character tipoTelefone;
    private String descTipoTelefone;

    TipoTelefone(Character tipoTelefone, String descTipoTelefone) {
        this.tipoTelefone = tipoTelefone;
        this.descTipoTelefone = descTipoTelefone;
    }

    public Character getTipoTelefone() {
        return tipoTelefone;
    }

    public String getDescTipoTelefone() {
        return descTipoTelefone;
    }

    public static TipoTelefone toEnum(Character tipoTelefone) {

        if (tipoTelefone == null) {
            return null;
        }

        for (TipoTelefone codTipoTelefone : TipoTelefone.values()) {
            if (tipoTelefone.equals(codTipoTelefone.getTipoTelefone())) {

                return codTipoTelefone;
            }
        }

        throw new IllegalArgumentException("Tipo Telefone Inválido: " + tipoTelefone);
    }
}
