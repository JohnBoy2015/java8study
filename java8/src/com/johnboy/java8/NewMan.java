package com.johnboy.java8;

import java.util.Optional;

public class NewMan {
    //有可能有  有可嫩没有的值 包装到Optional
    private Optional<Godness> godness = Optional.empty();

    public Optional<Godness> getGodness() {
        return godness;
    }

    public void setGodness(Optional<Godness> godness) {
        this.godness = godness;
    }

    public NewMan(Optional<Godness> godness) {
        this.godness = godness;
    }

    public NewMan() {
    }

    @Override
    public String toString() {
        return "NewMan{" +
                "godness=" + godness +
                '}';
    }
}
