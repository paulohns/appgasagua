package com.appdeveloper.appgasagua.paulohenrique.appgasagua.utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Produto;

/**
 * @author PauloHenrique
 *
 */
@FacesConverter(forClass = Produto.class, value="produtoConverter")
public class ProdutoConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Produto) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Produto) {
            Produto produto = (Produto) value;
            if (produto != null && produto instanceof Produto && produto.getIdProduto() != null) {
                uiComponent.getAttributes().put( produto.getIdProduto().toString(), produto);
                return produto.getIdProduto().toString();
            }
        }
        return "";
    }
}