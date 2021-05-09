package by.epam.learn.automation.task0304.model;

import java.util.Objects;

public class SoleTenantNode extends ComputeEngine {

    public enum GPUType {
        NVIDIA_TESLA_P100(4),
        NVIDIA_TESLA_P4(4),
        NVIDIA_TESLA_V100(8),
        NVIDIA_TESLA_T4(4);

        int maxNumberOfGPUForNode;

        GPUType(int maxNumberOfGPUForNode) {
            this.maxNumberOfGPUForNode = maxNumberOfGPUForNode;
        }

        public int getMaxNumberOfGPUForNode() {
            return maxNumberOfGPUForNode;
        }
    }

    public enum LocalSsdNumber {
        ZERO("0"), MAX_NUMBER("24");

        String size;

        LocalSsdNumber(String size) {
            this.size = size;
        }

        public String getNumber() {
            return size;
        }
    }

    private GPUType gpuType;
    private LocalSsdNumber localSsdNumber;

    public SoleTenantNode() {
        super();
    }

    public void setGpuType(GPUType gpuType) {
        this.gpuType = gpuType;
    }

    public void setLocalSsdNumber(LocalSsdNumber localSsdNumber) {
        this.localSsdNumber = localSsdNumber;
    }

    public String getGpuTypeLastName() {
        return gpuType.name();
    }

    public int getMaxNumberOfGPUForNode() {
        return gpuType.getMaxNumberOfGPUForNode();
    }

    public String getLocalSsdNumber() {
        return localSsdNumber.getNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SoleTenantNode)) return false;
        if (!super.equals(o)) return false;
        SoleTenantNode that = (SoleTenantNode) o;
        return gpuType == that.gpuType &&
                localSsdNumber == that.localSsdNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gpuType, localSsdNumber);
    }
}
