package com.company.ui.base;

/**
 * Created by FingerArt on 2018/8/29.
 */
public class BasePresenter<V extends IView> implements IPresenter, LifecycleManager.ILifecycle {

    protected final IView view;

    public BasePresenter(IView view) {
        this.view = view;
        LifecycleManager.hook(view, this);
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onResumeOnlyOnce() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onDestroy() {
    }

}
