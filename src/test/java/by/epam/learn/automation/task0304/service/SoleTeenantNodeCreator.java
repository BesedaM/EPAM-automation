package by.epam.learn.automation.task0304.service;

import by.epam.learn.automation.task0304.model.ComputeEngine;
import by.epam.learn.automation.task0304.model.SoleTenantNode;

public class SoleTeenantNodeCreator {

    private static final String SOLE_TEENANT_NUMBER = "soleTenantNodes.number";
    private static final String SOLE_TEENANT_GPU_TYPE = "soleTenantNodes.gpuType";
    private static final String SOLE_TEENANT_LOCAL_SSD_NUMBER = "soleTenantNodes.localSsdNumber";
    private static final String SOLE_TEENANT_DATACENTER_LOCATION = "soleTenantNodes.datacenterLocation";
    private static final String SOLE_TEENANT_COMMITTED_USAGE_PERIOD = "soleTenantNodes.committedUsage";

    public static Integer getNumberOfSoleTeenantNodes() {
        return Integer.decode(DataReader.getData(SOLE_TEENANT_NUMBER));
    }

    public static SoleTenantNode createNode() {
        SoleTenantNode node = new SoleTenantNode();
        node.setGpuType(SoleTenantNode.GPUType.valueOf(
                DataReader.getData(SOLE_TEENANT_GPU_TYPE)));
        node.setLocalSsdNumber(SoleTenantNode.LocalSsdNumber.valueOf(
                DataReader.getData(SOLE_TEENANT_LOCAL_SSD_NUMBER)));
        node.setLocation(ComputeEngine.DatacenterLocation.valueOf(
                DataReader.getData(SOLE_TEENANT_DATACENTER_LOCATION)));
        node.setPeriod(ComputeEngine.CommittedUsagePeriod.valueOf(
                DataReader.getData(SOLE_TEENANT_COMMITTED_USAGE_PERIOD)));
        return node;
    }
}
