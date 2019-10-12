
# viewlib（搭建MVP框架UI组件）
   
## 1. Features

- view(基础UI库，使用框架时必用) 

1. banner（轮播图）   
2. FlowLayout
3. LoadingLayout
4. SmartRefreshLayout
5. SwipeBackLayout
6. 加载动画 

   -  [CircularLoaderView](./view/src/main/java/com/flyang/view/loader/CircularLoaderView) 圆形加载动画
   -  [IndicatorLoadingView](./view/src/main/java/com/flyang/view/loader/IndicatorLoadingView)多样式加载动画
   -  [IOSLoaderView](./view/src/main/java/com/flyang/view/loader/IOSLoaderView) ios样式的加载动画
   -  [ShapeLoadingView](./view/src/main/java/com/flyang/view/loader/ShapeLoadingView)  自由落体加载动画
   -  [SpinKitLoadingView](./view/src/main/java/com/flyang/view/loader/SpinKitLoadingView) 多样式加载动画
7. CircleProgressView

8. CircularAnim（圆形水波纹动画类）
    
   例：
---
    CircularAnim.fullActivity(MainActivity.this, view)
                       .colorOrImageRes(R.color.color_2E8B57)
                       .go(new CircularAnim.OnAnimationEndListener() {
                           @Override
                           public void onAnimationEnd() {
                               ActivityUtils.startActivity(BannerActivity.class);
                           }
                       });
---
        
9. StickyNestedScrollView
   
   - 吸顶ScrollView，给子控件添加tag
        1.  sticky
        2.  -nonconstant
        3.  -hastransparency
 
- expandview（扩展UI库）
  view库中扩展动画（不建议直接依赖，会有很多不必要代码，建议选择自己要用的动画移到view中使用，对应包名和view相同）  
       

## 3. Skills
* [给自己的笔记,记录jitpack和nexus两种使用utillib方式](./doc/configure.md)

* 感谢GitHub开源项目支持