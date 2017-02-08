/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.spring.data.repositories.procedure;

/**
 * @author anatolii
 */
public class Procedures {

    public static void binaryAdd(Long first, Long second, Long[] result) {
        result[0] = first + second;
    }
}
