package com.dogal.retrofitnetwork.bean;

/**
 * author: Dogal
 * data: 2020/01/01
 */

public class MeBean {

    /**
     * status : 0
     * msg : ok
     * data : {"id":"3","username":"就是这么6","state1":"0","type1":"1","pic_portrait":"http://qiniu.searchauto.net/user_portrait/201908201733876135.jpg","authentication":"3","business_id":"3","business_name":"汽贸3","business_pic_head":"http://qiniu.searchauto.net/business_renzheng/201908051718997702.jpg"}
     */

    private int status;
    private String msg;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 3
         * username : 就是这么6
         * state1 : 0
         * type1 : 1
         * pic_portrait : http://qiniu.searchauto.net/user_portrait/201908201733876135.jpg
         * authentication : 3
         * business_id : 3
         * business_name : 汽贸3
         * business_pic_head : http://qiniu.searchauto.net/business_renzheng/201908051718997702.jpg
         */

        private String id;
        private String username;
        private String state1;
        private String type1;
        private String level;
        private String pic_portrait;
        private String authentication;
        private String business_id;
        private String business_type;
        private String business_name;
        private String business_pic_head;

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getBusiness_type() {
            return business_type;
        }

        public void setBusiness_type(String business_type) {
            this.business_type = business_type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getState1() {
            return state1;
        }

        public void setState1(String state1) {
            this.state1 = state1;
        }

        public String getType1() {
            return type1;
        }

        public void setType1(String type1) {
            this.type1 = type1;
        }

        public String getPic_portrait() {
            return pic_portrait;
        }

        public void setPic_portrait(String pic_portrait) {
            this.pic_portrait = pic_portrait;
        }

        public String getAuthentication() {
            return authentication;
        }

        public void setAuthentication(String authentication) {
            this.authentication = authentication;
        }

        public String getBusiness_id() {
            return business_id;
        }

        public void setBusiness_id(String business_id) {
            this.business_id = business_id;
        }

        public String getBusiness_name() {
            return business_name;
        }

        public void setBusiness_name(String business_name) {
            this.business_name = business_name;
        }

        public String getBusiness_pic_head() {
            return business_pic_head;
        }

        public void setBusiness_pic_head(String business_pic_head) {
            this.business_pic_head = business_pic_head;
        }
    }
}
