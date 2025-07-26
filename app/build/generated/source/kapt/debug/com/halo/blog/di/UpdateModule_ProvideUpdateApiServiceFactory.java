package com.halo.blog.di;

import com.halo.blog.data.api.UpdateApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("com.halo.blog.di.UpdateRetrofit")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UpdateModule_ProvideUpdateApiServiceFactory implements Factory<UpdateApiService> {
  private final Provider<Retrofit> updateRetrofitProvider;

  public UpdateModule_ProvideUpdateApiServiceFactory(Provider<Retrofit> updateRetrofitProvider) {
    this.updateRetrofitProvider = updateRetrofitProvider;
  }

  @Override
  public UpdateApiService get() {
    return provideUpdateApiService(updateRetrofitProvider.get());
  }

  public static UpdateModule_ProvideUpdateApiServiceFactory create(
      Provider<Retrofit> updateRetrofitProvider) {
    return new UpdateModule_ProvideUpdateApiServiceFactory(updateRetrofitProvider);
  }

  public static UpdateApiService provideUpdateApiService(Retrofit updateRetrofit) {
    return Preconditions.checkNotNullFromProvides(UpdateModule.INSTANCE.provideUpdateApiService(updateRetrofit));
  }
}
