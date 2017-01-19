package com.mphasis.pfizerappDoctor.model;

import java.util.List;

/**
 * Created by Sourav.Bhattacharya on 1/18/2017.
 */

public class DoctorListModel {

    private List<DoctorsBean> doctors;

    public List<DoctorsBean> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<DoctorsBean> doctors) {
        this.doctors = doctors;
    }

    public static class DoctorsBean {
        /**
         * name : 1R9kRRKZtSfVu4k8YSwJAFuAemgc1LexuQ9kDF
         * address : Dr. Mike Powell
         */

        private String name;
        private String address;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
