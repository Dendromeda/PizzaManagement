/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import business.entites.Pizza;
import java.util.List;

/**
 *
 * @author Jakob
 */
public interface PizzaDAO {
    void add(Pizza p);
    void update(Pizza p);
    void remove(Pizza p);
    void remove(int id);
    Pizza get(int id);
    List<Pizza> getByName(String name);
    List<Pizza> getByTopping(String topping);
    List<Pizza> getByPriceRange(double low, double high);
    List<Pizza> getAll();
    
}
