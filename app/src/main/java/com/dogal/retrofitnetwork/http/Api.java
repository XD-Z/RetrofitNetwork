package com.dogal.retrofitnetwork.http;


import com.dogal.retrofitnetwork.bean.FileBean;
import com.dogal.retrofitnetwork.bean.MeBean;
import com.dogal.retrofitnetwork.bean.WeatherBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

/**
 * @author Dogal
 * @time 2020/01/01
 */

public interface Api {

    /**
     * 京东万象 https://wx.jdcloud.com/market/api/10610
     */
    @GET("freeweather")
    Observable<WeatherBean> getWeatherData(@Query("city") String city,
                                           @Query("appkey") String appkey);

    /**
     * 京东万象 https://wx.jdcloud.com/market/api/10610
     */
    @FormUrlEncoded
    @POST("freeweather")
    Observable<WeatherBean> getWeather2Data(@Field("city") String city,
                                            @Field("appkey") String appkey);

    /**
     * 获取头像 map方式
     */
    @Multipart
    @POST("auth/myInfo")
    Observable<MeBean> getHeadPicData(@PartMap Map<String, RequestBody> map);

    /**
     * 上传数组  注意参数后面要添加[]
     */
    @FormUrlEncoded
    @POST("auth")
    Observable<MeBean> getHeadPicsData(@Field("uid") String uid,
                                       @Field("label[]") List<String> label);

    /**
     * 上传图片
     * 单张图片上传 更换头像
     */
    @Multipart
    @POST("auth/updateUserPortrait")
    Observable<FileBean> getupLoadPicData(@PartMap Map<String, RequestBody> map,
                                          @Part MultipartBody.Part file);

    /**
     * 上传图片
     * 多张图片上传
     */
    @Multipart
    @POST("auth")
    Observable<FileBean> getupLoadPicsData(@PartMap Map<String, RequestBody> map,
                                           @Part List<MultipartBody.Part> files);

}
