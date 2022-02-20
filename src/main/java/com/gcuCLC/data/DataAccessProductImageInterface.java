package com.gcuCLC.data;


import java.util.Optional;

import com.gcuCLC.entity.ProductImageEntity;
import com.gcuCLC.entity.ProductsEntity;

public interface DataAccessProductImageInterface<T> {

	public Optional<ProductImageEntity> findProductImagesByProductId(ProductsEntity id);
}
