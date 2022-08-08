package com.leonrv.crud_bp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leonrv.crud_bp.models.Order;
import com.leonrv.crud_bp.services.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
@RestController
@RequestMapping("api/v1/services/paypal")  @CrossOrigin("*")
// @CrossOrigin("*")
public class PaypalController {

    @Autowired
    PaypalService service;

    public   String SUCCESS_URL = "";
    public   String CANCEL_URL = "";
    public static final String ENV = "prod";

    public PaypalController(){
        if(ENV.equals("prod")){
            this.SUCCESS_URL = "https://focsi.azurewebsites.net/?success=true";
            this.CANCEL_URL = "https://focsi.azurewebsites.net/?success=false";
        }else{
            this.SUCCESS_URL = "http://localhost:4200/?success=true";
            this.CANCEL_URL = "http://localhost:4200/?success=false";
        }
    }

   
    @PostMapping
    public ResponseEntity<?> payment(@RequestParam(required = false) String total, 
    @RequestParam(required = false)  String currency, 
    @RequestParam(required = false)  String method, 
    @RequestParam(required = false)  String description) {
        try {

            // System.out.println(total);
            // System.out.println(method);
            // System.out.println(currency);
            // System.out.println(description);
            Payment payment = service.createPayment(Double.valueOf(total), currency, method,
                    "sale", description, CANCEL_URL ,SUCCESS_URL);
            // Payment payment = service.createPayment(1.0, "MXN", "paypal",
            //         "sale", "descripcion", CANCEL_URL ,SUCCESS_URL);
            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return new ResponseEntity<String>(link.getHref(), HttpStatus.OK);
                }
            }

        } catch (PayPalRESTException e) {

            e.printStackTrace();
        }
        return new ResponseEntity<String>("an error has ocurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/failure")
    public ResponseEntity<?> cancelPay() {
        return new ResponseEntity<String>("cancelled", HttpStatus.OK);
    }

    @GetMapping(value = "/success")
    public ResponseEntity<?> successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = service.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return new ResponseEntity<String>("success", HttpStatus.OK);
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<String>("failure pay", HttpStatus.OK);
    }
}
