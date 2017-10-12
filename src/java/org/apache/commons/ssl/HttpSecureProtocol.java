/*
 * $HeadURL: http://juliusdavies.ca/svn/not-yet-commons-ssl/trunk/src/java/org/apache/commons/ssl/HttpSecureProtocol.java $
 * $Revision: 165 $
 * $Date: 2014-04-25 06:48:09 +0700 (Пт, 25 апр 2014) $
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package org.apache.commons.ssl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;

/**
 * Hook into HttpClient.
 *
 * @author Credit Union Central of British Columbia
 * @author <a href="http://www.cucbc.com/">www.cucbc.com</a>
 * @author <a href="mailto:juliusdavies@cucbc.com">juliusdavies@cucbc.com</a>
 * @since 5-May-2006
 */
public class HttpSecureProtocol extends SSLClient {

    public HttpSecureProtocol()
        throws GeneralSecurityException, IOException {
        super();
    }

    /**
     * Attempts to get a new socket connection to the given host within the
     * given time limit.
     * <p/>
     * To circumvent the limitations of older JREs that do not support connect
     * timeout a controller thread is executed. The controller thread attempts
     * to create a new socket within the given limit of time. If socket
     * constructor does not return until the timeout expires, the controller
     * terminates and throws an
     * {@link org.apache.commons.httpclient.ConnectTimeoutException}
     * </p>
     *
     * @param host         the host name/IP
     * @param port         the port on the host
     * @param localAddress the local host name/IP to bind the socket to
     * @param localPort    the port on the local machine
     * @return Socket a new socket
     * @throws java.io.IOException           if an I/O error occurs while creating the socket
     * @throws java.net.UnknownHostException if the IP address of the host cannot be
     *                                       determined
     */
    public Socket createSocket(final String host,
                               final int port,
                               final InetAddress localAddress,
                               final int localPort,
                               final int timeout)
        throws IOException {

        return super.createSocket(host, port, localAddress, localPort, timeout);
    }

}
