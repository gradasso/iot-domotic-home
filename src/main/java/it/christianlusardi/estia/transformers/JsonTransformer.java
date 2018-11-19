package it.christianlusardi.estia.transformers;

import com.google.gson.Gson;

import spark.ResponseTransformer;


/**
 * Simple Json trasformer
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
public class JsonTransformer implements ResponseTransformer {

    private Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }

}