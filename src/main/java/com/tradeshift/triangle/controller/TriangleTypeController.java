package com.tradeshift.triangle.controller;

import static com.tradeshift.triangle.Constants.GENERAL_EXCEPTION;
import static com.tradeshift.triangle.Constants.MISSING_PARAM;
import static com.tradeshift.triangle.Constants.TYPE_MISMATCH;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tradeshift.triangle.service.TriangleTypeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/triangle")
public class TriangleTypeController
{
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TriangleTypeService triangleTypeService;

    @ApiOperation(value = "Get triangle type")
    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public ResponseEntity<String> getType(
        @RequestParam(name = "a", required = true) final int sideA,
        @RequestParam(name = "b", required = true) final int sideB,
        @RequestParam(name = "c", required = true) final int sideC)
    {
        log.info("Controller call (getType) with {}, {}, {}", sideA, sideB, sideC);

        return new ResponseEntity<String>(triangleTypeService.getType(sideA, sideB, sideC), HttpStatus.OK);
    }

    // Must handle string inputs for params
    @ExceptionHandler(TypeMismatchException.class)
    public @ResponseBody ResponseEntity<String> typeMismatchExpcetionHandler(final Exception exception, final HttpServletRequest request)
    {
        return new ResponseEntity<String>(TYPE_MISMATCH, HttpStatus.BAD_REQUEST);
    }

    // Must handle missing params
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public @ResponseBody ResponseEntity<String> missingParameterExceptionHandler(final Exception exception, final HttpServletRequest request)
    {
        return new ResponseEntity<String>(MISSING_PARAM, HttpStatus.BAD_REQUEST);
    }

    // Normally, this handling will be never used
    @ExceptionHandler(Exception.class)
    public @ResponseBody ResponseEntity<String> generalExceptionHandler(final Exception exception, final HttpServletRequest request)
    {
        return new ResponseEntity<String>(GENERAL_EXCEPTION, HttpStatus.BAD_REQUEST);
    }
}
