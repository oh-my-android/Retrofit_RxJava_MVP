package com.example.y.mvp.utils.swipeback;

public interface SwipeBackActivityBase {
    
    SwipeBackLayout getSwipeBackLayout();

    void setSwipeBackEnable(boolean enable);

    void scrollToFinishActivity();
}
