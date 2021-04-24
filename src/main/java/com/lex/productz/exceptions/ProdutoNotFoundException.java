package com.lex.productz.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "produto not found")
public class ProdutoNotFoundException extends Exception {

}
