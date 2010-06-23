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

/**
 * Default, simple, mutable version of the {@link org.jasig.cas.server.authentication.UserNamePasswordCredential}
 * interface.  Suitable for things like Spring Binding.
 *
 * @author Scott Battaglia
 * @version $Revision$ $Date$
 * @since 3.5
 */
public class DefaultUserNamePasswordCredential implements UserNamePasswordCredential {

    private String userName;

    private String password;

    public final void setUserName(final String userName) {
        this.userName = userName;
    }

    public final void setPassword(final String password) {
        this.password = password;
    }

    public final String getUserName() {
        return userName;
    }

    public final String getPassword() {
        return password;
    }
}
