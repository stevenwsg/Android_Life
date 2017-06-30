## 智能管家问题点

如果同学们遇到项目中的一些问题，或者说是一些差别，可以看这里，一般都能找到答案

- 1.为什么我运行不了这个项目
如果你导入这个项目发现运行不了，或者出现配置信息错误，可以参考我的开发环境

    - Gradle 版本:com.android.tools.build:gradle:2.2.2
    - JDK 版本: 1.8.0_101
    - Android Studio：2.2.2
    - minSdkVersion：21
    - targetSdkVersion 24

这样的情况帮你可以百度是否能解决，不行的话，可以新建一个项目，把相关代码/资源文件拷贝过去即可，再不行，请加课程QQ交流群

- 2.为什么我在Android6.0的模拟器上运行会报错
这是因为Android6.0权限需要动态获取，和RxVolley的缓存策略有一定的冲突，只需要把app/build.gradle里的

```java
compile'com.kymjs.rxvolley:rxvolley:1.1.0'
```

版本更改为1.1.2即可解决

- 3.为什么我的归属地查询不出现图片
这是因为聚合数据官方API的改动所导致的,归属地查询API地址:

    - https://www.juhe.cn/docs/api/id/11

我们解析api获取json数据的时候可以发现这么一段代码

```java
{
    "resultcode":"200",
    "reason":"Return Successd!",
    "result":{
        "province":"浙江",
        "city":"杭州",
        "areacode":"0571",
        "zip":"310000",
        "company":"中国移动",
        "card":"移动动感地带卡"
    }
}
```

而我们是根据"company":"中国移动"这个字段来显示图片的，所以你在代码中一定可以看到这样的一段代码

```java
   switch (company) {
       case "中国移动":
           iv_company.setBackgroundResource(R.drawable.china_mobile);
           break;
        case "中国联通":
           iv_company.setBackgroundResource(R.drawable.china_unicom);
            break;
         case "中国电信":
            iv_company.setBackgroundResource(R.drawable.china_telecom);
            break;
      }
```

而在最新的API中，company中已经没有中国两个字了，所以你只要去掉这三个中国，就可以了

- 4.为什么我的二维码扫描会出现一个camera error的提示框
因为需要调用相机，模拟器上是没有硬件的，请使用真机

- 5.为什么我的百度地图没有显示
百度地图没有显示无外乎两个原因

    - -1.key无效
    - -2.模拟器

这两个问题都很简单，如果你是key无效的话，只需要注意一下控制台有没有输出appkey无效的字段即可发现，解决起来也很简单
在百度地图的官网上申请一个key，然后替换代码中的value值

```java
 <meta-data
     android:name="com.baidu.lbsapi.API_KEY"
     android:value="KIXaj3dCXGF2FsBGGyDoOl1vEMNeq8Wn" />
```

第二种情况是模拟器，因为硬件需要，所以模拟器不会显示地图，请使用真机就可以避免

- 6.美女社区加载多图OOM
这个我们可用做很多的优化方式，最常用的是加入缓存，这里我们也可以降低加载图片的色值，所以在工具类中我们可用这样更改

```java
    //默认加载图片(指定大小)
    public static void loadImageViewSize(Context mContext, String url, int width, int height, ImageView imageView) {
        Picasso.with(mContext).load(url).config(Bitmap.Config.RGB_565).resize(width, height).centerCrop().into(imageView);
    }
```

- 7.美女突破Json解析获取不到数据

这是因为Gank的接口升级所导致的，原先的接口是


```java
	http://gank.io/api/search/query/listview/category/福利/count/50/page/1
```

但是接口不能出现中文字，所有我们要对福利这两个字进行转码

```java
		String welfare = null;
        try {
            //Gank升級 需要转码
            welfare = URLEncoder.encode(getString(R.string.text_welfare), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
		
		//最终请求的接口
		http://gank.io/api/search/query/listview/category/"+welfare+"/count/50/page/1

```

- 8.为什么我的二维码扫描/生成没有

因为我把项目给你导入会出现各种环境冲突， 所有我建议你还是自己手动导入，导入之后，只需要把SettingActivity中第149行，ll_scan点击事件的注释打开就有扫描了，同时在QrCodeActivity中打开所有代码注释，就有生成的功能

如何导入？这个视频中有步骤


后续还有其他问题将同步在此文档中