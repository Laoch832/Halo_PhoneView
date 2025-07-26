package com.halo.blog.utils;

import com.halo.blog.data.api.UpdateApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UpdateChecker_Factory implements Factory<UpdateChecker> {
  private final Provider<UpdateApiService> updateApiServiceProvider;

  public UpdateChecker_Factory(Provider<UpdateApiService> updateApiServiceProvider) {
    this.updateApiServiceProvider = updateApiServiceProvider;
  }

  @Override
  public UpdateChecker get() {
    return newInstance(updateApiServiceProvider.get());
  }

  public static UpdateChecker_Factory create(Provider<UpdateApiService> updateApiServiceProvider) {
    return new UpdateChecker_Factory(updateApiServiceProvider);
  }

  public static UpdateChecker newInstance(UpdateApiService updateApiService) {
    return new UpdateChecker(updateApiService);
  }
}
