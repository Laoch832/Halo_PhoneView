package com.halo.blog.di;

import com.halo.blog.data.api.UpdateApiService;
import com.halo.blog.utils.UpdateChecker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class UpdateModule_ProvideUpdateCheckerFactory implements Factory<UpdateChecker> {
  private final Provider<UpdateApiService> updateApiServiceProvider;

  public UpdateModule_ProvideUpdateCheckerFactory(
      Provider<UpdateApiService> updateApiServiceProvider) {
    this.updateApiServiceProvider = updateApiServiceProvider;
  }

  @Override
  public UpdateChecker get() {
    return provideUpdateChecker(updateApiServiceProvider.get());
  }

  public static UpdateModule_ProvideUpdateCheckerFactory create(
      Provider<UpdateApiService> updateApiServiceProvider) {
    return new UpdateModule_ProvideUpdateCheckerFactory(updateApiServiceProvider);
  }

  public static UpdateChecker provideUpdateChecker(UpdateApiService updateApiService) {
    return Preconditions.checkNotNullFromProvides(UpdateModule.INSTANCE.provideUpdateChecker(updateApiService));
  }
}
