/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hcl.explore.products.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

/**
 * Simple JavaBean object representing a product.
 * 
 * @author Indian Bittu
 *
 */
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String userName;
	@Column(name = "PRODUCT_NAME", length = 400)
	private String productName;
	@Column(name = "PRODUCT_IMAGE_SRC")
	private String productImageSrc;
	@Column(name = "description", length = 1000)
	private String description;
	@Column(name = "PRODUCT_LINK", length = 1000)
	private String productLink;
	@Transient
	private MultipartFile productImageFile;

	public Product() {
		super();
	}

	public Product(String userName, String productName, String productImageSrc, String desc, String productLink,
			boolean isDone) {
		super();
		this.userName = userName;
		this.productName = productName;
		this.productImageSrc = productImageSrc;
		this.description = desc;
		this.productLink = productLink;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImageSrc() {
		return productImageSrc;
	}

	public void setProductImageSrc(String productImageSrc) {
		this.productImageSrc = productImageSrc;
	}

	public String getProductLink() {
		return productLink;
	}

	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}

	public MultipartFile getProductImageFile() {
		return productImageFile;
	}

	public void setProductImageFile(MultipartFile productImageFile) {
		this.productImageFile = productImageFile;
	}
}