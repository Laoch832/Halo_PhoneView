package com.halo.blog.data.api;

import com.halo.blog.utils.PreferenceManager;
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
public final class NetworkModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<PreferenceManager> preferenceManagerProvider;

  public NetworkModule_ProvideRetrofitFactory(Provider<OkHttpClient> okHttpClientProvider,
      Provider<PreferenceManager> preferenceManagerProvider) {
    this.okHttpClientProvider = okHttpClientProvider;
    this.preferenceManagerProvider = preferenceManagerProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(okHttpClientProvider.get(), preferenceManagerProvider.get());
  }

  public static NetworkModule_ProvideRetrofitFactory create(
      Provider<OkHttpClient> okHttpClientProvider,
      Provider<PreferenceManager> preferenceManagerProvider) {
    return new NetworkModule_ProvideRetrofitFactory(okHttpClientProvider, preferenceManagerProvider);
  }

  public static Retrofit provideRetrofit(OkHttpClient okHttpClient,
      PreferenceManager preferenceManager) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideRetrofit(okHttpClient, preferenceManager));
  }
}
