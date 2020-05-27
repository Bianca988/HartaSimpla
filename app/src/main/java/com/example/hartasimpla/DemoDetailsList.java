package com.example.hartasimpla;
public final class DemoDetailsList {


        /**
         * This class should not be instantiated.
         */

        private DemoDetailsList() {

        }


        public static final DemoDetails[] DEMOS = {

                new DemoDetails(R.string.basic_map_demo_label,

                        R.string.basic_map_demo_description,

                        MainActivity.class)
        };
    }
