package by.epam.learn.automation.task0304.service;

import by.epam.learn.automation.task0304.model.ComputeEngine;
import by.epam.learn.automation.task0304.model.Instance;

public class InstanceCreator {

    private static final String INSTANCES_NUMBER = "instances.number";
    private static final String INSTANCE_MACHINE_CLASS = "instances.virtualMachineClass";
    private static final String INSTANCE_MACHINE_TYPE = "instances.type";
    private static final String INSTANCE_OPERATING_SYSTEM = "instances.operatingSystem";
    private static final String INSTANCE_DATACENTER_LOCATION = "instances.datacenterLocation";
    private static final String INSTANCE_COMMITTED_USAGE_PERIOD = "instances.committedUsage";


    public static Integer getNumberOfInstances() {
        return Integer.decode(DataReader.getData(INSTANCES_NUMBER));
    }

    public static Instance createInstance() {
        Instance instance = new Instance();
        instance.setMachineClass(Instance.MachineClass.valueOf(
                DataReader.getData(INSTANCE_MACHINE_CLASS)));
        instance.setMachineType(Instance.MachineType.valueOf(
                DataReader.getData(INSTANCE_MACHINE_TYPE)));
        instance.setOperatingSystem(Instance.OperatingSystem.getByValue(
                DataReader.getData(INSTANCE_OPERATING_SYSTEM)));
        instance.setLocation(ComputeEngine.DatacenterLocation.valueOf(
                DataReader.getData(INSTANCE_DATACENTER_LOCATION)));
        instance.setPeriod(ComputeEngine.CommittedUsagePeriod.valueOf(
                DataReader.getData(INSTANCE_COMMITTED_USAGE_PERIOD)));
        return instance;
    }
}
