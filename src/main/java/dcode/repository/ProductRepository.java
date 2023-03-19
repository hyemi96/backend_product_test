package dcode.repository;

import dcode.domain.entity.Product;
import dcode.model.response.ProductDetailResponse;
import dcode.model.response.ProductListResponse;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ProductRepository {
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public ArrayList<Object> getProduct() {
		String query = "SELECT * FROM `PRODUCT_INFO`AS PI " + "LEFT OUTER JOIN `PRODUCT_CATEGORY` AS PC "
				+ "ON PI.product_category_id = PC.id " + "LEFT OUTER JOIN `SELLING_TYPE` AS ST "
				+ "ON PC.selling_type_id = ST.id ";

		ArrayList<Object> product_list = new ArrayList<Object>();
		namedParameterJdbcTemplate.query(query,
				(rs, rowNum) -> product_list.add(ProductListResponse.builder().id(rs.getInt("id"))
						.name(rs.getString("name")).price(rs.getInt("price")).soldout(rs.getString("soldout"))
						.product_category_id(rs.getInt("product_category_id"))
						.category_name(rs.getString("category_name")).selling_type_id(rs.getInt("selling_type_id"))
						.selling_type_name(rs.getString("selling_type_name")).build()));

		return product_list;

	}

	public ProductDetailResponse getProductDetail(int id) {
		String query = "SELECT * FROM `PRODUCT_INFO`AS PI " + "LEFT OUTER JOIN `PRODUCT_CATEGORY` AS PC "
				+ "ON PI.product_category_id = PC.id " + "LEFT OUTER JOIN `SELLING_TYPE` AS ST "
				+ "ON PC.selling_type_id = ST.id " + "WHERE PI.id = :id ";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return namedParameterJdbcTemplate.queryForObject(query, params,
				(rs, rowNum) -> ProductDetailResponse.builder().id(rs.getInt("id"))
						.name(rs.getString("name")).price(rs.getInt("price")).soldout(rs.getString("soldout"))
						.product_category_id(rs.getInt("product_category_id"))
						.category_name(rs.getString("category_name")).selling_type_id(rs.getInt("selling_type_id"))
						.selling_type_name(rs.getString("selling_type_name")).build());	    		
	}
	
	public ArrayList<Object> getSubProducts(int sellingTypeId) {
		MapSqlParameterSource params = new MapSqlParameterSource();	
		String query = "SELECT * FROM `PRODUCT_INFO`AS PI " + "LEFT OUTER JOIN `PRODUCT_CATEGORY` AS PC "
				+ "ON PI.product_category_id = PC.id " + "LEFT OUTER JOIN `SELLING_TYPE` AS ST "
				+ "ON PC.selling_type_id = ST.id "  + "WHERE ST.id = :id AND PC.sub = :sub";

			
		if(sellingTypeId == 3) {//묶음상품
			params.addValue("id", 3);
			params.addValue("sub", "Y");				
		}else if(sellingTypeId == 4) {//옵셥상품 
			params.addValue("id", 1);
			params.addValue("sub", "N");	
		}		
		ArrayList<Object> product_list = new ArrayList<Object>();
		namedParameterJdbcTemplate.query(query, params,
				(rs, rowNum) -> product_list.add(ProductListResponse.builder().id(rs.getInt("id"))
						.name(rs.getString("name")).price(rs.getInt("price")).soldout(rs.getString("soldout"))
						.product_category_id(rs.getInt("product_category_id"))
						.category_name(rs.getString("category_name")).selling_type_id(rs.getInt("selling_type_id"))
						.selling_type_name(rs.getString("selling_type_name")).build()));

		return product_list;

	}
}
