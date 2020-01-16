package com.dogal.retrofitnetwork.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.allen.library.SuperTextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dogal.retrofitnetwork.R;
import com.dogal.retrofitnetwork.base.BaseActivity;
import com.dogal.retrofitnetwork.bean.FileBean;
import com.dogal.retrofitnetwork.bean.MeBean;
import com.dogal.retrofitnetwork.bean.WeatherBean;
import com.dogal.retrofitnetwork.common.Constant;
import com.dogal.retrofitnetwork.dialog.CustomProgressDialog;
import com.dogal.retrofitnetwork.http.Api;
import com.dogal.retrofitnetwork.http.HttpManager;
import com.dogal.retrofitnetwork.utils.FullyGridLayoutManager;
import com.dogal.retrofitnetwork.utils.GlideEngine;
import com.dogal.retrofitnetwork.utils.MyToast;
import com.dogal.retrofitnetwork.view.adapter.GridImageAdapter;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.decoration.GridSpacingItemDecoration;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.language.LanguageConfig;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.ScreenUtils;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.enums.PopupAnimation;
import com.lxj.xpopup.interfaces.OnConfirmListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @author Dogal
 * @time 2020/01/01
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {

    /**
     * 请求天气数据
     */
    private SuperTextView mWeatherBtnOne;
    private SuperTextView mWeatherBtn1;
    private SuperTextView mWeatherBtn2;
    private SuperTextView mWeatherBtn3;
    private SuperTextView mWeatherBtn4;
    private SuperTextView mWeatherBtn5;
    private ImageView mHeadPic;

    //头像
    private List<LocalMedia> selectList = new ArrayList<>();
    private String headLocation;
    private File file;

    //多图
    private List<LocalMedia> selectLists = new ArrayList<>();
    private ArrayList<String> morePicLists = new ArrayList<>();
    private List<MultipartBody.Part> mFilesPart = new ArrayList<>();

    private GridImageAdapter mAdapter;

    private String uid;//测试用，谨慎操作
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitleName("RetrofitNetwork");
        initView();
        initData(savedInstanceState);
    }

    private void initData(Bundle savedInstanceState) {
        uid = "13";
        GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {
            @Override
            public void onAddPicClick() {
                // 进入相册 以下是例子：不需要的api以不写
                PictureSelector.create(mActivity)
                        .openGallery(PictureMimeType.ofImage())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                        .loadImageEngine(GlideEngine.createGlideEngine())// 外部传入图片加载引擎，必传项
                        .theme(R.style.picture_default_style)// 主题样式设置 具体参考 values/styles   用法：R.style.picture.white.style v2.3.3后 建议使用setPictureStyle()动态方式
                        .isWeChatStyle(false)// 是否开启微信图片选择风格
                        .isUseCustomCamera(false)// 是否使用自定义相机
                        .setLanguage(LanguageConfig.CHINESE)// 设置语言，默认中文
                        .isWithVideoImage(true)// 图片和视频是否以同选,只在ofAll模式下有效
                        .maxSelectNum(Constant.PIC_CHOOSE_MAX_NUM)// 最大图片选择数量
                        .minSelectNum(Constant.PIC_CHOOSE_MIN_NUM)// 最小选择数量
                        .maxVideoSelectNum(2) // 视频最大选择数量，如果没有单独设置的需求则以不设置，同用maxSelectNum字段
                        //.minVideoSelectNum(1)// 视频最小选择数量，如果没有单独设置的需求则以不设置，同用minSelectNum字段
                        .imageSpanCount(4)// 每行显示个数
                        .isReturnEmpty(false)// 未选择数据时点击按钮是否以返回
                        //.isAndroidQTransform(false)// 是否需要处理Android Q 拷贝至应用沙盒的操作，只针对compress(false); && enableCrop(false);有效,默认处理
                        .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)// 设置相册Activity方向，不设置默认使用系统
                        .isOriginalImageControl(false)// 是否显示原图控制按钮，如果设置为true则用户以自由选择是否使用原图，压缩、裁剪功能将会失效
                        //.bindCustomPlayVideoCallback(callback)// 自定义视频播放回调控制，用户以使用自己的视频播放界面
                        //.cameraFileName(System.currentTimeMillis() +".jpg")    // 重命名拍照文件名、如果是相册拍照则内部会自动拼上当前时间戳防止重复，注意这个只在使用相机时以使用，如果使用相机又开启了压缩或裁剪 需要配合压缩和裁剪文件名api
                        //.renameCompressFile(System.currentTimeMillis() +".jpg")// 重命名压缩文件名、 注意这个不要重复，只适用于单张图压缩使用
                        //.renameCropFileName(System.currentTimeMillis() + ".jpg")// 重命名裁剪文件名、 注意这个不要重复，只适用于单张图裁剪使用
                        .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选
                        .isSingleDirectReturn(false)// 单选模式下是否直接返回，PictureConfig.SINGLE模式下有效
                        .previewImage(true)// 是否预览图片
                        .previewVideo(false)// 是否预览视频
                        //.querySpecifiedFormatSuffix(PictureMimeType.ofJPEG())// 查询指定后缀格式资源
                        .enablePreviewAudio(false) // 是否播放音频
                        .isCamera(true)// 是否显示拍照按钮
                        //.isMultipleSkipCrop(false)// 多图裁剪时是否支持跳过，默认支持
                        //.isMultipleRecyclerAnimation(false)// 多图裁剪底部列表显示动画效果
                        .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                        //.imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                        .enableCrop(false)// 是否裁剪
                        //.basicUCropConfig()//对外提供所有UCropOptions参数配制，但如果PictureSelector原本支持设置的还是会使用原有的设置
                        .compress(true)// 是否压缩
                        //.compressQuality(80)// 图片压缩后输出质量 0~ 100
                        .synOrAsy(true)//同步true或异步false 压缩 默认同步
                        //.queryMaxFileSize(10)// 只查多少M以内的图片、视频、音频  单位M
                        //.compressSavePath(getPath())//压缩图片保存地址
                        //.sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效 注：已废弃
                        //.glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度 注：已废弃
                        .withAspectRatio(1, 1)// 裁剪比例 如16:9 3:2 3:4 1:1 自定义
                        .hideBottomControls(false)// 是否显示uCrop工具栏，默认不显示
                        .isGif(false)// 是否显示gif图片
                        .freeStyleCropEnabled(false)// 裁剪框是否拖拽
                        .circleDimmedLayer(false)// 是否圆形裁剪
                        //.setCircleDimmedColor(ContextCompat.getColor(getContext(), R.color.app_color_white))// 设置圆形裁剪背景色值
                        //.setCircleDimmedBorderColor(ContextCompat.getColor(getApplicationContext(), R.color.app_color_white))// 设置圆形裁剪边框色值
                        //.setCircleStrokeWidth(3)// 设置圆形裁剪边框粗细
                        .showCropFrame(false)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false
                        .showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false
                        .openClickSound(false)// 是否开启点击声音
                        .selectionMedia(mAdapter.getData())// 是否传入已选图片
                        //.isDragFrame(false)// 是否拖动裁剪框(固定)
                        //.videoMinSecond(10)
                        //.videoMaxSecond(15)
                        //.recordVideoSecond(10)//录制视频秒数 默认60s
                        //.previewEggs(false)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即看到上一张是否选中)
                        //.cropCompressQuality(90)// 注：已废弃 改用cutOutQuality()
                        .cutOutQuality(90)// 裁剪输出质量 默认100
                        .minimumCompressSize(100)// 小于100kb的图片不压缩
                        //.cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效
                        //.rotateEnabled(true) // 裁剪是否旋转图片
                        //.scaleEnabled(true)// 裁剪是否放大缩小图片
                        //.videoQuality()// 视频录制质量 0 or 1
                        //.videoSecond()//显示多少秒以内的视频or音频也适用
                        //.setOutputCameraPath("/CustomPath")// 自定义拍照保存路径  注：已废弃
                        .forResult(PictureConfig.MULTIPLE);//结果回调onActivityResult code
            }
        };
        FullyGridLayoutManager manager = new FullyGridLayoutManager(this,
                4, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(4,
                ScreenUtils.dip2px(this, 8), false));
        mAdapter = new GridImageAdapter(mContext, onAddPicClickListener);
        if (savedInstanceState != null && savedInstanceState.getParcelableArrayList("selectorList") != null) {
            mAdapter.setList(savedInstanceState.getParcelableArrayList("selectorList"));
        }
        mAdapter.setSelectMax(Constant.PIC_CHOOSE_MAX_NUM);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void success(MeBean dataBean) {
        if (dataBean.getStatus() == 0) {
            //TODO  网络请求成功后的操作
            //设置图片圆形显示
            RequestOptions options = new RequestOptions()
                    .circleCrop();
            //TODO 不设置圆形显示 去掉所有的options配置
            Glide.with(mContext)
                    .load(dataBean.getData().getPic_portrait())
                    .apply(options)
                    .into(mHeadPic);
        }
    }

    private void initView() {
        mWeatherBtnOne = (SuperTextView) findViewById(R.id.weather_btn_one);
        mWeatherBtnOne.setOnClickListener(this);
        mWeatherBtn1 = (SuperTextView) findViewById(R.id.weather_btn11);
        mWeatherBtn1.setOnClickListener(this);
        mWeatherBtn2 = (SuperTextView) findViewById(R.id.weather_btn2);
        mWeatherBtn2.setOnClickListener(this);
        mWeatherBtn3 = (SuperTextView) findViewById(R.id.weather_btn3);
        mWeatherBtn3.setOnClickListener(this);
        mWeatherBtn4 = (SuperTextView) findViewById(R.id.weather_btn4);
        mWeatherBtn4.setOnClickListener(this);
        mWeatherBtn5 = (SuperTextView) findViewById(R.id.weather_btn5);
        mWeatherBtn5.setOnClickListener(this);
        mHeadPic = (ImageView) findViewById(R.id.head_pic);
        mHeadPic.setOnClickListener(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.weather_btn_one:
                //map获取头像
                sendHeadPicRequest();
                break;
            case R.id.weather_btn11:
                //get获取天气
                sendWeatherRequest(Constant.PARAM_REQUEST);
                break;
            case R.id.weather_btn2:
                //post获取天气
                sendWeatherRequest(Constant.POST_REQUEST);
                break;
            case R.id.weather_btn3:
                //更换头像
                changeHeadPic(Constant.PIC_CHOOSE_SINGLE);
                break;
            case R.id.weather_btn4:
                //TODO 多图 该方法仅供参考，接口不用
                Toast.makeText(mContext, "多图(多文件)上传方法仅供参考，接口不用", Toast.LENGTH_SHORT).show();
                sendMorePicsRequest();
                break;
            case R.id.weather_btn5:
                //TODO 数组、集合 该方法仅供参考，接口不用
                Toast.makeText(mContext, "具体操作参考demo", Toast.LENGTH_SHORT).show();
                listData();
                break;
            case R.id.head_pic:
                //更换头像
                changeHeadPic(Constant.PIC_CHOOSE_SINGLE);
                break;

        }
    }

    /**
     * 上传多图（多文件）
     */
    private void sendMorePicsRequest() {
        Map<String, RequestBody> map = new HashMap<>();//一起上传的其他参数
        map.put("user_id", RequestBody.create(null, uid));
        map.put("token", RequestBody.create(null, "123abc"));
        map.put("parame", RequestBody.create(null, "parame"));
        Api api = HttpManager.getInstence().getApiService(Constant.BASE_URL);
        if (mFilesPart != null && mFilesPart.size() > 0) {
            api.getupLoadPicsData(map, mFilesPart)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<FileBean>() {
                        @Override
                        public void onSubscribe(Disposable disposable) {

                        }

                        @Override
                        public void onNext(FileBean dataBean) {
                            //TODO  网络请求成功后的操作
                            if (dataBean.getStatus() == 0) {
                                Toast.makeText(mContext, dataBean.getMsg(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } else {
            Toast.makeText(mContext, "请先添加图片", Toast.LENGTH_SHORT).show();
        }
    }

    private void listData() {
        List<String> lables = new ArrayList<>();
        lables.add("北京");
        lables.add("天津");
        lables.add("上海");
        lables.add("唐山");
        Api api = HttpManager.getInstence().getApiService(Constant.BASE_URL);
        api.getHeadPicsData(uid, lables)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MeBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        //TODO  网络请求前的操作，添加loading...
                    }

                    @Override
                    public void onNext(@NonNull MeBean dataBean) {
                        //更新界面数据
                        success(dataBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        //TODO  网络请求错误的操作，打印错误日志
                        Log.i("zxd", "断点：" + e);
                    }

                    @Override
                    public void onComplete() {
                        //TODO  网络请求完成后的操作
                    }
                });
    }

    /**
     * 获取用户头像Post
     */
    private void sendHeadPicRequest() {
        Map<String, RequestBody> map = new HashMap<>();
        map.put("uid", RequestBody.create(null, uid));
        map.put("token", RequestBody.create(null, "abc123"));
        Api api = HttpManager.getInstence().getApiService(Constant.BASE_URL);
        api.getHeadPicData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MeBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        //TODO  网络请求前的操作，添加loading...
                        CustomProgressDialog.show(mContext, "请稍后...");
                    }

                    @Override
                    public void onNext(@NonNull MeBean dataBean) {
                        //更新界面数据
                        success(dataBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        //TODO  网络请求错误的操作，打印错误日志
                        Log.i("zxd", "断点：" + e);
                        CustomProgressDialog.stopLoading();
                    }

                    @Override
                    public void onComplete() {
                        //TODO  网络请求完成后的操作
                        CustomProgressDialog.stopLoading();
                    }
                });
    }

    /**
     * 更换头像（上传图片）
     */
    private void changeHeadPic(int type) {
        if (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(mActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //没有获取权限，发起申请，不同之处
            ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else if (type == 1) {
            //选择单张图片
            PictureSelector.create(mActivity)
                    .openGallery(PictureMimeType.ofImage())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                    .loadImageEngine(GlideEngine.createGlideEngine())// 外部传入图片加载引擎，必传项
                    .theme(R.style.picture_default_style)// 主题样式设置 具体参考 values/styles   用法：R.style.picture.white.style v2.3.3后 建议使用setPictureStyle()动态方式
                    .isWeChatStyle(false)// 是否开启微信图片选择风格
                    .isUseCustomCamera(false)// 是否使用自定义相机
                    .setLanguage(LanguageConfig.CHINESE)// 设置语言，默认中文
                    .isWithVideoImage(true)// 图片和视频是否以同选,只在ofAll模式下有效
                    .maxVideoSelectNum(2) // 视频最大选择数量，如果没有单独设置的需求则以不设置，同用maxSelectNum字段
                    .imageSpanCount(4)// 每行显示个数
                    .isReturnEmpty(false)// 未选择数据时点击按钮是否以返回
                    .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)// 设置相册Activity方向，不设置默认使用系统
                    .isOriginalImageControl(false)// 是否显示原图控制按钮，如果设置为true则用户以自由选择是否使用原图，压缩、裁剪功能将会失效
                    .selectionMode(PictureConfig.SINGLE)// 多选 or 单选
                    .isSingleDirectReturn(false)// 单选模式下是否直接返回，PictureConfig.SINGLE模式下有效
                    .previewImage(true)// 是否预览图片
                    .previewVideo(false)// 是否预览视频
                    .enablePreviewAudio(false) // 是否播放音频
                    .isCamera(true)// 是否显示拍照按钮
                    .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                    .enableCrop(true)// 是否裁剪
                    .compress(true)// 是否压缩
                    .synOrAsy(true)//同步true或异步false 压缩 默认同步
                    .withAspectRatio(1, 1)// 裁剪比例 如16:9 3:2 3:4 1:1 自定义
                    .hideBottomControls(true)// 是否显示uCrop工具栏，默认不显示
                    .isGif(false)// 是否显示gif图片
                    .freeStyleCropEnabled(false)// 裁剪框是否拖拽
                    .circleDimmedLayer(false)// 是否圆形裁剪
                    .rotateEnabled(false) // 裁剪是否旋转图片
                    .showCropFrame(false)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false
                    .showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false
                    .openClickSound(false)// 是否开启点击声音
                    .cutOutQuality(90)// 裁剪输出质量 默认100
                    .minimumCompressSize(100)// 小于100kb的图片不压缩
                    .forResult(PictureConfig.SINGLE);//结果回调onActivityResult code
        }
    }

    private void sendWeatherRequest(final int type) {
        final String city = "北京";//测试用，具体需获取用户位置
        Api api = HttpManager.getInstence().getApiService(Constant.WEATHER);
        if (type == 1) {
            api.getWeatherData(city, Constant.WEATHER_KEY)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<WeatherBean>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {
                            //TODO  网络请求前的操作，添加loading...
                            CustomProgressDialog.show(mContext, "请稍后...");
                        }

                        @Override
                        public void onNext(@NonNull WeatherBean dataBean) {
                            //更新界面数据
                            if (dataBean.getCode().equals("10000")) {
                                //TODO  网络请求成功后的操作
                                showDialog(dataBean, type);
                            }
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            //TODO  网络请求错误的操作，打印错误日志
                            Log.i("zxd", "断点：" + e);
                            CustomProgressDialog.stopLoading();
                        }

                        @Override
                        public void onComplete() {
                            //TODO  网络请求完成后的操作
                            CustomProgressDialog.stopLoading();
                        }
                    });
        } else if (type == 6) {
            api.getWeather2Data(city, Constant.WEATHER_KEY)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<WeatherBean>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {
                            //TODO  网络请求前的操作，添加loading...
                            CustomProgressDialog.show(mContext, "请稍后...");
                        }

                        @Override
                        public void onNext(@NonNull WeatherBean dataBean) {
                            //更新界面数据
                            if (dataBean.getCode().equals("10000")) {
                                //TODO  网络请求成功后的操作
                                showDialog(dataBean, type);
                            }
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            //TODO  网络请求错误的操作，打印错误日志
                            Log.i("zxd", "断点：" + e);
                            CustomProgressDialog.stopLoading();
                        }

                        @Override
                        public void onComplete() {
                            //TODO  网络请求完成后的操作
                            CustomProgressDialog.stopLoading();
                        }
                    });
        }
    }

    private void showDialog(WeatherBean dataBean, final int type) {
        new XPopup.Builder(mContext)
                //                         .dismissOnTouchOutside(false)
                .autoDismiss(true)
                .popupAnimation(PopupAnimation.ScaleAlphaFromCenter)
                .asConfirm("今日提醒", dataBean.getResult().getHeWeather5().get(0).getBasic().getCnty() + dataBean.getResult().getHeWeather5().get(0).getBasic().getCity() + dataBean.getResult().getHeWeather5().get(0).getBasic().getUpdate().getUtc() +
                                "\n" + dataBean.getResult().getHeWeather5().get(0).getNow().getWind().getDir() + ":" + dataBean.getResult().getHeWeather5().get(0).getNow().getWind().getSpd() +
                                "级\n" + dataBean.getResult().getHeWeather5().get(0).getNow().getCond().getTxt() + " " + dataBean.getResult().getHeWeather5().get(0).getDaily_forecast().get(0).getTmp().getMin() + "℃ - " + dataBean.getResult().getHeWeather5().get(0).getDaily_forecast().get(0).getTmp().getMax() + "℃" +
                                "\n" + dataBean.getResult().getHeWeather5().get(0).getSuggestion().getComf().getTxt(),
                        "取消", "确定",
                        new OnConfirmListener() {
                            @Override
                            public void onConfirm() {
                                if (type == 1) {
                                    MyToast.showToastCenterText(mContext, "get请求", Toast.LENGTH_SHORT);
                                } else if (type == 6) {
                                    MyToast.showToastCenterText(mContext, "post请求", Toast.LENGTH_SHORT);
                                }
                            }
                        }, null, false)
                .show();
    }

    /**
     * 选择图片的回调
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.SINGLE:
                    // 图片选择结果回调 单图
                    selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩的
                    for (LocalMedia media : selectList) {
                        if (media.isCompressed()) {
                            headLocation = media.getCompressPath();
                        }
                    }
                    getHeadData();
                    break;
                case PictureConfig.MULTIPLE:
                    // 图片选择结果回调 多图
                    selectLists = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩的
                    morePicLists.clear();
                    for (LocalMedia media : selectLists) {
                        if (media.isCompressed()) {
                            morePicLists.add(media.getCompressPath());
                        }
                    }
                    mAdapter.setList(selectLists);
                    mAdapter.notifyDataSetChanged();
                    //选择多图
                    sendPicsRequest();
                    break;
            }
        }
    }

    /**
     * 上传多图
     */
    private void sendPicsRequest() {
        //TODO  add_pics换成自己的参数名，后面必须添加[]
        mFilesPart = new ArrayList<>();
        for (int i = 0; i < morePicLists.size(); i++) {
            File file = new File(morePicLists.get(i));
            RequestBody requestFile = RequestBody.create(MediaType.parse("image/png"), file);
            MultipartBody.Part part = MultipartBody.Part.createFormData("add_pics[]", file.getName(), requestFile);
            mFilesPart.add(part);
        }
    }

    /**
     * 上传图片文件到服务器，头像
     */
    private void getHeadData() {
        Map<String, RequestBody> map = new HashMap<>();
        map.put("user_id", RequestBody.create(null, uid));
        file = new File(headLocation);
        //1、创建RequestBoddy
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/png"), file);
        //2、创建MultipartBody.Part，其中需要注意第一个参数需要与服务器对应
        final MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        //3、创建`MultipartBody.Part`，其中需要注意第一个参数`fileUpload`需要与服务器对应,也就是`键`
        Api api = HttpManager.getInstence().getApiService(Constant.BASE_URL);
        api.getupLoadPicData(map, part)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.from(Looper.getMainLooper()))
                .subscribe(new Observer<FileBean>() {
                    @Override
                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {
                        CustomProgressDialog.show(mContext, "请稍后...");
                    }

                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull FileBean fileBean) {
                        // 清空图片缓存，包括裁剪、压缩后的图片 注意:必须要在上传完成后调用 必须要获取权限
                        if (fileBean.getStatus() == 0) {
                            //包括裁剪和压缩后的缓存，要在上传成功后调用，type 指的是图片or视频缓存取决于你设置的ofImage或ofVideo 注意：需要系统sd卡权限
                            PictureFileUtils.deleteCacheDirFile(mContext, PictureMimeType.ofImage());
                            // 清除所有缓存 例如：压缩、裁剪、视频、音频所生成的临时文件
                            PictureFileUtils.deleteAllCacheDirFile(mContext);
                        }
                        RequestOptions options = new RequestOptions()
                                .circleCrop();
                        Glide.with(mContext)
                                .load(fileBean.getData())
                                .apply(options)
                                .into(mHeadPic);
                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                        CustomProgressDialog.stopLoading();
                    }

                    @Override
                    public void onComplete() {
                        CustomProgressDialog.stopLoading();
                    }
                });
    }
}
