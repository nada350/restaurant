/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

/**
 *
 * @author LENOVO
 */


public class MainCourse extends MenuItem implements CloneableMenuItem {
    public MainCourse(String name) {
        super(name);
    }

    @Override
    public CloneableMenuItem clone() {
        return new MainCourse(this.getName());
    }
}

