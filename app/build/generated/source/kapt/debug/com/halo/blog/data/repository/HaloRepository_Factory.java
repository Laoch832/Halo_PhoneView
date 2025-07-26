package com.halo.blog.data.repository;

import com.halo.blog.data.api.HaloApiService;
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
public final class HaloRepository_Factory implements Factory<HaloRepository> {
  private final Provider<HaloApiService> apiServiceProvider;

  public HaloRepository_Factory(Provider<HaloApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public HaloRepository get() {
    return newInstance(apiServiceProvider.get());
  }

  public static HaloRepository_Factory create(Provider<HaloApiService> apiServiceProvider) {
    return new HaloRepository_Factory(apiServiceProvider);
  }

  public static HaloRepository newInstance(HaloApiService apiService) {
    return new HaloRepository(apiService);
  }
}
