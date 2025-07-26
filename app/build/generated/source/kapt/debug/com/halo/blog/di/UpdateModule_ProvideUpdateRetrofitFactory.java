package com.halo.blog.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
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
public final class UpdateModule_ProvideUpdateRetrofitFactory implements Factory<Retrofit> {
  private final Provider<OkHttpClient> okHttpClientProvider;

  public UpdateModule_ProvideUpdateRetrofitFactory(Provider<OkHttpClient> okHttpClientProvider) {
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public Retrofit get() {
    return provideUpdateRetrofit(okHttpClientProvider.get());
  }

  public static UpdateModule_ProvideUpdateRetrofitFactory create(
      Provider<OkHttpClient> okHttpClientProvider) {
    return new UpdateModule_ProvideUpdateRetrofitFactory(okHttpClientProvider);
  }

  public static Retrofit provideUpdateRetrofit(OkHttpClient okHttpClient) {
    return Preconditions.checkNotNullFromProvides(UpdateModule.INSTANCE.provideUpdateRetrofit(okHttpClient));
  }
}
