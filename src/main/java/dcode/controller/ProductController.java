package dcode.controller;

import dcode.service.ProductService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    //상품 리스트 api
    @GetMapping
    public ResponseEntity<ArrayList<Object>> getProducts() {
        ArrayList<Object> response = service.getProducts();
        return new ResponseEntity<>(response, HttpStatus.OK);
    	
    }

    //상품 상세 api
    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> getProductDetail(HttpServletRequest request) {
    	String productId = request.getParameter("productId");    	
    	HashMap<String, Object> response = service.getProductDetail(productId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    	
    }
}
