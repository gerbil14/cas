/**
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.jasig.cas.support.spnego.authentication.principal;

import java.util.Locale;

import org.jasig.cas.server.authentication.AbstractAttributePrincipalFactoryCredentialsToPrincipalResolver;
import org.jasig.cas.server.authentication.AttributePrincipalFactory;
import org.jasig.cas.server.authentication.Credential;

import javax.validation.constraints.NotNull;

/**
 * Implementation of a CredentialToPrincipalResolver that takes a
 * SpnegoCredentials and returns a SimplePrincipal.
 * 
 * @author Arnaud Lesueur
 * @author Marc-Antoine Garrigue
 * @version $Revision$ $Date: 2007-06-11 11:59:18 -0400 (Mon, 11 Jun
 * 2007) $
 * @since 3.1
 */
public final class SpnegoCredentialsToPrincipalResolver extends AbstractAttributePrincipalFactoryCredentialsToPrincipalResolver {

    public static enum Transform {NONE, UPPERCASE, LOWERCASE}
    
    @NotNull
    private Transform transformPrincipalId = Transform.NONE; 

    public SpnegoCredentialsToPrincipalResolver(final AttributePrincipalFactory attributePrincipalFactory) {
        super(attributePrincipalFactory, SpnegoCredentials.class);
    }

    protected String extractPrincipalId(final Credential credentials) {
        final SpnegoCredentials c = (SpnegoCredentials) credentials;
        
        switch (this.transformPrincipalId) {
            case UPPERCASE:
                return c.getPrincipal().getName().toUpperCase(Locale.ENGLISH);
            case LOWERCASE:
                return c.getPrincipal().getName().toLowerCase(Locale.ENGLISH);
            default:
                return c.getPrincipal().getName();
        }
    }
    
    public void setTransformPrincipalId(final Transform transform) {
        this.transformPrincipalId = transform;
    }
}
