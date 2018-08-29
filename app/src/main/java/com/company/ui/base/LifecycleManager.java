package com.company.ui.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;

/**
 * Presenter生命周期管理
 * <p>
 * Created by FingerArt on 2018/8/29.
 */
public final class LifecycleManager implements LifecycleObserver {

    private LifecycleOwner view;
    private ILifecycle observer;
    private boolean onlyOnceResumed;

    public LifecycleManager(@NonNull IView view, @NonNull ILifecycle observer) {
        // TODO: 2018/8/29 类型&空检测
        if (view instanceof LifecycleOwner) {
            this.view.getLifecycle().addObserver(this);
            this.view = (LifecycleOwner) view;
            this.observer = observer;
        }
    }

    public static void hook(IView view, ILifecycle observer) {
        new LifecycleManager(view, observer);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onViewCreate() {
        observer.onCreate();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onViewStart() {
        observer.onStart();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onViewResume() {
        observer.onResume();
        if (!onlyOnceResumed) {
            onlyOnceResumed = true;
            observer.onResumeOnlyOnce();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onViewPause() {
        observer.onPause();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onViewStop() {
        observer.onStop();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onViewDestroy() {
        observer.onDestroy();
        view.getLifecycle().removeObserver(this);
    }

    public interface ILifecycle {

        void onCreate();

        void onStart();

        void onResume();

        void onResumeOnlyOnce();

        void onPause();

        void onStop();

        void onDestroy();
    }
}
