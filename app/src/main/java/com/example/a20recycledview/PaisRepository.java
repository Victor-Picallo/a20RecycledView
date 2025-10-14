package com.example.a20recycledview;

import java.util.ArrayList;
import java.util.List;

public class PaisRepository {

    private List<String> nameList;

    public PaisRepository() {
        nameList = new ArrayList<>();
        nameList.add("China");
        nameList.add("France");
        nameList.add("Germany");
        nameList.add("India");
        nameList.add("Russia");
        nameList.add("United Kingdom");
        nameList.add("United States");
        nameList.add("Spain");
        nameList.add("Chile");
        nameList.add("Peru");
        nameList.add("Argentina");
        nameList.add("Brasil");
        nameList.add("Canada");
        nameList.add("Japon");
    }

    public List<String> obtenerListaPaises() {
        return nameList;
    }
}
