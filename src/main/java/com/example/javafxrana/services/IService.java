package com.example.javafxrana.services;

import javafx.collections.ObservableList;

import java.util.List;

public interface IService <T>{
    public void ajouter(T p);
    public void supprimer(int id);
    public void modifier(T p);
    public ObservableList<T> getAll();
    public T getTbyId(int id);
}
