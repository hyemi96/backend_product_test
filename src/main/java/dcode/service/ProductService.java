package dcode.service;

import dcode.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository repository;

    public ArrayList<Object> getProducts(){
       return repository.getProduct();
        
    }
    
    /*메인 상품 조회*/
    public HashMap<String, Object> getProductDetail(String productId){
    	HashMap<String, Object> productDetail = new HashMap<String, Object>();
    	int productIdInt = Integer.valueOf(productId);
    	productDetail.put("main", repository.getProductDetail(productIdInt));
    	
    	int selling_type = repository.getProductDetail(productIdInt).getSelling_type_id();    	
    	if(selling_type == 3) { //묶음상품    		
    		productDetail.put("sub", getSubProducts(selling_type));
    	}else if(selling_type == 4) { //옵션상품    		
    		productDetail.put("sub", getSubProducts(selling_type));
    	}
    	
       return productDetail;
    }
    
    /*서브 상품 조회*/
    public ArrayList<Object> getSubProducts(int sellingTypeId){
       return repository.getSubProducts(sellingTypeId);
        
    }
    
}
