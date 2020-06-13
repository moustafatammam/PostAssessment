package com.projects.android.data.executor;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class JobExecutor_Factory implements Factory<JobExecutor> {
  private static final JobExecutor_Factory INSTANCE = new JobExecutor_Factory();

  @Override
  public JobExecutor get() {
    return new JobExecutor();
  }

  public static JobExecutor_Factory create() {
    return INSTANCE;
  }

  public static JobExecutor newInstance() {
    return new JobExecutor();
  }
}
