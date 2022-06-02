package br.com.fabio.imdbappjava;

import java.util.List;

public class ImdbResponse {
    List<ImdbResponseItem> items;
    String errorMessage;

    public List<ImdbResponseItem> getItems() {
        return items;
    }

    public void setItems(List<ImdbResponseItem> items) {
        this.items = items;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
