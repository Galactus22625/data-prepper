/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.dataprepper.core.pipeline.server;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micrometer.common.util.StringUtils;

/**
 * Configuration class for Core API HTTP Basic authentication
 *
 * @since 1.2
 */
public class HttpBasicAuthenticationConfig {
    private final String username;
    private final String password;

    @JsonCreator
    public HttpBasicAuthenticationConfig(
            @JsonProperty("username") final String username,
            @JsonProperty("password") final String password) {
        validateCredentials(username, password);
        this.username = username;
        this.password = password;
    }

    private void validateCredentials(final String username, final String password) {
        if (StringUtils.isEmpty(username)) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
