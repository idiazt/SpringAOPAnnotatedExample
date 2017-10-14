package com.idiazt.springaopannotationsexample.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.idiazt.springaopaspectjannotationsexample.entities.Product;
import com.idiazt.springaopaspectjannotationsexample.service.IProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-beans.xml"})
public class TestAOPWithAnnotationsConfiguration {

    @Autowired
    IProductService productService;
        
    @Test
    public void testProductService() {
        Product product = productService.findById(1L);
        assertThat(product.getId(), is(1L));
    }

}
