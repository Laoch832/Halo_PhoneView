package com.halo.blog.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AutoUpdateWorker_AssistedFactory_Impl implements AutoUpdateWorker_AssistedFactory {
  private final AutoUpdateWorker_Factory delegateFactory;

  AutoUpdateWorker_AssistedFactory_Impl(AutoUpdateWorker_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public AutoUpdateWorker create(Context context, WorkerParameters parameters) {
    return delegateFactory.get(context, parameters);
  }

  public static Provider<AutoUpdateWorker_AssistedFactory> create(
      AutoUpdateWorker_Factory delegateFactory) {
    return InstanceFactory.create(new AutoUpdateWorker_AssistedFactory_Impl(delegateFactory));
  }
}
