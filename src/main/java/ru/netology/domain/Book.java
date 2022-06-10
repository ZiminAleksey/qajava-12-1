package ru.netology.domain;

import java.security.PublicKey;

public class Book extends Product {
    private String authorName;

    public Book(int id, String name, int cost, String authorName) {
        super(id, name, cost);
        this.authorName = authorName;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return authorName.contains(search);
    }

}
