package com.anele.product_service.controller;

import com.anele.product_service.dto.ProductRequest;
import com.anele.product_service.dto.ProductResponse;
import com.anele.product_service.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductServiceController.class)
class ProductServiceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private ProductService productService;

	private ProductRequest sampleRequest;
	private ProductResponse sampleResponse;
	private final String BASE_URL = "/api/v1/products";

	@BeforeEach
	void setUp() {
		// Initialize mock objects for reuse across tests
		sampleRequest = new ProductRequest("SKU-123", "Gaming Laptop", "High performance laptop", new BigDecimal("15000.00"));
		sampleResponse = new ProductResponse(1L, "SKU-123", "Gaming Laptop", "High performance laptop", new BigDecimal("15000.00"));
	}

	@Test
	@DisplayName("GET " + BASE_URL + " - Should return 200 OK and list of products")
	void getAllProducts_ShouldReturnListAnd200() throws Exception {
		// Arrange
		List<ProductResponse> products = List.of(sampleResponse);
		when(productService.getAllProducts()).thenReturn(products);

		// Act & Assert
		mockMvc.perform(get(BASE_URL))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.size()").value(1))
				.andExpect(jsonPath("$[0].sku").value("SKU-123"))
				.andExpect(jsonPath("$[0].name").value("Gaming Laptop"));

		verify(productService, times(1)).getAllProducts();
	}

	@Test
	@DisplayName("POST " + BASE_URL + " - Should create product and return 201 Created")
	void createProduct_ShouldReturnCreatedAndProduct() throws Exception {
		// Arrange
		when(productService.createProduct(any(ProductRequest.class))).thenReturn(sampleResponse);

		// Act & Assert
		mockMvc.perform(post(BASE_URL)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(sampleRequest)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.sku").value("SKU-123"));

		verify(productService, times(1)).createProduct(any(ProductRequest.class));
	}

	@Test
	@DisplayName("GET " + BASE_URL + "/{sku} - Should return product and 200 OK")
	void getProductBySku_ShouldReturnProductAnd200() throws Exception {
		// Arrange
		String sku = "SKU-123";
		when(productService.getProductBySku(sku)).thenReturn(sampleResponse);

		// Act & Assert
		mockMvc.perform(get(BASE_URL + "/{sku}", sku))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.sku").value(sku));

		verify(productService, times(1)).getProductBySku(sku);
	}

	@Test
	@DisplayName("PUT " + BASE_URL + "/{sku} - Should update product and return 200 OK")
	void updateProduct_ShouldReturnUpdatedProductAnd200() throws Exception {
		// Arrange
		String sku = "SKU-123";
		when(productService.updateProductBySku(eq(sku), any(ProductRequest.class))).thenReturn(sampleResponse);

		// Act & Assert
		mockMvc.perform(put(BASE_URL + "/{sku}", sku)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(sampleRequest)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.sku").value(sku));

		verify(productService, times(1)).updateProductBySku(eq(sku), any(ProductRequest.class));
	}

	@Test
	@DisplayName("DELETE " + BASE_URL + "/{sku} - Should delete product and return 244 No Content")
	void deleteProductBySku_ShouldReturn204NoContent() throws Exception {
		// Arrange
		String sku = "SKU-123";
		doNothing().when(productService).deleteProductBySku(sku);

		// Act & Assert
		mockMvc.perform(delete(BASE_URL + "/{sku}", sku))
				.andExpect(status().isNoContent());

		verify(productService, times(1)).deleteProductBySku(sku);
	}
}
