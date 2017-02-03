/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.spring.data.model;

/**
 * @author anatolii
 */
public interface OrdersCount {

//    @Value("#{target.firstName}")


//    @Value("#{target.ordersCount}")
    Long getOrdersCount();

//    @Value("#{target.firstName}")
    String getName();

    Long getId();
}
