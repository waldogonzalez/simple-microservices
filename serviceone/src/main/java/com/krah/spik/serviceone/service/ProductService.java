package com.krah.spik.serviceone.service;

import com.krah.spik.serviceone.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final WebClient.Builder webclientBuilder;

    public Long getUserProductCount(Long userId) {
        Product[] products = this.webclientBuilder.build().get().uri("http://service-two/product/find"
                , uriBuilder -> uriBuilder.queryParam("userId", userId).build()).retrieve().bodyToMono(Product[].class).block();
        return Arrays.stream(products).count();
    }
}
