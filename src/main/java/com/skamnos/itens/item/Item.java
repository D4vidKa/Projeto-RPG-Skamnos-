package com.skamnos.itens.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.skamnos.itens.listaEquipamentos.*;
import com.skamnos.itens.listaItens.*;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME, 
    include = JsonTypeInfo.As.PROPERTY, 
    property = "tipoItem") // Nome do campo que aparecerá no JSON
@JsonSubTypes({
    // Itens Equipamentos/Armamentos
    @JsonSubTypes.Type(value = ElmoDeKira.class, name = "elmo_kira"),
    @JsonSubTypes.Type(value = FenixEncarnada.class, name = "fenix_encarnada"),
    @JsonSubTypes.Type(value = LancaDeDante.class, name = "lanca_dante"),
    @JsonSubTypes.Type(value = MascaraEterna.class, name = "mascara_eterna"),
    @JsonSubTypes.Type(value = OVeredito.class, name = "o_veredito"),
    // Itens Consumiveis
    @JsonSubTypes.Type(value = BencaoLuminar.class, name = "bencao_luminar"),
    @JsonSubTypes.Type(value = BrasaProibida.class, name = "brasa_proibida"),
    @JsonSubTypes.Type(value = CinzaRubra.class, name = "cinza_rubra"),
    @JsonSubTypes.Type(value = EscamaDeHydrax.class, name = "escama_hydrax"),
    @JsonSubTypes.Type(value = LagrimaDeHydrax.class, name = "lagrima_hydrax"),
    @JsonSubTypes.Type(value = MilagreDeHydrax.class, name = "milagre_hydrax"),
})
public interface Item {
    /*
     * Métodos que todo item deve implementar
     */
    @JsonIgnore
    String getNome();

    @JsonIgnore
    int getPreco();

    @JsonIgnore
    String getDescricao();
}
