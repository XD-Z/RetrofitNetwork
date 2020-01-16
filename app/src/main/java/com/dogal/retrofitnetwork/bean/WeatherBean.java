package com.dogal.retrofitnetwork.bean;

import java.util.List;

/**
 * author: Dogal
 * data: 2020/01/01
 */

public class WeatherBean {

    /**
     * code : 10000
     * charge : false
     * msg : 查询成功
     * result : {"HeWeather5":[{"aqi":{"city":{"aqi":"91","co":"1","no2":"41","o3":"40","pm10":"81","pm25":"91","qlty":"良","so2":"6"}},"basic":{"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904000","lon":"116.391000","update":{"loc":"2016-07-12 08:51","utc":"2016-07-12 00:51"}},"daily_forecast":[{"astro":{"mr":"12:38","ms":"null","sr":"04:56","ss":"19:43"},"cond":{"code_d":"302","code_n":"100","txt_d":"雷阵雨","txt_n":"晴"},"date":"2016-07-12","hum":"74","pcpn":"6.8","pop":"96","pres":"1001","tmp":{"max":"32","min":"23"},"vis":"7","wind":{"deg":"340","dir":"无持续风向","sc":"微风","spd":"8"}}],"hourly_forecast":[{"cond":{"code":"306","txt":"中雨"},"date":"2016-07-12 10:00","hum":"79","pop":"95","pres":"1001","tmp":"27","wind":{"deg":"334","dir":"西北风","sc":"微风","spd":"10"}}],"now":{"cond":{"code":"300","txt":"阵雨"},"fl":"31","hum":"70","pcpn":"0","pres":"998","tmp":"28","vis":"10","wind":{"deg":"150","dir":"南风","sc":"4-5","spd":"17"}},"status":"ok","suggestion":{"comf":{"brf":"较不舒适","txt":"白天天气较热，虽然有雨，但仍然无法削弱较高气温给人们带来的暑意，这种天气会让您感到不很舒适。"},"cw":{"brf":"不宜","txt":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},"drsg":{"brf":"炎热","txt":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"},"flu":{"brf":"少发","txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"},"sport":{"brf":"较不宜","txt":"有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"},"trav":{"brf":"一般","txt":"有降水，稍热，微风，旅游指数一般，外出请尽量避开降雨时间，若外出，请注意防雷并携带雨具。"},"uv":{"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}}}]}
     */

