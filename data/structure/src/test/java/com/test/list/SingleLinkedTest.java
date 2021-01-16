package com.test.list;

import com.test.list.model.Hero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SingleLinkedTest {

    private Hero hero1;
    private Hero hero2;
    private Hero hero3;
    private Hero hero4;

    private SingleLinked singleLinked;

    @BeforeEach
    void beforeEach(){
        hero1 = new Hero(1, "a", "a1");
        hero2 = new Hero(2, "b", "b1");
        hero3 = new Hero(3, "c", "c1");
        hero4 = new Hero(4, "d", "d1");
        singleLinked = new SingleLinked();
    }

    @Test
    void addTest() {
        singleLinked.add(hero1);
        singleLinked.add(hero2);
        singleLinked.add(hero3);
        singleLinked.add(hero4);
        singleLinked.list();
    }

    @Test
    void addByOrderTest(){
        singleLinked.addByOrder(hero1);
        singleLinked.addByOrder(hero4);
        singleLinked.addByOrder(hero3);
        singleLinked.addByOrder(hero2);
        singleLinked.addByOrder(hero1);
        singleLinked.list();
    }

    @Test
    void updateTest() {
        singleLinked = new SingleLinked();
        singleLinked.add(hero1);
        singleLinked.add(hero2);
        singleLinked.add(hero3);
        singleLinked.add(hero4);
        Hero newHero = new Hero(7, "aa", "aa1");
        singleLinked.update(newHero);
        singleLinked.list();
    }
}