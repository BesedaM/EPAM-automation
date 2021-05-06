package by.epam.learn.automation.task0304.model;

import java.util.Objects;

public abstract class ComputeNode {

    public enum CommittedUsagePeriod {
        NONE(0), ONE_YEAR(1), THREE_YEARS(3);

        int value;

        CommittedUsagePeriod(int value) {
            this.value = value;
        }

        public int getPeriod() {
            return this.value;
        }
    }

    public enum DatacenterLocation {
        IOWA("us-central1"), SOUTH_CAROLINA("us-east1"), NORTHERN_VIRGINIA("us-east4"),
        OREGON("us-west1"), LOS_ANGELES("us-west2"), SALT_LAKE_CITY("us-west3"),
        LAS_VEGAS("us-west4"), BELGIUM("europe-west1"), LONDON("europe-west2"),
        FRANKFURT("europe-west3"), WARSAW("europe-central2"), TAIWAN("asia-east1"),
        HONG_KONG("asia-east2"), TOKYO("asia-northeast1"), OSAKA("asia-northeast2"),
        SEOUL("asia-northeast3"), SINGAPORE("asia-southeast1"), JAKARTA("asia-southeast2"),
        MUMBAI("asia-south1"), SYDNEY("australia-southeast1"), SAO_PAOLO("southamerica-east1"),
        NETHERLANDS("europe-west4"), ZURICH("europe-west6"), FINLAND("europe-north1"),
        MONTREAL("northamerica-northeast1");

        String value;

        DatacenterLocation(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }


    private CommittedUsagePeriod period;
    private DatacenterLocation location;

    public ComputeNode() {
    }

    public void setPeriod(CommittedUsagePeriod period) {
        this.period = period;
    }

    public void setLocation(DatacenterLocation location) {
        this.location = location;
    }

    public int getPeriod() {
        return period.getPeriod();
    }

    public String getLocation() {
        return location.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComputeNode)) return false;
        ComputeNode that = (ComputeNode) o;
        return period == that.period &&
                location == that.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(period, location);
    }
}
