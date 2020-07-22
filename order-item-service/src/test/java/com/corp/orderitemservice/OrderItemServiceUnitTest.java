package com.corp.orderitemservice;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.corp.orderitemservice.dto.CreateOrderItemDto;
import com.corp.orderitemservice.entity.OrderItem;
import com.corp.orderitemservice.service.OrderItemService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class OrderItemServiceUnitTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderItemService orderItemService;

	@Test
	public void testGetOrderItem() throws Exception {

		// given
		OrderItem orderItem = new OrderItem();
		orderItem.setProductCode("LAP");
		orderItem.setProductName("LAPTOP");
		orderItem.setQuantity(10);

		given(orderItemService.getOrderItem(Mockito.anyString())).willReturn(orderItem);

		// Get Order
		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/orderItem/retrieveOrderItem/{productCode}", "LAP")
						.accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.productCode").value("LAP"));

	}

	@Test
	public void testCreateOrderItem() throws Exception {

		// given
		OrderItem orderItem = new OrderItem();
		orderItem.setProductCode("LAP");
		orderItem.setProductName("LAPTOP");
		orderItem.setQuantity(10);

		CreateOrderItemDto createOrderDto = new CreateOrderItemDto();
		createOrderDto.setProductCode("LAP");

		given(orderItemService.createOrderItem(createOrderDto)).willReturn(String.valueOf(orderItem.getProductCode()));

		// Get Order
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/orderItem/createOrderItem").content(asJsonString(createOrderDto))
						.accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print()).andExpect(status().isOk());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
