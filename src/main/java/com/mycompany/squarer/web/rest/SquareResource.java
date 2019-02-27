package com.mycompany.squarer.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * SquareResource controller
 */
@RestController
@RequestMapping("/api/square")
@Validated
public class SquareResource {

    private final Logger log = LoggerFactory.getLogger(SquareResource.class);

    /**
    * GET square
    */
    @GetMapping("/{input}")
    public String square(@PathVariable("input") @Valid long input) {
        return String.valueOf((long) Math.pow(input, 2));
    }

}
