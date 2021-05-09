package by.epam.learn.automation.task0304.model;

import java.util.Objects;

public class Instance extends ComputeEngine {

    public enum OperatingSystem {
        FREE("free"), PAID_WINDOWS_SERVER("win"),
        PAID_LINUX("rhel"), PAID_LINUX_FOR_SAP("rhel-sap"),
        PAID_LINUX_FOR_SAP_WITH_HA("rhel-sap-ha"),
        PAID_SLES("sles"), PAID_SLES_12("sles-sap-12"),
        PAID_SLES_15("sles-sap-15"),
        PAID_SQL_SERVER_STANDARD("sql-standard"),
        PAID_SQL_SERVER_WEB("sql-web"),
        PAID_SQL_SERVER_ENTERPRISE("sql-enterprise");

        String value;

        OperatingSystem(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static OperatingSystem getByValue(String value) {
            OperatingSystem os = null;
            for (OperatingSystem element :
                    values()) {
                if (element.value.equals(value.toLowerCase())) {
                    os = element;
                    break;
                }
            }
            return os;
        }
    }

    public enum MachineClass {
        REGULAR, PREEMPTIBLE;

        public String getValue() {
            return this.name().toLowerCase();
        }
    }

    public enum MachineType {
        CUSTOM, E2_MICRO, E2_SMALL, E2_MEDIUM,
        E2_STANDARD_2, E2_STANDARD_4, E2_STANDARD_8, E2_STANDARD_16, E2_STANDARD_32,
        E2_HIGHMEM_2, E2_HIGHMEM_4, E2_HIGHMEM_8, E2_HIGHMEM_16,
        E2_HIGHCPU_2, E2_HIGHCPU_4, E2_HIGHCPU_8, E2_HIGHCPU_16, E2_HIGHCPU_32;

        public String getValue() {
            return this.name().replace('_', '-');
        }

    }

    private OperatingSystem operatingSystem;
    private MachineClass machineClass;
    private MachineType machineType;

    public Instance() {
        super();
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setMachineClass(MachineClass machineClass) {
        this.machineClass = machineClass;
    }

    public void setMachineType(MachineType machineType) {
        this.machineType = machineType;
    }

    public String getOperatingSystem() {
        return operatingSystem.getValue();
    }

    public String getMachineClass() {
        return machineClass.getValue();
    }

    public String getMachineType() {
        return machineType.getValue();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instance)) return false;
        if (!super.equals(o)) return false;
        Instance instance = (Instance) o;
        return operatingSystem == instance.operatingSystem &&
                machineClass == instance.machineClass &&
                machineType == instance.machineType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), operatingSystem, machineClass, machineType);
    }
}