    private String code;
    private boolean charge;
    private String msg;
    private ResultBean result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isCharge() {
        return charge;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<HeWeather5Bean> HeWeather5;

        public List<HeWeather5Bean> getHeWeather5() {
            return HeWeather5;
        }

        public void setHeWeather5(List<HeWeather5Bean> HeWeather5) {
            this.HeWeather5 = HeWeather5;
        }

        public static class HeWeather5Bean {
            /**
             * aqi : {"city":{"aqi":"91","co":"1","no2":"41","o3":"40","pm10":"81","pm25":"91","qlty":"良","so2":"6"}}
             * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904000","lon":"116.391000","update":{"loc":"2016-07-12 08:51","utc":"2016-07-12 00:51"}}
             * daily_forecast : [{"astro":{"mr":"12:38","ms":"null","sr":"04:56","ss":"19:43"},"cond":{"code_d":"302","code_n":"100","txt_d":"雷阵雨","txt_n":"晴"},"date":"2016-07-12","hum":"74","pcpn":"6.8","pop":"96","pres":"1001","tmp":{"max":"32","min":"23"},"vis":"7","wind":{"deg":"340","dir":"无持续风向","sc":"微风","spd":"8"}}]
             * hourly_forecast : [{"cond":{"code":"306","txt":"中雨"},"date":"2016-07-12 10:00","hum":"79","pop":"95","pres":"1001","tmp":"27","wind":{"deg":"334","dir":"西北风","sc":"微风","spd":"10"}}]
             * now : {"cond":{"code":"300","txt":"阵雨"},"fl":"31","hum":"70","pcpn":"0","pres":"998","tmp":"28","vis":"10","wind":{"deg":"150","dir":"南风","sc":"4-5","spd":"17"}}
             * status : ok
             * suggestion : {"comf":{"brf":"较不舒适","txt":"白天天气较热，虽然有雨，但仍然无法削弱较高气温给人们带来的暑意，这种天气会让您感到不很舒适。"},"cw":{"brf":"不宜","txt":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},"drsg":{"brf":"炎热","txt":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"},"flu":{"brf":"少发","txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"},"sport":{"brf":"较不宜","txt":"有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"},"trav":{"brf":"一般","txt":"有降水，稍热，微风，旅游指数一般，外出请尽量避开降雨时间，若外出，请注意防雷并携带雨具。"},"uv":{"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}}
             */

            private AqiBean aqi;
            private BasicBean basic;
            private NowBean now;
            private String status;
            private SuggestionBean suggestion;
            private List<DailyForecastBean> daily_forecast;
            private List<HourlyForecastBean> hourly_forecast;

            public AqiBean getAqi() {
                return aqi;
            }

            public void setAqi(AqiBean aqi) {
                this.aqi = aqi;
            }

            public BasicBean getBasic() {
                return basic;
            }

            public void setBasic(BasicBean basic) {
                this.basic = basic;
            }

            public NowBean getNow() {
                return now;
            }

            public void setNow(NowBean now) {
                this.now = now;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public SuggestionBean getSuggestion() {
                return suggestion;
            }

            public void setSuggestion(SuggestionBean suggestion) {
                this.suggestion = suggestion;
            }

            public List<DailyForecastBean> getDaily_forecast() {
                return daily_forecast;
            }

            public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
                this.daily_forecast = daily_forecast;
            }

            public List<HourlyForecastBean> getHourly_forecast() {
                return hourly_forecast;
            }

            public void setHourly_forecast(List<HourlyForecastBean> hourly_forecast) {
                this.hourly_forecast = hourly_forecast;
            }

            public static class AqiBean {
                /**
                 * city : {"aqi":"91","co":"1","no2":"41","o3":"40","pm10":"81","pm25":"91","qlty":"良","so2":"6"}
                 */

                private CityBean city;

                public CityBean getCity() {
                    return city;
                }

                public void setCity(CityBean city) {
                    this.city = city;
                }

                public static class CityBean {
                    /**
                     * aqi : 91
                     * co : 1
                     * no2 : 41
                     * o3 : 40
                     * pm10 : 81
                     * pm25 : 91
                     * qlty : 良
                     * so2 : 6
                     */

                    private String aqi;
                    private String co;
                    private String no2;
                    private String o3;
                    private String pm10;
                    private String pm25;
                    private String qlty;
                    private String so2;

                    public String getAqi() {
                        return aqi;
                    }

                    public void setAqi(String aqi) {
                        this.aqi = aqi;
                    }

                    public String getCo() {
                        return co;
                    }

                    public void setCo(String co) {
                        this.co = co;
                    }

                    public String getNo2() {
                        return no2;
                    }

                    public void setNo2(String no2) {
                        this.no2 = no2;
                    }

                    public String getO3() {
                        return o3;
                    }

                    public void setO3(String o3) {
                        this.o3 = o3;
                    }

                    public String getPm10() {
                        return pm10;
                    }

                    public void setPm10(String pm10) {
                        this.pm10 = pm10;
                    }

                    public String getPm25() {
                        return pm25;
                    }

                    public void setPm25(String pm25) {
                        this.pm25 = pm25;
                    }

                    public String getQlty() {
                        return qlty;
                    }

                    public void setQlty(String qlty) {
                        this.qlty = qlty;
                    }

                    public String getSo2() {
                        return so2;
                    }

                    public void setSo2(String so2) {
                        this.so2 = so2;
                    }
                }
            }

            public static class BasicBean {
                /**
                 * city : 北京
                 * cnty : 中国
                 * id : CN101010100
                 * lat : 39.904000
                 * lon : 116.391000
                 * update : {"loc":"2016-07-12 08:51","utc":"2016-07-12 00:51"}
                 */

                private String city;
                private String cnty;
                private String id;
                private String lat;
                private String lon;
                private UpdateBean update;

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getCnty() {
                    return cnty;
                }

                public void setCnty(String cnty) {
                    this.cnty = cnty;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getLat() {
                    return lat;
                }

                public void setLat(String lat) {
                    this.lat = lat;
                }

                public String getLon() {
                    return lon;
                }

                public void setLon(String lon) {
                    this.lon = lon;
                }

                public UpdateBean getUpdate() {
                    return update;
                }

                public void setUpdate(UpdateBean update) {
                    this.update = update;
                }

                public static class UpdateBean {
                    /**
                     * loc : 2016-07-12 08:51
                     * utc : 2016-07-12 00:51
                     */

                    private String loc;
                    private String utc;

                    public String getLoc() {
                        return loc;
                    }

                    public void setLoc(String loc) {
                        this.loc = loc;
                    }

                    public String getUtc() {
                        return utc;
                    }

                    public void setUtc(String utc) {
                        this.utc = utc;
                    }
                }
            }

            public static class NowBean {
                /**
                 * cond : {"code":"300","txt":"阵雨"}
                 * fl : 31
                 * hum : 70
                 * pcpn : 0
                 * pres : 998
                 * tmp : 28
                 * vis : 10
                 * wind : {"deg":"150","dir":"南风","sc":"4-5","spd":"17"}
                 */

                private CondBean cond;
                private String fl;
                private String hum;
                private String pcpn;
                private String pres;
                private String tmp;
                private String vis;
                private WindBean wind;

                public CondBean getCond() {
                    return cond;
                }

                public void setCond(CondBean cond) {
                    this.cond = cond;
                }

                public String getFl() {
                    return fl;
                }

                public void setFl(String fl) {
                    this.fl = fl;
                }

                public String getHum() {
                    return hum;
                }

                public void setHum(String hum) {
                    this.hum = hum;
                }

                public String getPcpn() {
                    return pcpn;
                }

                public void setPcpn(String pcpn) {
                    this.pcpn = pcpn;
                }

                public String getPres() {
                    return pres;
                }

                public void setPres(String pres) {
                    this.pres = pres;
                }

                public String getTmp() {
                    return tmp;
                }

                public void setTmp(String tmp) {
                    this.tmp = tmp;
                }

                public String getVis() {
                    return vis;
                }

                public void setVis(String vis) {
                    this.vis = vis;
                }

                public WindBean getWind() {
                    return wind;
                }

                public void setWind(WindBean wind) {
                    this.wind = wind;
                }

                public static class CondBean {
                    /**
                     * code : 300
                     * txt : 阵雨
                     */

                    private String code;
                    private String txt;

                    public String getCode() {
                        return code;
                    }

                    public void setCode(String code) {
                        this.code = code;
                    }

                    public String getTxt() {
                        return txt;
                    }

                    public void setTxt(String txt) {
                        this.txt = txt;
                    }
                }

                public static class WindBean {
                    /**
                     * deg : 150
                     * dir : 南风
                     * sc : 4-5
                     * spd : 17
                     */

                    private String deg;
                    private String dir;
                    private String sc;
                    private String spd;

                    public String getDeg() {
                        return deg;
                    }

                    public void setDeg(String deg) {
                        this.deg = deg;
                    }

                    public String getDir() {
                        return dir;
                    }

                    public void setDir(String dir) {
                        this.dir = dir;
                    }

                    public String getSc() {
                        return sc;
                    }

                    public void setSc(String sc) {
                        this.sc = sc;
                    }

                    public String getSpd() {
                        return spd;
                    }

                    public void setSpd(String spd) {
                        this.spd = spd;
                    }
                }
            }

            public static class SuggestionBean {
                /**
                 * comf : {"brf":"较不舒适","txt":"白天天气较热，虽然有雨，但仍然无法削弱较高气温给人们带来的暑意，这种天气会让您感到不很舒适。"}
                 * cw : {"brf":"不宜","txt":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"}
                 * drsg : {"brf":"炎热","txt":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"}
                 * flu : {"brf":"少发","txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"}
                 * sport : {"brf":"较不宜","txt":"有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"}
                 * trav : {"brf":"一般","txt":"有降水，稍热，微风，旅游指数一般，外出请尽量避开降雨时间，若外出，请注意防雷并携带雨具。"}
                 * uv : {"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}
                 */

                private ComfBean comf;
                private CwBean cw;
                private DrsgBean drsg;
                private FluBean flu;
                private SportBean sport;
                private TravBean trav;
                private UvBean uv;

                public ComfBean getComf() {
                    return comf;
                }

                public void setComf(ComfBean comf) {
                    this.comf = comf;
                }

                public CwBean getCw() {
                    return cw;
                }

                public void setCw(CwBean cw) {
                    this.cw = cw;
                }

                public DrsgBean getDrsg() {
                    return drsg;
                }

                public void setDrsg(DrsgBean drsg) {
                    this.drsg = drsg;
                }

                public FluBean getFlu() {
                    return flu;
                }

                public void setFlu(FluBean flu) {
                    this.flu = flu;
                }

                public SportBean getSport() {
                    return sport;
                }

                public void setSport(SportBean sport) {
                    this.sport = sport;
                }

                public TravBean getTrav() {
                    return trav;
                }

                public void setTrav(TravBean trav) {
                    this.trav = trav;
                }

                public UvBean getUv() {
                    return uv;
                }

                public void setUv(UvBean uv) {
                    this.uv = uv;
                }

                public static class ComfBean {
                    /**
                     * brf : 较不舒适
                     * txt : 白天天气较热，虽然有雨，但仍然无法削弱较高气温给人们带来的暑意，这种天气会让您感到不很舒适。
                     */

                    private String brf;
                    private String txt;

                    public String getBrf() {
                        return brf;
                    }

                    public void setBrf(String brf) {
                        this.brf = brf;
                    }

                    public String getTxt() {
                        return txt;
                    }

                    public void setTxt(String txt) {
                        this.txt = txt;
                    }
                }

                public static class CwBean {
                    /**
                     * brf : 不宜
                     * txt : 不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。
                     */

                    private String brf;
                    private String txt;

                    public String getBrf() {
                        return brf;
                    }

                    public void setBrf(String brf) {
                        this.brf = brf;
                    }

                    public String getTxt() {
                        return txt;
                    }

                    public void setTxt(String txt) {
                        this.txt = txt;
                    }
                }

                public static class DrsgBean {
                    /**
                     * brf : 炎热
                     * txt : 天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。
                     */

                    private String brf;
                    private String txt;

                    public String getBrf() {
                        return brf;
                    }

                    public void setBrf(String brf) {
                        this.brf = brf;
                    }

                    public String getTxt() {
                        return txt;
                    }

                    public void setTxt(String txt) {
                        this.txt = txt;
                    }
                }

                public static class FluBean {
                    /**
                     * brf : 少发
                     * txt : 各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。
                     */

                    private String brf;
                    private String txt;

                    public String getBrf() {
                        return brf;
                    }

                    public void setBrf(String brf) {
                        this.brf = brf;
                    }

                    public String getTxt() {
                        return txt;
                    }

                    public void setTxt(String txt) {
                        this.txt = txt;
                    }
                }

                public static class SportBean {
                    /**
                     * brf : 较不宜
                     * txt : 有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。
                     */

                    private String brf;
                    private String txt;

                    public String getBrf() {
                        return brf;
                    }

                    public void setBrf(String brf) {
                        this.brf = brf;
                    }

                    public String getTxt() {
                        return txt;
                    }

                    public void setTxt(String txt) {
                        this.txt = txt;
                    }
                }

                public static class TravBean {
                    /**
                     * brf : 一般
                     * txt : 有降水，稍热，微风，旅游指数一般，外出请尽量避开降雨时间，若外出，请注意防雷并携带雨具。
                     */

                    private String brf;
                    private String txt;

                    public String getBrf() {
                        return brf;
                    }

                    public void setBrf(String brf) {
                        this.brf = brf;
                    }

                    public String getTxt() {
                        return txt;
                    }

                    public void setTxt(String txt) {
                        this.txt = txt;
                    }
                }

                public static class UvBean {
                    /**
                     * brf : 中等
                     * txt : 属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。
                     */

                    private String brf;
                    private String txt;

                    public String getBrf() {
                        return brf;
                    }

                    public void setBrf(String brf) {
                        this.brf = brf;
                    }

                    public String getTxt() {
                        return txt;
                    }

                    public void setTxt(String txt) {
                        this.txt = txt;
                    }
                }
            }

            public static class DailyForecastBean {
                /**
                 * astro : {"mr":"12:38","ms":"null","sr":"04:56","ss":"19:43"}
                 * cond : {"code_d":"302","code_n":"100","txt_d":"雷阵雨","txt_n":"晴"}
                 * date : 2016-07-12
                 * hum : 74
                 * pcpn : 6.8
                 * pop : 96
                 * pres : 1001
                 * tmp : {"max":"32","min":"23"}
                 * vis : 7
                 * wind : {"deg":"340","dir":"无持续风向","sc":"微风","spd":"8"}
                 */

                private AstroBean astro;
                private CondBeanX cond;
                private String date;
                private String hum;
                private String pcpn;
                private String pop;
                private String pres;
                private TmpBean tmp;
                private String vis;
                private WindBeanX wind;

                public AstroBean getAstro() {
                    return astro;
                }

                public void setAstro(AstroBean astro) {
                    this.astro = astro;
                }

                public CondBeanX getCond() {
                    return cond;
                }

                public void setCond(CondBeanX cond) {
                    this.cond = cond;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getHum() {
                    return hum;
                }

                public void setHum(String hum) {
                    this.hum = hum;
                }

                public String getPcpn() {
                    return pcpn;
                }

                public void setPcpn(String pcpn) {
                    this.pcpn = pcpn;
                }

                public String getPop() {
                    return pop;
                }

                public void setPop(String pop) {
                    this.pop = pop;
                }

                public String getPres() {
                    return pres;
                }

                public void setPres(String pres) {
                    this.pres = pres;
                }

                public TmpBean getTmp() {
                    return tmp;
                }

                public void setTmp(TmpBean tmp) {
                    this.tmp = tmp;
                }

                public String getVis() {
                    return vis;
                }

                public void setVis(String vis) {
                    this.vis = vis;
                }

                public WindBeanX getWind() {
                    return wind;
                }

                public void setWind(WindBeanX wind) {
                    this.wind = wind;
                }

                public static class AstroBean {
                    /**
                     * mr : 12:38
                     * ms : null
                     * sr : 04:56
                     * ss : 19:43
                     */

                    private String mr;
                    private String ms;
                    private String sr;
                    private String ss;

                    public String getMr() {
                        return mr;
                    }

                    public void setMr(String mr) {
                        this.mr = mr;
                    }

                    public String getMs() {
                        return ms;
                    }

                    public void setMs(String ms) {
                        this.ms = ms;
                    }

                    public String getSr() {
                        return sr;
                    }

                    public void setSr(String sr) {
                        this.sr = sr;
                    }

                    public String getSs() {
                        return ss;
                    }

                    public void setSs(String ss) {
                        this.ss = ss;
                    }
                }

                public static class CondBeanX {
                    /**
                     * code_d : 302
                     * code_n : 100
                     * txt_d : 雷阵雨
                     * txt_n : 晴
                     */

                    private String code_d;
                    private String code_n;
                    private String txt_d;
                    private String txt_n;

                    public String getCode_d() {
                        return code_d;
                    }

                    public void setCode_d(String code_d) {
                        this.code_d = code_d;
                    }

                    public String getCode_n() {
                        return code_n;
                    }

                    public void setCode_n(String code_n) {
                        this.code_n = code_n;
                    }

                    public String getTxt_d() {
                        return txt_d;
                    }

                    public void setTxt_d(String txt_d) {
                        this.txt_d = txt_d;
                    }

                    public String getTxt_n() {
                        return txt_n;
                    }

                    public void setTxt_n(String txt_n) {
                        this.txt_n = txt_n;
                    }
                }

                public static class TmpBean {
                    /**
                     * max : 32
                     * min : 23
                     */

                    private String max;
                    private String min;

                    public String getMax() {
                        return max;
                    }

                    public void setMax(String max) {
                        this.max = max;
                    }

                    public String getMin() {
                        return min;
                    }

                    public void setMin(String min) {
                        this.min = min;
                    }
                }

                public static class WindBeanX {
                    /**
                     * deg : 340
                     * dir : 无持续风向
                     * sc : 微风
                     * spd : 8
                     */

                    private String deg;
                    private String dir;
                    private String sc;
                    private String spd;

                    public String getDeg() {
                        return deg;
                    }

                    public void setDeg(String deg) {
                        this.deg = deg;
                    }

                    public String getDir() {
                        return dir;
                    }

                    public void setDir(String dir) {
                        this.dir = dir;
                    }

                    public String getSc() {
                        return sc;
                    }

                    public void setSc(String sc) {
                        this.sc = sc;
                    }

                    public String getSpd() {
                        return spd;
                    }

                    public void setSpd(String spd) {
                        this.spd = spd;
                    }
                }
            }

            public static class HourlyForecastBean {
                /**
                 * cond : {"code":"306","txt":"中雨"}
                 * date : 2016-07-12 10:00
                 * hum : 79
                 * pop : 95
                 * pres : 1001
                 * tmp : 27
                 * wind : {"deg":"334","dir":"西北风","sc":"微风","spd":"10"}
                 */

                private CondBeanXX cond;
                private String date;
                private String hum;
                private String pop;
                private String pres;
                private String tmp;
                private WindBeanXX wind;

                public CondBeanXX getCond() {
                    return cond;
                }

                public void setCond(CondBeanXX cond) {
                    this.cond = cond;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getHum() {
                    return hum;
                }

                public void setHum(String hum) {
                    this.hum = hum;
                }

                public String getPop() {
                    return pop;
                }

                public void setPop(String pop) {
                    this.pop = pop;
                }

                public String getPres() {
                    return pres;
                }

                public void setPres(String pres) {
                    this.pres = pres;
                }

                public String getTmp() {
                    return tmp;
                }

                public void setTmp(String tmp) {
                    this.tmp = tmp;
                }

                public WindBeanXX getWind() {
                    return wind;
                }

                public void setWind(WindBeanXX wind) {
                    this.wind = wind;
                }

                public static class CondBeanXX {
                    /**
                     * code : 306
                     * txt : 中雨
                     */

                    private String code;
                    private String txt;

                    public String getCode() {
                        return code;
                    }

                    public void setCode(String code) {
                        this.code = code;
                    }

                    public String getTxt() {
                        return txt;
                    }

                    public void setTxt(String txt) {
                        this.txt = txt;
                    }
                }

                public static class WindBeanXX {
                    /**
                     * deg : 334
                     * dir : 西北风
                     * sc : 微风
                     * spd : 10
                     */

                    private String deg;
                    private String dir;
                    private String sc;
                    private String spd;

                    public String getDeg() {
                        return deg;
                    }

                    public void setDeg(String deg) {
                        this.deg = deg;
                    }

                    public String getDir() {
                        return dir;
                    }

                    public void setDir(String dir) {
                        this.dir = dir;
                    }

                    public String getSc() {
                        return sc;
                    }

                    public void setSc(String sc) {
                        this.sc = sc;
                    }

                    public String getSpd() {
                        return spd;
                    }

                    public void setSpd(String spd) {
                        this.spd = spd;
                    }
                }
            }
        }
    }
}
