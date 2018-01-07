package com.kuravita.inventorymanagementservice.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.kuravita.inventorymanagementservice.model.Category;
import com.kuravita.inventorymanagementservice.repository.CategoryRepository;

import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * @author rene.moise.kwibuka
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CategoryController.class)
@WebAppConfiguration
public class CategoryControllerTest {
    private List<Category> categoryList = new ArrayList<>();
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
	private CategoryRepository CatRepo;
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	
	 @Before
	    public void setup() throws Exception {
	        this.mockMvc = webAppContextSetup(webApplicationContext).build();

	        this.CatRepo.deleteAll();	
	        Category immuneCat = new Category();
	        immuneCat.setName("Immunologic");
	        immuneCat.setDescription("Medicines related to immune system");
	        //TODO: Should I products here to test them? (maybe it should fail because category should be able to be created
	        //TODO: without specifying products)? Ex of Imm: Binetrakin.
	        Category anestheticsCat = new Category();
	        anestheticsCat.setName("Anesthetics");
	        anestheticsCat.setDescription("prevent pain during surgery");
	        //TODO: Should I products here to test them? (maybe it should fail because category should be able to be created
	        //TODO: without specifying products)? Ex of Aneth: Ether.
	        this.categoryList.add(CatRepo.save(immuneCat));
	        this.categoryList.add(CatRepo.save(anestheticsCat));
	    }
	 
	 	@Test
	    public void readSingleCategory() throws Exception {
	        mockMvc.perform(get("/category/getOne/Immunologic"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(contentType))
	                .andExpect(jsonPath("$.id", is(this.categoryList.get(0).getCategoryId().intValue())))
	                //TODO; WHy is this is not working.
//	                .andExpect(jsonPath("$.name"), is("Immunologic"))
	                .andExpect(jsonPath("$.description", is("Medicines related to immune system")));
	    }
}
