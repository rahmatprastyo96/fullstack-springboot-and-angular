package com.codemathdev.ecommerce.config;

import com.codemathdev.ecommerce.entity.Product;
import com.codemathdev.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDateRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] theUnSupportActions = {HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.DELETE};

        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnSupportActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnSupportActions)));


        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnSupportActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnSupportActions)));
    }

}
