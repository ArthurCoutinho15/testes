package br.newtonpaiva.testeSecurity.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class ProductRequest {
    @Id
    private String id;
    private String product;
    private String categoria;

    public ProductRequest() {
    }

    public ProductRequest(String id, String product, String categoria) {
        this.id = id;
        this.product = product;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
