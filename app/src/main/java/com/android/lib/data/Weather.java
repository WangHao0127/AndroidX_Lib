package com.android.lib.data;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;

/**
 * Create by Allen Liu at 2019/2/19 10:58.
 */
public class Weather {
    public ObservableField<InnerWeather> data = new ObservableField<>();

    public ObservableField<InnerWeather> getData() {
        return data;
    }

    public void setData(ObservableField<InnerWeather> data) {
        this.data = data;
    }

    public static class InnerWeather {

        private ObservableArrayList<NearestWeather> weather;

        public ObservableArrayList<NearestWeather> getWeather() {
            return weather;
        }

        public void setWeather(
            ObservableArrayList<NearestWeather> weather) {
            this.weather = weather;
        }

        public static class NearestWeather {

            /**
             * date : 2018-10-26
             * info : {"dawn":["7","小雨","16","东风","微风","17:13"],"day":["1","多云","22","西北风","3-5级","06:03"],"night":["0","晴","13","西北风","5-6级","17:12"]}
             * week : 五
             * nongli : 九月十八
             */
            private ObservableField<String> data;
            private ObservableField<InfoBean> info;
            private ObservableField<String> week;
            private ObservableField<String> nongli;

            public ObservableField<String> getData() {
                return data;
            }

            public void setData(ObservableField<String> data) {
                this.data = data;
            }

            public ObservableField<InfoBean> getInfo() {
                return info;
            }

            public void setInfo(
                ObservableField<InfoBean> info) {
                this.info = info;
            }

            public ObservableField<String> getWeek() {
                return week;
            }

            public void setWeek(ObservableField<String> week) {
                this.week = week;
            }

            public ObservableField<String> getNongli() {
                return nongli;
            }

            public void setNongli(ObservableField<String> nongli) {
                this.nongli = nongli;
            }

            public static class InfoBean {
                private ObservableArrayList<String> dawn;
                private ObservableArrayList<String> day;
                private ObservableArrayList<String> night;

                public ObservableArrayList<String> getDawn() {
                    return dawn;
                }

                public void setDawn(ObservableArrayList<String> dawn) {
                    this.dawn = dawn;
                }

                public ObservableArrayList<String> getDay() {
                    return day;
                }

                public void setDay(ObservableArrayList<String> day) {
                    this.day = day;
                }

                public ObservableArrayList<String> getNight() {
                    return night;
                }

                public void setNight(ObservableArrayList<String> night) {
                    this.night = night;
                }
            }

        }
    }
}
