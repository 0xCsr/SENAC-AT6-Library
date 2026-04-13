/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.cesar.biblioteca.model.dto;

import java.util.UUID;

/**
 *
 * @author cesar
 */
public record LoanRequest(
        UUID userId,
        UUID bookId,
        int loanDays
) {

}
