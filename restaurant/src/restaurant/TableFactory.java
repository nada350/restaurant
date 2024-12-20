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


public class TableFactory {
    public Table createTable(String type) {
        switch (type.toLowerCase()) {
            case "regular":
                return new RegularTable();
           
            case "outdoor":
                return new OutdoorTable();
            default:
                throw new IllegalArgumentException("Invalid Table Type");
        }
    }
}

