/*
 * Copyright © 2017 zte and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.p4plugin.driver.impl;

import java.util.List;
import org.opendaylight.yang.gen.v1.urn.ietf.interfaces.test.rev170908.InterfacesState;
import org.opendaylight.yang.gen.v1.urn.ietf.interfaces.test.rev170908.interfaces.state.Interface;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeviceInterfaceProcess {

    private static final Logger LOG = LoggerFactory.getLogger(DeviceInterfaceProcess.class);

    private NetconfDataOperator netconfDataOperator;

    public static final InstanceIdentifier<InterfacesState> INTERFACE_IID = InstanceIdentifier
            .create(InterfacesState.class);

    public DeviceInterfaceProcess(NetconfDataOperator netconfDataOperator) {
        this.netconfDataOperator = netconfDataOperator;
    }

    public void writeDeviceInterfaces(String nodeId) {
        LOG.info("Start write data");
        netconfDataOperator.write(nodeId, INTERFACE_IID);
    }

    public List<Interface> readDeviceInterfaces(String nodeId) {
        LOG.info("Start read data");
        return netconfDataOperator.read(nodeId, INTERFACE_IID);
    }
}
