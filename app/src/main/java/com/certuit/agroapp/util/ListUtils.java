package com.certuit.agroapp.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    private ListUtils(){}

    public static <T> List<List<T>> separarEnPartes(final List<T> ls) {

        final List<List<T>> lsParts = new ArrayList<>();
        int cont = 0;
        for (int i = 0; i < 3; i++) {
            lsParts.add(new ArrayList<>());
        }
        for (int i = 0; i < ls.size(); i++) {
            if (cont == 0) {
                lsParts.get(0).add(ls.get(i));
                cont++;
            } else if (cont == 1) {
                lsParts.get(1).add(ls.get(i));
                cont++;
            } else {
                lsParts.get(2).add(ls.get(i));
                cont = 0;
            }
        }
        return lsParts;
    }
}
