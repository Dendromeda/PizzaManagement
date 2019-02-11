/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import business.entites.Pizza;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jakob
 */
public class PizzaJPA implements PizzaDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Pizza p) {
        if (get(p.getId()) != null) throw new IllegalStateException("Cannot add entity with existing id");
        em.persist(p);
    }

    @Override
    public void update(Pizza p) {
        if (get(p.getId()) == null) throw new IllegalStateException("Cannot update entity with no existing id");
        em.merge(p);
    }

    @Override
    public void remove(Pizza p) {
        em.remove(p);
    }
    
    @Override
    public void remove(int id){
        remove(get(id));
    }

    @Override
    public Pizza get(int id) {
        return em.find(Pizza.class, id);
    }

    @Override
    public List<Pizza> getByName(String name) {
        Query q = em.createQuery("Select p FROM Pizza p where name LIKE :name");
        q.setParameter("name", '%'+name+'%');
        return q.getResultList();
    }

    @Override
    public List<Pizza> getByTopping(String topping) {
        Query q = em.createQuery("Select p FROM Pizza p where toppings LIKE :topping");
        q.setParameter("topping", '%'+topping+'%');
        return q.getResultList();
    }

    @Override
    public List<Pizza> getByPriceRange(double low, double high) {
        Query q = em.createQuery("Select p FROM Pizza p where p.price > :low AND p.price < :high");
        q.setParameter("low", low);
        q.setParameter("high", high);
        return q.getResultList();
    }

    @Override
    public List<Pizza> getAll() {
        Query q = em.createQuery("Select p FROM Pizza p");
        return q.getResultList();
    }
    
}
