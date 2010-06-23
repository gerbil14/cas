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

package org.jasig.cas.server.authentication;

import java.util.List;

/**
 * Resolves the messages for a given credential.  These are not per principal because its more likely that a given
 * credential has warnings or messages versus a principal.  Though these should be able to still find them.
 *
 * @author Scott Battaglia
 * @version $Revision$ $Date$
 * @since 3.5
 *
 */
public interface MessageResolver {

    /**
     * Resolves messages for a given credential.  This should only execute if the authentication was successful.
     * <p>
     * GeneralSecurityExceptions should be used to relay messages when authentication failed.
     *
     * @param credential the credentials.  Cannot be null.
     * @param authenticationHandler the authentication handler.  Cannot be null.
     * @return the messages.  CANNOT be NULL.  But can be empty.
     */
    List<Message> resolveMessagesFor(Credential credential, AuthenticationHandler authenticationHandler);
}
