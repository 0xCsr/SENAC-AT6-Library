/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.cesar.biblioteca.model.dto;

/**
 *
 * @author cesar
 */
public record RegisterRequest(
        String name,
        String username,
        String password,
        String address,
        String phone
) {

}
