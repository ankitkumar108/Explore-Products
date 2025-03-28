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
package com.hcl.explore.products.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.explore.products.model.User;

/**
 * Repository class for <code>User</code> domain objects All method names are compliant
 * with Spring Data naming conventions so this interface can easily be extended for Spring
 * Data. See:<br>
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
 *
 * @author Indian Bittu
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	/**
	 * Retrieve a {@link User} from the data store by username.
	 * @param username the username to search for
	 * @return the {@link User} if found
	 */
    User findByUsername(String username);

    /**
     * Retrieve a {@link User} from the data store by email.
     * @param email the email to search for
     * @return the {@link User} if found
     */
    User findByEmail(String email);
}
